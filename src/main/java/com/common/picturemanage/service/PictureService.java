package com.common.picturemanage.service;

import java.awt.*;

/**
 * @author dc.yuan
 * @version 1.0
 */
public interface PictureService {

    /**
     * 修改图片背景色
     *
     * @param imgData 图片流
     * @return 返回修改背景色后的图片路径
     */
    String changePictureBackground(byte[] imgData, Color color);
}
