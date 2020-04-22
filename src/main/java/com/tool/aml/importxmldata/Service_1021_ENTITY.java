package com.tool.aml.importxmldata;

import com.core.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class Service_1021_ENTITY {

    public static String dirPath = "C:\\Users\\DeChunYuan\\Desktop\\api_xml\\1021_ENTITY_yuan_3.XML";

    public static String filePath ="C:\\Users\\DeChunYuan\\Desktop\\api_xml\\insert.txt";

    public static void main(String[] args) {
        Map<String, Object> map = XmlParserUtil.dom4jXmlToMap(FileUtils.readFileByLine(dirPath).toString());
        HashMap<String, Object> hashMap = (HashMap<String, Object>) map.get("entities");
        List entityList = (List) hashMap.get("entity");


        int totalCount = 0;
        for (int i = 0; i < entityList.size(); i++) {

            //字段
            String chineseName = "";
            String englishName = "";
            String idType = "";
            String identifyNumber = "";
            String dob = "";
            String blacklistSource = "1021_ENTITY";
            String darkBlackFlag = "N";

            //englishName
            HashMap<String, Object> entityMap = (HashMap<String, Object>) entityList.get(i);
            HashMap<String, Object> name = (HashMap<String, Object>) entityMap.get("name");
            englishName = name == null ? "" : (String) name.get("name");

            //chineseName
            HashMap<String, Object> nativeCharNamesList = (HashMap<String, Object>) entityMap.get("nativeCharNames");
            HashMap<String, Object> nativeCharName = nativeCharNamesList == null ? null : (HashMap<String, Object>) nativeCharNamesList.get("nativeCharNames");
            chineseName = nativeCharName == null ? "" : (String) nativeCharName.get("nativeCharName");
            List<String> chineseNameList = new ArrayList<>();
            if (StringUtils.isNotBlank(chineseName)) {
                chineseNameList.add(chineseName);
            } else {
                List cnNameList = nativeCharNamesList == null ? new ArrayList() : (List) nativeCharNamesList.get("nativeCharName");
                if (cnNameList != null && cnNameList.size() > 0) {
                    for (int idrow = 0; idrow < cnNameList.size(); idrow++) {
                        HashMap<String, String> cnNameMap = (HashMap<String, String>) cnNameList.get(idrow);
                        chineseNameList.add(cnNameMap.get("nativeCharName"));
                    }
                } else {
                    chineseNameList.add("");
                }
            }


            //dob
            HashMap<String, Object> dobsList = (HashMap<String, Object>) entityMap.get("dobs");
            HashMap<String, Object> dobs = dobsList == null ? null : (HashMap<String, Object>) dobsList.get("dobs");
            dob = dobs == null ? "" : (String) dobs.get("dob");

            for (int m = 0; m < chineseNameList.size(); m++) {
                chineseName = chineseNameList.get(m);


                //id
                HashMap<String, Object> idsList = (HashMap<String, Object>) entityMap.get("ids");
                //HashMap<String, Object> idsList2 = (HashMap<String, Object>) idsList.get("ids");
                //List idList = idsList == null ? new ArrayList() : (List) idsList.get("ids");
                if (idsList != null && idsList.size() > 0) {
                    for (int j = 0; j < idsList.size(); j++) {
                        HashMap<String, String> idMap = (HashMap<String, String>) idsList.get("ids");
                        if (idMap != null) identifyNumber = (String) idMap.get("id");
                        if (MatcherUtils.isIDCard(identifyNumber)) {
                            idType = "NATIONAL NO";
                        } else {
                            idType = "other";
                        }
                        String content = "insert into anti_fraud_list(chinese_name,english_name,id_type,identify_number,DOB,blacklist_source,dark_black_flag)values("
                                + "'" + chineseName.replace("'", "''") + "',"
                                + "'" + englishName.replace("'", "''") + "',"
                                + "'" + idType.replace("'", "''") + "',"
                                + "'" + identifyNumber.replace("'", "''") + "',"
                                + "'" + dob.replace("'", "''") + "',"
                                + "'" + blacklistSource.replace("'", "''") + "',"
                                + "'" + darkBlackFlag.replace("'", "''") + "'" +
                                ")";
                        //System.out.println(content);
                        totalCount = totalCount + 1;
                        FileUtils.saveAsFileWriter(filePath, content + "\n",true);

                    }
                } else {
                    String content = "insert into anti_fraud_list(chinese_name,english_name,id_type,identify_number,DOB,blacklist_source,dark_black_flag)values("
                            + "'" + chineseName.replace("'", "''") + "',"
                            + "'" + englishName.replace("'", "''") + "',"
                            + "'" + idType.replace("'", "''") + "',"
                            + "'" + identifyNumber.replace("'", "''") + "',"
                            + "'" + dob.replace("'", "''") + "',"
                            + "'" + blacklistSource.replace("'", "''") + "',"
                            + "'" + darkBlackFlag.replace("'", "''") + "'" +
                            ")";
                    //System.out.println(content);
                    totalCount = totalCount + 1;
                    FileUtils.saveAsFileWriter(filePath, content + "\n",true);
                }
            }
        }
        System.out.println("total insert record :" + totalCount);
        System.out.println("complete success!");
    }
}
