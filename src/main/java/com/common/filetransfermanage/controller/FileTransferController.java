package com.common.filetransfermanage.controller;

import com.common.filetransfermanage.service.FileTransferService;
import com.controller.AbstractBaseController;
import com.model.data.DataModel;
import com.model.exception.ValidationException;
import com.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileTransferController extends AbstractBaseController {

    private FileTransferService fileTransferService;

    public FileTransferController(FileTransferService fileTransferService) {
        this.fileTransferService = fileTransferService;
    }

    /**
     * 上传单个文件file
     *
     * @param request
     * @param file
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public Map<String, Object> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(request);
            String fileName = fileTransferService.storeFile(file);
            resultModel.setFieldValue("fileName", fileName);
            resultModel.setFieldValue("fileType", file.getContentType());
            resultModel.setFieldValue("fileSize", file.getSize());
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * 上传多个file文件
     *
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/upload/multiple")
    public Map<String, Object> uploadMultipleFiles(HttpServletRequest request, @RequestParam("files") MultipartFile[] files) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(request);
            List<DataModel> fileListModel = new ArrayList<>();
            for (MultipartFile file : files) {
                DataModel fileModel = new DataModel();
                String fileName = fileTransferService.storeFile(file);
                fileModel.setFieldValue("fileName", fileName);
                fileModel.setFieldValue("fileType", file.getContentType());
                fileModel.setFieldValue("fileSize", file.getSize());
                fileListModel.add(fileModel);
            }
            resultModel.setFieldValue("uploadResults", fileListModel);
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * 下载文件file
     *
     * @param request
     * @param fileName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request, @PathVariable(value = "fileName") String fileName) {
        Resource resource = fileTransferService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type");
        }
        if (StringUtils.isBlank(contentType)) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
