package com.common.commreferencemanager.service.impl;

import com.common.commreferencemanager.repository.CommReferenceRepository;
import com.common.commreferencemanager.service.CommReferenceService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class CommReferenceServiceImpl implements CommReferenceService {

    @Autowired
    private CommReferenceRepository commReferenceRepository;


    @Override
    public void saveCommReference(DataModel saveModel) {
        this.validateSaveOrUpdateCommNumber(saveModel);
        //set insert timestamp
        saveModel.setFieldValue("insertTime", LocalDateTime.now());
        saveModel.setFieldValue("timestamp", LocalDateTime.now());
        commReferenceRepository.saveCommReference(saveModel);
    }


    @Override
    public DataModel queryCommReference(DataModel queryModel) {
        return commReferenceRepository.queryCommReference(queryModel);
    }


    @Override
    public List<DataModel> queryCommReferenceList(DataModel queryModel) {
        return commReferenceRepository.queryCommReferenceList(queryModel);
    }


    /***
     * validate param
     * @param numberModel
     */
    protected void validateSaveOrUpdateCommNumber(DataModel numberModel) {
        String validationMsg = "";
        if (numberModel == null) {
            validationMsg = "params can not be null!";
        }
        if (numberModel != null && StringUtils.isBlank(numberModel.getStringValue("elementType"))) {
            validationMsg = "element type can not be null!";
        }
        if (numberModel != null && StringUtils.isBlank(numberModel.getStringValue("elementCd"))) {
            validationMsg = "element code can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }
}
