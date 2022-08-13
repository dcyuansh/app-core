package com.common.picturemanage.controller;

import com.common.filetransfermanage.service.FileTransferService;
import com.common.picturemanage.service.PictureService;
import com.core.controller.AbstractBaseController;
import com.core.data.model.DataModel;
import com.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;

/**
 * @author dc.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/picture")
public class PictureController extends AbstractBaseController {

    private Logger LOG = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;
    @Autowired
    private FileTransferService fileTransferService;


    /**
     * @param request
     * @param file
     * @return 返回修改背景色后的图片
     * @desc 修改图片背景色
     */
    @RequestMapping(method = RequestMethod.POST, value = "/cg-picture-bg")
    public ResponseEntity<Resource> changePictureBackground(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        DataModel queryModel = this.getInputData(request);
        byte[] imageDate = null;
        try {
            imageDate = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultImagePath = pictureService.changePictureBackground(imageDate, Color.blue);
        Resource resource = fileTransferService.loadFileAsResource(resultImagePath);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOG.info("Could not determine file type");
        }
        if (StringUtils.isBlank(contentType)) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
