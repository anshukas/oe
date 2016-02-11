package oe.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class PagoFacil {

	private static final String ENDPOINT = "";
	private static final String USER_Credential = "";
	
	private static final String GRANT_TYPE = "grant_type";
	private static final String SCOPE = "scope";
	private static final String BASIC = "Basic";
	private static final String JSON_CONTENT="application/json";
	private static final Object ACCESS_TOKEN = "access_token";
	private static final String BEARER = "Bearer";
	private static final String PAGOFACIL_URL="";
				
		public static void main(String[] args) throws Exception{
			String token = getAccessToken();
			System.out.println(token);
			callPagoFacilService(token);
		}
		
		
		public static void callPagoFacilService(String accessToken) throws Exception {
			
				HttpPost post = new HttpPost(PAGOFACIL_URL);
				
				//Add header auhtorization access token
				String authToken = getAuthorizationHeaderForAccessToken(accessToken);
				post.addHeader("Content-Type", "application/json");
				post.addHeader("Authorization", authToken);
				
				HttpParams httpParameters = new BasicHttpParams();
				DefaultHttpClient client = new DefaultHttpClient(httpParameters);
				HttpResponse response = null;
				
				// load the data in request
				String dataParams = loadRequestDataJsonString();
				System.out.println(dataParams);
				post.setEntity(new StringEntity(dataParams));
				response =client.execute(post);
				int code = response.getStatusLine().getStatusCode();
				
				System.out.println(code);
				String responseData = new BasicResponseHandler().handleResponse(response);
				System.out.println(responseData);
		}
		private static String getAuthorizationHeaderForAccessToken(String accessToken) {
			return BEARER+" "+accessToken;
		}
		
		/**
		 * @return
		 * @throws JSONException
		 */
		private static String loadRequestDataJsonString() throws JSONException {
			// TODO Auto-generated method stub
			JSONObject data=new JSONObject();
				data.put("orderId", Long.valueOf("2999135"));
				data.put("userId", Long.valueOf("000164966"));
				data.put("userName", "María Cecilia\\\\");
				data.put("orderDate", "2015-11-02");
				data.put("orderValue", "2760,85".replace(',', '.'));
				data.put("storeCode", "L_NETSHOES_AR");
			
			return data.toString();
		}
		
		public static String getAccessToken() throws Exception {
			String token=null;
			HttpPost post = new HttpPost(ENDPOINT);
			String scope = "read write";
			String grantType= "client_credentials";
			
			List<BasicNameValuePair> parameterBody = new ArrayList<BasicNameValuePair>();
			parameterBody.add(new BasicNameValuePair(GRANT_TYPE, grantType));
			parameterBody.add(new BasicNameValuePair(SCOPE, scope));
			
			HttpParams httpParameters = new BasicHttpParams();
			DefaultHttpClient client = new DefaultHttpClient(httpParameters);
			
			HttpResponse response = null;
			
				post.setEntity(new UrlEncodedFormEntity(parameterBody, HTTP.UTF_8));
				post.addHeader("Authorization",getBasicAuthorizationHeader(USER_Credential));
				response = client.execute(post);
				int code = response.getStatusLine().getStatusCode();
				
				//handle the security service response
				if(code == 200){
					Map<String, String> map = handleRespone(response);
					if(map!=null){
						token= map.get(ACCESS_TOKEN);
					}
				}else {
					throw new Exception("Failed : HTTP code"+ code);
				}
				if(client!=null){
					client.getConnectionManager().shutdown();
				}
			return token;
		}
		private static String getBasicAuthorizationHeader(String uCredential) {
			// TODO Auto-generated method stub
			return BASIC+" " +encodeCredentials(uCredential);
		}

		private static String encodeCredentials(String cred) {
			// TODO Auto-generated method stub
			String encodedValue=null;
			byte[] encodedBytes = Base64.encodeBase64(cred.getBytes());
			encodedValue = new String(encodedBytes);
			return encodedValue;
		}
		
		private static Map<String, String> handleRespone(HttpResponse response) {
			// TODO Auto-generated method stub
			String contentType=null;
			if(response.getEntity().getContentType()!=null){
				contentType=response.getEntity().getContentType().getValue();
			}
			if(contentType.contains(JSON_CONTENT)){
				return handleJsonResponse(response);
			}else{
				// Unsupported Content type
				throw new RuntimeException("Cannot handle response : "+ contentType + " content type. Supported content types is JSON only");
			}
		}

		private static Map<String, String> handleJsonResponse(HttpResponse response) {
			// TODO Auto-generated method stub
			Map<String, String> oauthResponse = null;
			try {
				String responseData = new BasicResponseHandler().handleResponse(response);
				oauthResponse = (Map<String, String>) new JSONParser().parse(responseData);
			} catch (Exception e) {
			} 
			return oauthResponse;
		}
	}
	