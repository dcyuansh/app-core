package com.common.commreferencemanager.service.impl;

import com.common.commreferencemanager.repository.CommReferenceRepository;
import com.common.commreferencemanager.service.CommReferenceService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class CommReferenceServiceImpl implements CommReferenceService {

    @Autowired
    private CommReferenceRepository commReferenceRepository;


    /***
     * save comm_reference info
     * @param saveModel
     */
    @Override
    public void saveCommReference(DataModel saveModel) {
        this.validateSaveOrUpdateCommNumber(saveModel);
        commReferenceRepository.saveCommReference(saveModel);
    }


    /**
     * query comm_reference
     *
     * @param queryModel
     * @return
     */
    @Override
    public DataModel queryCommReference(DataModel queryModel) {
        return commReferenceRepository.queryCommReference(queryModel);
    }


    /***
     * query comm_reference list
     * @param queryModel
     * @return
     */
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
        if (numberModel != null && StringUtils.isBlank(numberModel.getStringValue("type"))) {
            validationMsg = "type can not be null!";
        }
        if (numberModel != null && StringUtils.isBlank(numberModel.getStringValue("code"))) {
            validationMsg = "code can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }
}
