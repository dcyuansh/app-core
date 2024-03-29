package com.common.filetransfermanage.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author DC Yuan
 * @version 1.0
 */
public interface FileTransferService {


    /**
     * 存储文件
     */
    String storeFile(MultipartFile file);


    /**
     * 查询文件
     */
    Resource loadFileAsResource(String fileName);
}
