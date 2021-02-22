package com.common.filetransfermanage.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author spring
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
