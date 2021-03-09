package com.core.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.core.enums.ExceptionStatusCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class ExceptionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

    private ExceptionUtil() {
    }

    /**
     * 获取异常信息
     *
     * @param e 异常
     */
    public static String getErrorMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    logger.info(e1.getMessage());
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }

    /**
     * 异常信息-->json
     */
    public static String resultOf(ExceptionStatusCodeEnum resultStatusCode) {
        SerializeConfig config = new SerializeConfig();
        config.configEnumAsJavaBean(ExceptionStatusCodeEnum.class);
        return JSON.toJSONString(resultStatusCode, config);
    }
}
