package com.core.request;

import com.core.enums.EncodeTypeEnum;
import com.core.utils.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class HttpClientUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);    //日志记录


    /**
     * @param url         请求url
     * @param contentType 请求方式content type
     * @param reqParam    请求参数
     * @return 取服务器返回过来的json字符串数据
     */
    public static String post(String url, String contentType, String reqParam) {
        //post请求返回结果
        HttpClient httpClient = HttpClientBuilder.create().build();
        String res = null;
        HttpPost method = new HttpPost(url);
        try {
            if (StringUtils.isNotBlank(reqParam)) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(reqParam, EncodeTypeEnum.UTF8.getCode());
                entity.setContentEncoding(EncodeTypeEnum.UTF8.getCode());
                entity.setContentType(contentType);
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, EncodeTypeEnum.UTF8.getCode());
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    res = EntityUtils.toString(result.getEntity(), EncodeTypeEnum.UTF8.getCode());
                    /**把json字符串转换成json对象**/
                    //jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败,url:{},exception:{}", url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败,url:{},exception:{}", url, e);
        }
        return res;
    }


    /**
     * @param url 路径
     * @return 读取服务器返回过来的json字符串数据
     * @desc 发送get请求
     */
    public static String get(String url) {
        String res = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                res = EntityUtils.toString(response.getEntity(), EncodeTypeEnum.UTF8.getCode());
                /**把json字符串转换成json对象**/
            } else {
                logger.error("get请求提交失败:{}", url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败,url:{},exception:{}", url, e);
        }
        return res;
    }
}
