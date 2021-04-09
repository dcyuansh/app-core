package com.common.picturemanage.service;

import java.awt.*;

/**
 * @author spring.yuan
 * @version 1.0
 */
public interface PictureService {

    /**
     * @param imgData
     * @return 返回修改背景色后的图片路径
     * @desc 修改图片背景色
     */
    String changePictureBackground(byte[] imgData, Color color);
}
