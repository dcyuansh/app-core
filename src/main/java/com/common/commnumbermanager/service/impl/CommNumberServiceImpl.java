package com.common.commnumbermanager.service.impl;

import com.common.commnumbermanager.repository.CommNumberRepository;
import com.common.commnumbermanager.service.CommNumberService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class CommNumberServiceImpl implements CommNumberService {

    @Autowired
    private CommNumberRepository commNumberRepository;


    /***
     * generate number
     * @return
     */
    @Override
    public int generateNumber(DataModel generateModel) {
        this.validateSaveOrUpdateCommNumber(generateModel);
        int generateNumber = 1;
        DataModel queryModel = this.queryCommNumber(generateModel);
        if (queryModel != null) {
            generateNumber = queryModel.getIntegerValue("lastValue");
            this.updateCommNumber(generateModel);
        } else {
            this.saveCommNumber(generateModel);
        }
        return generateNumber;
    }

    /***
     * save comm number info
     * @param saveModel
     */
    @Override
    public void saveCommNumber(DataModel saveModel) {
        this.validateSaveOrUpdateCommNumber(saveModel);
        if (StringUtils.isBlank(saveModel.getStringValue("lastValue"))) {
            saveModel.setFieldValue("lastValue", 1);
        }
        commNumberRepository.saveCommNumber(saveModel);
    }


    /***
     * query comm number info
     * @param queryModel
     * @return
     */
    @Override
    public DataModel queryCommNumber(DataModel queryModel) {
        DataModel resultModel = commNumberRepository.queryCommNumber(queryModel);
        return resultModel;
    }


    /***
     * update comm number info
     * @param updateModel
     */
    @Override
    public void updateCommNumber(DataModel updateModel) {
        this.validateSaveOrUpdateCommNumber(updateModel);
        commNumberRepository.updateCommNumber(updateModel);
    }


    /***
     *
     * @param numberModel
     */
    protected void validateSaveOrUpdateCommNumber(DataModel numberModel) {
        String validationMsg = "";
        if (numberModel == null) {
            validationMsg = "params can not be null!";
        }
        if (numberModel != null && StringUtils.isBlank(numberModel.getStringValue("numberType"))) {
            validationMsg = "numberType can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }
}
