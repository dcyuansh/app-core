package com.common.idcardmanage.service.impl;

import com.common.idcardmanage.repository.IdCardRepository;
import com.common.idcardmanage.service.IdCardService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IdCardServiceImpl implements IdCardService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdCardRepository idCardRepository;


    /***
     * save id card
     * @param saveModel
     */
    @Override
    public void saveIdCard(DataModel saveModel) {
        this.validateSaveOrUpdateIdCard(saveModel);
        //set insert timestamp
        saveModel.setFieldValue("timestamp", LocalDateTime.now());
        idCardRepository.saveIdCard(saveModel);
    }

    /***
     * find id card by id no
     * @param queryModel
     * @return
     */
    @Override
    public DataModel queryIdCard(DataModel queryModel) {
        return idCardRepository.queryIdCard(queryModel);
    }

    /***
     * find id card by others info
     * @param queryModel
     * @return
     */
    @Override
    public List<DataModel> queryIdCardList(DataModel queryModel) {
        return idCardRepository.queryIdCardList(queryModel);
    }

    /***
     * delete id card by id no
     * @param deleteModel
     */
    @Override
    public void deleteIdCard(DataModel deleteModel) {
        idCardRepository.deleteIdCard(deleteModel);
    }

    /***
     * update id card by id no
     * @param updateModel
     */
    @Override
    public void updateIdCard(DataModel updateModel) {
        //set update timestamp
        updateModel.setFieldValue("timestamp", LocalDateTime.now());
        idCardRepository.updateIdCard(updateModel);
    }

    /***
     * check id card info
     * @param validateModel
     */
    protected void validateSaveOrUpdateIdCard(DataModel validateModel) {
        if (false) {
            throw ExceptionHelper.getInstance().handleValidationException("id card can not bu null!");
        }
    }
}
