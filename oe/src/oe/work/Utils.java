package oe.work;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static void main(String[] args){
		/*
		 * Method check the valid date and return true & false
		 */
		TestDateParser obj = new TestDateParser();
		//System.out.println("isValid - dd/MM/yyyy with 20130925 = " + dateParserObj.isValidFormat("dd/MM/yyyy", "20130925"));
        System.out.println("isValid - dd/MM/yyyy with 25/09/2013 = " + obj.isValidFormat("dd/MM/yyyy", "25/09/2013"));
        System.out.println("isValid - dd/MM/yyyy with 25/09/2013 12:13:50 = " + obj.isValidFormat("dd/MM/yyyy", "25/09/2013 12:13:50"));
        System.out.println("isValid - dd/MM/yyyy with 23/09/2011 20:43:52,617000000 = " + obj.isValidFormat("dd/MM/yyyy hh:mm:ss,SSSSSSSSS", "23/09/2011 20:43:52,617000000"));
        
        System.out.println("Given Date String format (23/09/2011 20:43:52,617000000) & Required (MM/dd/yyyy HH:mm:ss) : "+obj.convertToAtgRequiredFormat("23/09/2011 20:43:52,617000000"));
        System.out.println("Given Date String format (23/09/2011 20:43:52) & Required (MM/dd/yyyy HH:mm:ss) : "+obj.convertToAtgRequiredFormat("23/09/11 20:43:52,617000000"));
	}
}

class TestDateParser {

    public boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
    
    /*
     * This method convert the given format <p>DATE</p> in ATG date format
     */
    public String convertToAtgRequiredFormat(String dateInString){
    	
    	int dateStrLen= validDateLen(dateInString.length());
    	
    	SimpleDateFormat sourceformatter = getsourceformatter(dateStrLen);
    	SimpleDateFormat requiredFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	
		Date date=null;
		try {
			date = (Date)sourceformatter.parse(dateInString);
		} catch (Exception e) {
			System.out.println("Format of the given date is not valid, we support these format - 23/09/2015 20:43:52,617000000 or 23/09/15 20:43:52,617000000 or 23/09/2011");
			e.printStackTrace();
		}
    	
    	return requiredFormatter.format(date);
    }
	
    private SimpleDateFormat getsourceformatter(int dateStrLen) {
    	SimpleDateFormat sourceformatter=null;
    	if(dateStrLen == 8){
    		sourceformatter = new SimpleDateFormat("dd/MM/yy");
    	}else if(dateStrLen == 17){
    		sourceformatter = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
    	}else if(dateStrLen == 19){
    		sourceformatter = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
    	}
		return sourceformatter;
	}
    
	private int validDateLen(int dateLen) {
		//IF date is 23/09/2011 20:43:52,617000000
		if(dateLen==29) {
			return 19;
		}else if(dateLen==27){
			// if 23/09/16 20:43:52,617000000
			return 17;
		}else if(dateLen == 8){
			// if 23/09/16
			return 8;
		}
		return 0;
	}
}
