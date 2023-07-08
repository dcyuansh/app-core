package com.common.picturemanage.service.impl;

import com.common.apiocrmanage.service.AipBodyAnalysisService;
import com.common.picturemanage.service.PictureService;
import com.model.data.DataModel;
import com.model.exception.ExceptionHelper;
import com.utils.KeyGenerationUtils;
import com.utils.PngColoringUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;


/**
 * @author DC Yuan
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${file.upload-path}")
    private String imageFilePath;

    @Autowired
    private AipBodyAnalysisService aipBodyAnalysisService;


    @Override
    public String changePictureBackground(byte[] imgData, Color color) {
        //返回前景人像图（透明背景）
        JSONObject res = aipBodyAnalysisService.bodySeg(imgData);
        String foreground = res.get("foreground").toString();
        String imageFileId = KeyGenerationUtils.getInstance().KeyValue();
        String imageFileName = imageFilePath + "/" + imageFileId + ".png";
        String resultImage = imageFilePath + "/" + imageFileId + ".jpg";
        //保存前景人像图（透明背景）
        this.GenerateImage(foreground, imageFilePath + "/" + imageFileName);
        //修改前景人物像背景色
        PngColoringUtil.changePNGBackgroudColor(imageFileName, resultImage, color);
        return resultImage;
    }


    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr
     * @param imgFilePath
     * @return
     * @desc 生成图片
     */
    public boolean GenerateImage(String imgStr, String imgFilePath) {
        // 图像数据为空
        if (imgStr == null) {
            return false;
        }
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            // 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            System.out.println("保存成功" + imgFilePath);
            return true;
        } catch (Exception e) {
            System.out.println("出错了" + e.getMessage());
            return false;
        }
    }

    /***
     * check image info
     * @param validateModel
     */
    protected void validateSaveOrUpdate(DataModel validateModel) {
        if (false) {
            throw ExceptionHelper.getInstance().handleValidationException("imgData can not bu null!");
        }
    }


}
