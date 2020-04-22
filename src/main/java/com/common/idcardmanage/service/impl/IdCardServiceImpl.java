package com.common.idcardmanage.service.impl;

import com.common.idcardmanage.repository.IdCardRepository;
import com.common.idcardmanage.service.IdCardService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        idCardRepository.saveIdCard(saveModel);
    }

    /***
     * find id card by id no
     * @param queryModel
     * @return
     */
    @Override
    public DataModel findIdCard(DataModel queryModel) {
        return idCardRepository.findIdCard(queryModel);
    }

    /***
     * find id card by others info
     * @param queryModel
     * @return
     */
    @Override
    public List<DataModel> findAllIdCard(DataModel queryModel) {
        return idCardRepository.findAllIdCard(queryModel);
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
