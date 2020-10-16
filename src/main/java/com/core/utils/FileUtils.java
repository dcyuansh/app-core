package com.core.utils;


import com.core.enums.EncodeTypeEnum;

import java.io.*;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class FileUtils {

    /***
     * 根据文件路径，按行读取文件
     * @param dirPath
     * @return
     */
    public static StringBuffer readFileByLine(String dirPath) {
        StringBuffer result = new StringBuffer();
        File file = new File(dirPath);
        if (!file.exists()) {
            return null;
        } else {
            try {
                FileInputStream input = new FileInputStream(file);
                //FileReader fileReader = new FileReader(file);
                InputStreamReader fileReader = new InputStreamReader(new FileInputStream(file), EncodeTypeEnum.UTF8.getCode());
                BufferedReader reader = new BufferedReader(fileReader);
                String str = null;
                while ((str = reader.readLine()) != null) {
                    result.append(str + " ");
                }
                input.close();
                fileReader.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /***
     * 写入txt
     * @param filePath
     * @param content
     */
    public static void saveAsFileWriter(String filePath, String content, boolean isOverwrite) {
        FileWriter fwriter = null;
        try {
            // isOverwrite：true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, isOverwrite);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /***
     * 根据文件的前3个字符判断文件的字符编码
     * @param input
     * @return
     */
    public static String getFileEncodeType(FileInputStream input) {
        String encodeType = EncodeTypeEnum.UTF8.getCode();
        byte[] byt = new byte[3];
        try {
            input.read(byt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //根据文件的前3个字符判断文件应该用什么编码格式
        if (byt.length >= 3) {
            if (!(byt[0] == -17 && byt[1] == -69 && byt[2] == -65)) {
                encodeType = EncodeTypeEnum.GBK.getCode();
            }
        }
        return encodeType;
    }
}
