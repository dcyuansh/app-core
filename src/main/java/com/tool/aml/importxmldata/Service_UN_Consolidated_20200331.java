package com.tool.aml.importxmldata;

import com.core.utils.FileUtils;
import com.core.utils.MatcherUtils;
import com.core.utils.XmlParserUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class Service_UN_Consolidated_20200331 {


    public static String dirPath = "C:\\dechun.yuan\\AIG\\Work\\AML\\API\\blacklist\\UN consolidated.xml";

    public static void main(String[] args) {
        Map<String, Object> map = XmlParserUtil.dom4jXmlToMap(FileUtils.readFileByLine(dirPath).toString());
        HashMap<String, Object> hashMap = (HashMap<String, Object>) map.get("INDIVIDUALS");
        List entityList = (List) hashMap.get("INDIVIDUAL");


        for (int i = 0; i < entityList.size(); i++) {
            //字段
            String chineseName = "";
            String englishName = "";
            String idType = "";
            String identifyNumber = "";
            String dob = "";
            String blacklistSource = "UN_Consolidated";
            String darkBlackFlag = "N";


            //englishName
            HashMap<String, Object> entityMap = (HashMap<String, Object>) entityList.get(i);
            HashMap<String, Object> first_name = (HashMap<String, Object>) entityMap.get("FIRST_NAME");
            HashMap<String, Object> second_name = (HashMap<String, Object>) entityMap.get("SECOND_NAME");
            HashMap<String, Object> third_name = (HashMap<String, Object>) entityMap.get("THIRD_NAME");

            String firstName = first_name == null ? "" : (String) first_name.get("FIRST_NAME");
            String secondName = second_name == null ? "" : (String) second_name.get("SECOND_NAME");
            String thirdName = third_name == null ? "" : (String) third_name.get("THIRD_NAME");
            englishName = firstName.replace("'", "''").trim() + secondName.replace("'", "''").trim() + thirdName.replace("'", "''").trim();

            //dob
            HashMap<String, Object> dobsList = (HashMap<String, Object>) entityMap.get("dobs");
            HashMap<String, Object> dobs = dobsList == null ? null : (HashMap<String, Object>) dobsList.get("dobs");
            dob = dobs == null ? "" : (String) dobs.get("dob");

            //id
            HashMap<String, Object> idsList = new HashMap<>();
            List idList = null;
            try {
                idsList = (HashMap<String, Object>) entityMap.get("INDIVIDUAL_DOCUMENT");
            } catch (Exception e) {
                idList = (List) entityMap.get("INDIVIDUAL_DOCUMENT");
            }
            //List idList = idsList == null || (String)idsList.get("INDIVIDUAL_DOCUMENT")==""? new ArrayList() : (List) idsList.get("INDIVIDUAL_DOCUMENT");
            if (idList != null && idList.size() > 0) {
                for (int j = 0; j < idList.size(); j++) {
                    HashMap<String, Object> idMap = (HashMap<String, Object>) idList.get(j);
                    HashMap<String, String> idMapValue = (HashMap<String, String>) idMap.get("NUMBER");
                    if (idMapValue != null) identifyNumber = (String) idMapValue.get("NUMBER");
                    if (MatcherUtils.isIDCard(identifyNumber.trim())) {
                        idType = "NATIONAL NO";
                    } else {
                        idType = "other";
                    }
                    System.out.println("insert into anti_fraud_list(chinese_name,english_name,id_type,identify_number,DOB,blacklist_source,dark_black_flag)values("
                            + "'" + chineseName + "',"
                            + "'" + englishName + "',"
                            + "'" + idType + "',"
                            + "'" + identifyNumber.trim() + "',"
                            + "'" + dob + "',"
                            + "'" + blacklistSource + "',"
                            + "'" + darkBlackFlag + "'" +
                            ")");
                }
            } else {
                HashMap<String, Object> idMapValue = (HashMap<String, Object>) idsList.get("NUMBER");
                if (idMapValue != null) identifyNumber = (String) idMapValue.get("NUMBER");
                if (MatcherUtils.isIDCard(identifyNumber)) {
                    idType = "NATIONAL NO";
                } else {
                    idType = "other";
                }
                System.out.println("insert into anti_fraud_list(chinese_name,english_name,id_type,identify_number,DOB,blacklist_source,dark_black_flag)values("
                        + "'" + chineseName + "',"
                        + "'" + englishName + "',"
                        + "'" + idType + "',"
                        + "'" + identifyNumber.trim() + "',"
                        + "'" + dob + "',"
                        + "'" + blacklistSource + "',"
                        + "'" + darkBlackFlag + "'" +
                        ")");
            }

        }
    }
}
