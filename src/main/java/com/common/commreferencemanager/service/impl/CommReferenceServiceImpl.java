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
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class CommReferenceServiceImpl implements CommReferenceService {

    @Autowired
    private CommReferenceRepository commReferenceRepository;


    /***
     * generate number
     * @return
     */
    @Override
    public int generateNumber(DataModel generateModel) {
        this.validateSaveOrUpdateCommNumber(generateModel);
        int generateNumber = 1;
        DataModel queryModel = this.queryCommReference(generateModel);
        if (queryModel != null) {
            generateNumber = queryModel.getIntegerValue("currentValue") + queryModel.getIntegerValue("span");
            queryModel.setFieldValue("timestamp", LocalDateTime.now());
            this.updateCommReferenceLastValue(queryModel);
        } else {
            if (!generateModel.containsKey("currentValue")) {
                generateModel.setFieldValue("currentValue", 1);
            }
            if (!generateModel.containsKey("span")) {
                generateModel.setFieldValue("span", 1);
            }
            generateModel.setFieldValue("language_id", "");
            generateModel.setFieldValue("category_cd", "");
            generateModel.setFieldValue("code_desc", "");
            generateModel.setFieldValue("remarks", "ticket no自增长序号");
            this.saveCommReference(generateModel);
        }
        return generateNumber;
    }


    /***
     * save comm_reference info
     * @param saveModel
     */
    @Override
    public void saveCommReference(DataModel saveModel) {
        this.validateSaveOrUpdateCommNumber(saveModel);
        commReferenceRepository.saveCommReference(saveModel);
    }


    /***
     * query one comm_reference row info
     * @param queryModel
     * @return
     */
    @Override
    public DataModel queryCommReference(DataModel queryModel) {
        return commReferenceRepository.queryCommReference(queryModel);
    }


    /**
     * query comm_reference list info
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<DataModel> queryCommReferenceList(DataModel queryModel) {
        return commReferenceRepository.queryCommReferenceList(queryModel);
    }


    /***
     * update comm number info
     * @param updateModel
     */
    @Override
    public void updateCommReferenceLastValue(DataModel updateModel) {
        this.validateSaveOrUpdateCommNumber(updateModel);
        commReferenceRepository.updateCommReferenceLastValue(updateModel);
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
