package com.tool;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CreateDropSql {
    private final static String sqlPath = "sql/";

    public static void main(String[] args) {
        try {
            ClassPathResource cpr = new ClassPathResource(sqlPath + "read.txt");
            readFileByLine(cpr.getFile().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFileByLine(String dirPath) {
        File file = new File(dirPath);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String str = null;
                int count_no = 1;
              /*  //rollback table
                while ((str = reader.readLine()) != null) {
                    System.out.println("----" + count_no + ":");
                    System.out.println("if object_id('" + str + "') is not null");
                    System.out.println("begin");
                    System.out.println("drop table " + str);
                    System.out.println("end");
                    System.out.println("go");
                    System.out.println(" ");
                    count_no++;
                }
                //rollback view
                while ((str = reader.readLine()) != null) {
                    System.out.println("----" + count_no + ":");
                    System.out.println("if object_id('" + str + "') is not null");
                    System.out.println("begin");
                    System.out.println("drop view " + str);
                    System.out.println("end");
                    System.out.println("go");
                    System.out.println(" ");
                    count_no++;
                }
                //rollback sp
                while ((str = reader.readLine()) != null) {
                    System.out.println("----" + count_no + ":");
                    System.out.println("if object_id('" + str + "') is not null");
                    System.out.println("begin");
                    System.out.println("drop PROCEDURE " + str);
                    System.out.println("end");
                    System.out.println("go");
                    System.out.println(" ");
                    count_no++;
                }
                //exec sp
                while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("exec dbo.SP_SI_Main '" + strList[0].trim() + "' ," + strList[1].trim() + ",'" + strList[2].trim() + "'");
                    System.out.println("go");
                    System.out.println(" ");
                    count_no++;
                }*/

                /*while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("INSERT INTO dbo.si_h_ah_mapping ( id, product_cd, product_name, coverage_code, basic_benefits, type, final_premium, final_sum_insured, original_sum_insured)values("
                            +""+ strList[0].trim() +","
                            +"'"+ strList[2].trim() +"',"
                            +"'"+ strList[1].trim() +"',"
                            +"'"+ strList[4].trim() +"',"
                            +"'"+ strList[3].trim().replace("\"","") +"',"
                            +"'"+ strList[5].trim() +"',"
                            +""+ strList[6].trim() +","
                            +""+ strList[7].trim() +","
                            +""+ strList[8].trim() +""
                            +")");
                    System.out.println("go");
                    count_no++;
                }*/

              /*  while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("INSERT INTO #temp_ah_policy_update (pol_office_cd, policy_no, certificate_no, renl_cert_no, eff_dt_seq_no, gross_premium_amt)values("
                            +"'"+ strList[0].trim() +"',"
                            +"'"+ strList[1].trim() +"',"
                            +"" + strList[2].trim() +","
                            +"'"+ strList[3].trim() +"',"
                            +"" + strList[4].trim() +","
                            +"" + strList[5].trim() +""
                            +")");
                    count_no++;
                }*/
               /* while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("update si_b_billing set status ='group_success'  \n" +
                            "where bil_no = " +
                            "'"+ strList[0].trim() +"'"+
                            "\n" +
                            "and bil_seq_no = " +
                            strList[1].trim() +
                            "\n" +
                            "and producer_code=" +
                            "'"+ strList[2].trim() +"'"+
                            "");
                    System.out.println("go");
                    count_no++;
                }*/

               while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    /*System.out.println("select @countNum =count(*) from anti_fraud_list where chinese_name ='" +
                            strList[0].trim()  +
                            "'");
                     System.out.println("if (@countNum =0)");*/
                    System.out.println("insert into anti_fraud_list(chinese_name,blacklist_source,dark_black_flag)values('" +
                            strList[0].replace(" ","")
                            +"','AIG"
                            +"','Y')");
                    //System.out.println("go");
                   /* System.out.println("update anti_fraud_list set dark_black_flag ='Y' where chinese_name ='" +
                            strList[0].trim()  +
                            "'");*/
                    count_no++;
                }


              /*  while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("update si_h_ah_mapping_new set final_premium =" +
                            strList[1].trim() +
                            ",final_sum_insured =" +
                            strList[2].trim() +
                            "  where  coverage_code ='" +
                            strList[0].trim()+
                            "'");
                    System.out.println("go");
                    count_no++;
                }*/
               /* while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("insert into si_h_ah_mapping_router(product_cd) values('" +
                            strList[0].trim() +
                            "')" );
                    System.out.println("go");
                    count_no++;
                }*/

               /*
                while ((str = reader.readLine()) != null) {
                    String[] strList = str.split(",");
                    System.out.println("----" + count_no);
                    System.out.println("insert into dbo.liberty_product(n06_product_cd) values('"
                                    +""+ strList[0].trim()+

                            "')" );
                    System.out.println("go");
                    count_no++;
                }

               */
                System.out.println("total count =" + count_no);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
