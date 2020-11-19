package com.common.filetransfermanage.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public interface FileTransferService {


    /**
     * 存储文件
     *
     * @param file
     * @return
     */
    String storeFile(MultipartFile file);

    /**
     * 查询文件
     *
     * @param fileName
     * @return
     */
    Resource loadFileAsResource(String fileName);
}
