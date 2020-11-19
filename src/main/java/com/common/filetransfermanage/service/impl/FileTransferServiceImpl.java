package com.common.filetransfermanage.service.impl;

import com.common.filetransfermanage.bean.FileStorageProperties;
import com.common.filetransfermanage.service.FileTransferService;
import com.core.exception.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class FileTransferServiceImpl implements FileTransferService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Path fileStorageLocation;


    /**
     * 初始化file保存路径
     *
     * @param fileStorageProperties
     */
    @Autowired
    public FileTransferServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadPath()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw ExceptionHelper.getInstance().handleValidationException("Could not create directory where the uploaded files will be stored");
        }
    }


    /**
     * 存储file文件
     *
     * @param file
     * @return
     */
    @Override
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw ExceptionHelper.getInstance().handleValidationException("File name contains invalid path sequence");
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw ExceptionHelper.getInstance().handleValidationException("Could not store file " + fileName + ". Please try again later!" + ex.getMessage());
        }
    }


    /**
     * 加载file文件
     *
     * @param fileName
     * @return
     */
    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw ExceptionHelper.getInstance().handleValidationException("File not found" + fileName);
            }
        } catch (MalformedURLException ex) {
            throw ExceptionHelper.getInstance().handleValidationException("File not found" + fileName + " Error message:" + ex.getMessage());
        }
    }
}
