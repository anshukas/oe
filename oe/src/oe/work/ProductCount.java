package oe.work;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductCount {
	public static void main(String [] args){
		Process obj = new Process();
		obj.processDone();
	}
}

class Process{
	private static String SKU_STRING = "238-0025-002,238-0025-022,238-0026-009,238-0027-006,019-0301-042,168-0014-005,001-1892-076,141-0034-002,002-1117-551,001-0913-360,261-0012-003,018-1181-121,026-0047-084,001-1822-002,128-0049-281,229-0002-022"
			+ ",223-0019-002,114-0243-060,155-0518-003,001-1495-033,001-2021-009,155-0529-061,155-0523-044,223-0027-360,001-2226-225,270-0005-007,155-0389-012,267-0005-210,001-2226-005,223-0035-196,024-0052-001,001-2234-003,038-0215-059,018-1713-1"
			+ "21,309-0024-002,026-0034-268,002-1058-182,038-9202-044,155-0007-002,155-0375-003,155-0011-044,019-0063-059,223-0013-360,028-0043-065,019-0259-061,026-0048-194,250-0065-251,261-0003-089,001-0994-319,168-0035-196,115-0099-002,155-0223-"
			+ "157,019-0012-138,213-0023-061,066-0096-568,040-1003-437,038-0091-145,038-0042-057,003-0847-002,001-0985-030,257-0010-382,038-0114-056,128-0051-151,024-2079-001,001-0812-020,001-1452-037,018-0061-061,001-0975-187,038-0183-020,003-0891"
			+ "-044,003-0827-039,019-0054-001,001-0853-042,019-0012-063,250-0019-062,001-1166-194,155-0373-001,155-0463-044,155-0374-001,155-0373-003,001-0517-002,014-0442-063,001-2155-059,025-0100-009,261-0018-236,059-0177-001,026-0036-156,038-013"
			+ "1-197,015-0106-414,155-0138-003,014-0599-130,188-0085-360,155-0523-003,155-0166-095,001-2215-002,024-0118-046,025-0016-112,001-0955-001,123-0024-057,001-1886-001,066-0101-210,155-0530-061,123-0005-057,019-0251-117,002-0591-098,001-22"
			+ "17-003,253-0036-381,025-4530-003,001-2232-225,152-0079-007,001-0875-122,061-0153-091,001-2216-006,038-0238-172,001-1821-002,056-0024-033,038-0182-011,019-0278-079,238-0007-105,019-0252-117,001-1545-003,123-0029-063,002-0004-042,123-0"
			+ "009-006,238-0031-225,123-0002-055,001-1741-225,038-0161-477,137-0033-022,056-0028-511,213-0026-011,001-0910-059,014-0157-002,250-0017-225,001-2216-002,225-0033-230,001-2221-061,014-0600-061,001-1805-001,105-0124-013,059-0177-122,088-"
			+ "1817-038,007-0086-003,003-0807-006,038-0131-078,003-0684-059,151-0030-010,250-0034-002,223-0002-001,027-0309-197,038-0214-359,003-0759-029,001-1427-117,059-0177-009,015-0035-042,239-0020-089,038-9202-038,066-0096-070,038-9202-042,213"
			+ "-0002-003,270-0004-029,223-0034-442,247-0014-005,026-0024-165,001-1854-117,002-1067-001,225-0032-054,249-0001-002,016-0144-003,115-0236-022,025-0003-002,256-0010-010,155-0498-012,155-0494-325,038-0180-004,001-0551-210,088-0032-017,111"
			+ "-0028-054,267-0011-586,028-0042-373,123-0002-062,123-0009-003,038-0108-044,123-0002-063,258-0004-002,038-0126-002,152-0043-197,038-0174-319,225-0018-197,002-0586-013,213-0003-003,001-2294-319,003-0473-139,014-0552-001,001-2295-005,15"
			+ "5-0471-001,038-0132-138,114-0217-007,225-0047-002,155-0305-001,001-1137-042,001-1651-346,001-1846-061,003-0806-022,253-0029-382,155-0362-061,036-2095-002,188-0043-030,155-0357-070,044-0501-002,238-0028-091,038-0251-414,058-0011-122,"
			+ "254-0012-049,058-0012-122,250-0018-349,164-0043-589,002-0825-386,240-0004-001,040-0055-367,004-0280-002,155-0535-044,001-0291-140,231-0015-197,151-0067-009,239-0029-121,155-0517-095,002-0004-046,155-0301-359,155-0307-360,231-0009-02"
			+ "8,092-0044-001,015-0120-011,203-0008-008,028-0018-063,252-0009-432,016-0144-002,270-0006-145,155-0124-061,002-1010-001,016-0044-106,002-0864-001,123-0002-056,236-0002-022,155-0473-001,270-0001-166,014-0326-080,236-0019-002,001-1427-0"
			+ "02,003-0904-022,249-0002-001,155-0358-070,198-0017-007,188-0045-559,223-0030-002,001-2246-127,188-0040-059,001-1115-001,066-0107-002,019-0259-007,083-0002-005,155-0126-095,155-0324-359,001-1837-010,114-0227-568,213-0027-007,036-2095-0"
			+ "03,115-0193-230,155-0522-061,025-4455-006,024-0113-061,059-0323-003,155-0525-003,114-0229-061,248-0017-566,168-0036-005,066-0096-021,164-0026-379,239-0035-056,001-1413-007,151-0073-212,088-0032-215,155-0359-061,032-0246-117,066-0093-0"
			+ "02,223-0021-002,200-0001-069,015-0120-004,066-0107-060,002-1106-222,253-0040-576,066-0096-030,155-0487-044,040-1003-004,155-0346-044,038-0172-002,028-0014-032,155-0101-069,155-0370-003,088-0047-059,110-0009-121,123-0002-060,016-0045-3"
			+ "59,015-0105-002,038-0177-001,038-0237-165,014-0316-002,028-0048-093,213-0004-005,003-0783-059,014-0646-062,002-0164-042,155-0473-002,236-0012-001,247-0004-002,019-0145-586,155-0124-039,188-0049-078,001-2116-007,248-0015-002,019-0315-1"
			+ "97,018-1713-022,014-0543-061,267-0004-009,001-1662-112,001-2223-002,250-0034-006,036-3094-066,213-0018-005,123-0030-234,092-2202-070,248-0023-007,001-1371-420,238-0042-222,249-0012-002,001-1956-007,238-0051-042,123-0029-139,001-2216-2"
			+ "25,155-0478-061,168-0043-196,223-0034-379,002-1057-118,019-0259-057,001-1881-002,015-0108-099,056-0008-137,016-0142-003,038-0163-057,223-0040-001,253-0027-382,038-0140-004,019-0259-063,001-2232-015,066-0106-002,027-0309-015,058-0009-"
			+ "122,001-1801-069,001-1505-122,120-0205-569,066-0093-070,001-2236-360,155-0192-002,123-0006-061,257-0005-383,155-0357-059,001-1355-012,123-0005-063,038-9202-046,270-0006-029,141-0022-059,019-0195-087,213-0013-065,213-0029-006,038-0174"
			+ "-011,038-0126-001,059-0323-001,003-0905-003,002-0973-072,001-0551-061,123-0028-006,001-2234-002,155-0464-044,036-2095-004,001-0848-002,001-2294-011,001-0919-172,155-0359-069,001-2233-007,155-0548-044,239-0030-121,003-0896-519,155-03"
			+ "88-044,019-0197-359,155-0018-007,151-0023-009,155-0304-292,223-0001-022,265-0001-002,152-0079-003,123-0024-061,083-0033-359,223-0022-002,002-1008-059,152-0003-003,123-0006-063,001-1549-002,007-0067-207,155-0489-559,038-0117-069,019-0"
			+ "254-117,002-1032-002,015-0120-225,038-0253-093,066-0095-153,038-0134-042,001-1358-319,001-0600-168,238-0025-005,015-0035-032,202-0010-002,155-0305-360,225-0032-080,014-3680-002,151-0060-300,001-1709-103,257-0006-382,152-0159-001,155-0366-095,123-0029-056,038-0115-032,123-0028-011,038-0236-003,038-0056-001,001-1204-016,001-1389-300,249-0015-002,152-0081-197,128-0012-002,154-0024-063,037-0034-197,001-1867-001,225-0053-002,155-0531-360,001-1389-003,261-0004-197,001-1138-189,003-0767-069,018-1181-005,128-0011-005,001-1101-059,239-0016-005,248-0004-057,114-0260-056,001-1521-470,155-0525-002,155-0546-414,024-0253-059,265-0002-002,001-1101-024,001-1649-028,040-5275-270,014-0486-212,001-1710-140,001-0861-360,248-0001-333,001-0547-002,253-0014-381,088-0101-044,004-1224-002,239-0020-007,061-0184-002,253-0006-383,213-0042-029,038-0154-183,001-0343-020,038-0208-197,014-0486-359,044-0501-319,016-0143-001,001-2226-286,213-0037-002,151-0045-032,001-1440-225,257-0003-383,257-0020-381,152-0158-002,155-0366-061,164-0009-383,056-0035-511,038-0239-004,038-0131-191,038-0055-165,038-0104-072,038-0177-122,088-0071-104,032-0274-059,038-0177-011,003-0801-022,001-1102-059,155-0540-044,037-0035-008,019-0012-080,236-0010-010,223-0034-011,236-0009-117,002-1031-001,001-0910-426,024-0129-063,155-0087-044,001-1498-005,001-0629-141,128-0102-361,253-0008-383,236-0016-002,155-0008-012,001-1975-059,128-0103-002,001-2293-002,110-0010-373,003-0644-024,001-2091-072,156-0029-192,238-0040-002,225-0029-193,249-0017-117,001-1067-020,155-0211-061,001-1869-084,001-0343-417,188-0050-413,058-0022-122,019-0253-117,155-0497-325,001-0862-029,001-1629-007,213-0004-006,061-0152-007,016-0102-001,123-0006-057,001-0491-001,001-0967-093,001-1818-022,168-0009-002,061-0153-209,001-2225-300,237-0004-183,001-0968-061,003-0876-007,016-0099-002,155-0301-360,003-0623-225,164-0014-381,155-0447-069,019-0313-012,066-0028-095,007-1511-099,155-0160-044,155-0257-360,001-2227-212,001-1627-230,015-0101-055,002-0820-125,164-0012-382,155-0392-197,001-0758-307,213-0031-032,155-0300-414,155-0126-003,001-2220-187,247-0007-022,001-2228-215,188-0042-069,038-0151-028,236-0009-404,248-0015-117,001-1520-022,247-0011-010,155-0356-069,001-2215-001,001-0956-016,155-0547-044,155-0600-008,225-0024-050,155-0535-095,003-0778-022,237-0005-156,058-0018-122,155-0353-044,003-0765-477,164-0002-382,164-0017-382,253-0043-382,123-0005-061,058-0021-089,016-0101-002,016-0007-003,238-0013-003,253-0004-384,061-0150-607,155-0288-044,155-0518-070,247-0004-117,128-0049-122,001-1449-226,083-0006-438,061-0150-192,155-0308-044,155-0018-002,155-0109-012,123-0002-057,114-0208-057,155-0357-069,200-0015-197,223-0034-431,155-0367-061,084-0021-455,155-0549-044,001-1844-225,001-2228-212,164-0020-382,155-0020-044,026-0028-242,155-0449-069,058-0010-122,003-0760-020,001-2225-421,015-0120-001,162-0012-084,164-0030-379,061-0155-226,003-0684-300,001-1515-304,155-0368-044,038-0140-006,155-0007-012,225-0029-056,003-0624-006,225-0022-012,162-0012-099,001-2088-016,115-0205-197,253-0010-384,003-0737-059,155-0295-061,016-0029-020,238-0027-007,155-0351-008,155-0453-069,155-0001-044,016-0142-001,155-0127-095,155-0296-359,056-0027-369,056-0031-033,003-0807-477,002-1044-059,032-0304-002,155-0399-061,155-0454-044,018-1713-004,058-0020-089,001-0491-093,164-0031-383,225-0035-112,066-0101-128,123-0024-272,250-0064-163,155-0097-003,225-0035-276,032-0300-348,016-0135-042,213-0009-003,016-0144-001,155-0011-061,155-0081-044,058-0016-122,225-0035-056,003-0801-001,066-0101-359,155-0306-360,155-0537-044,066-0107-030,155-0544-044,001-2223-001,155-0290-044,001-2159-042,155-0465-069,027-1361-067,002-0839-002,155-0019-039,001-0629-095,155-0098-001,061-0157-234,267-0014-117,155-0127-003,001-1627-001,238-0030-012,155-0018-359,155-0014-044,213-0041-002,019-0050-011,247-0011-052,155-0368-061,056-0013-099,155-0124-072,155-0327-033,155-0539-044,001-2159-016,164-0004-382,155-0302-197,155-0127-007,123-0026-001,155-0479-044,152-0101-197,164-0007-379,155-0296-414,238-0026-009,003-0903-015,238-0027-006,238-0025-002,155-0295-044,225-0036-056,155-0341-001,155-0448-069,088-0063-024,225-0034-197,155-0099-059,155-0176-044,025-4456-004,155-0519-095,225-0036-112,238-0025-022,002-1092-002,032-0207-002,225-0034-359,152-0100-001,155-0455-069,155-0386-072,168-0007-002,200-0016-197,155-0001-061,001-0969-002,001-2021-007,247-0007-002,001-1449-062,032-0304-005,014-0585-002,155-0543-069,248-0008-230,028-0008-065,168-0034-002,231-0008-139,203-0018-093,056-0026-477,001-0421-288,001-0757-049,001-1510-042,250-0042-222,155-0085-003,001-2296-360,016-0114-056,001-2155-042,155-0542-044,203-0029-021,018-0003-044,096-0550-062,238-0016-059,105-0111-360,002-1042-004,025-0010-059,002-1121-059,177-0002-196,058-0014-122,213-0043-052,223-0038-002,155-0170-044,247-0009-117,250-0058-084,002-0837-118,069-0148-022,253-0038-382,016-0142-011,027-0275-022,025-0007-055,155-0177-069,155-0128-072,001-0838-359,168-0040-037,001-1868-001,003-0759-020,001-1367-049,058-0015-122,014-0178-001,155-0387-042,250-0074-001,001-2021-006,238-0013-002,155-0290-414,001-1873-230,028-0017-234,040-0195-002,012-9150-044,203-0031-093,238-0049-002,001-1885-060,002-1105-118,223-0047-067,155-0330-359,189-0019-080,001-0757-061,001-0758-104,250-0064-097,038-0222-359,053-1630-099,002-0826-299,003-0620-212,001-0946-272,002-0822-006,002-0845-210,001-1528-002,155-0386-069,155-0538-069,188-0057-360,261-0003-022,155-0249-061,176-0015-483,056-0033-297,001-0955-002,001-1586-485,001-0985-042,001-1626-059,058-0013-122,250-0055-225,001-2154-226,061-0152-011,001-2154-230,189-0075-002,142-0001-016,128-0065-373,061-0152-373,088-0035-161,002-1058-070,038-0056-005,016-0068-072,155-0516-007,267-0001-003,203-0015-093,001-1610-002,898-0006-093,155-0023-044,177-0007-002,003-0719-360,001-0936-039,128-0070-022,015-0118-005,066-0106-128,025-4242-002,001-1798-005,056-0043-368,061-0152-002,001-0969-001,001-1742-059,221-0016-291,155-0598-002,038-0056-004,188-0053-180,001-0965-093,014-0238-067,156-0021-359,001-0922-020,155-0599-061,225-0036-048,016-0140-001,250-0074-319,001-0757-037,002-0824-222,225-0024-049,001-0789-063,239-0028-006,001-2021-003,024-0205-044,001-2088-358,002-0917-072,238-0009-002,001-1335-015,267-0007-080,003-0787-001,001-1579-164,155-0390-197,238-0011-002,025-7778-062,250-0027-011,250-0019-082,015-0120-009,261-0002-477,038-0101-098,238-0048-007,015-0081-197,225-0027-361,056-0028-369,065-0009-002,061-0155-072,001-2155-084,223-0045-313,056-0029-477,114-0257-005,267-0009-212,249-0006-001,003-0625-006,155-0532-559,155-0481-001,155-0550-044,016-0094-010,155-0393-044,032-0207-005,001-1399-037,056-0034-477,155-0249-124,061-0155-006,225-0027-077,238-0055-011,002-1071-359,016-0144-011,155-0019-038,028-0006-117,014-0114-005,168-0031-229,014-0356-191,016-0132-029,200-0006-223,155-0128-007,032-0207-009,213-0030-002,058-0019-122,001-0845-007,155-0541-069,061-0155-059,155-0019-001,115-0272-003,225-0022-061,155-0162-069,058-0017-122";
	private static Map<String, Integer> map = new LinkedHashMap<String, Integer>();
	
	void processDone(){
		System.out.println("In process done");
		String[] skuArray = SKU_STRING.split(",");
		
		for (int i = 0; i < skuArray.length; i++) {
			String prdStr = skuArray[i].substring(0, 8);
			if(!map.containsKey(prdStr)){
				map.put(prdStr, 1);
			}else{
				map.put(prdStr, map.get(prdStr)+1);
			}
		}
		System.out.println(map);
		System.out.println(map.size());
	}
	
}