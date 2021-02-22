package com.common.mailtemplatemanage.service.impl;

import com.common.mailtemplatemanage.repository.MailTemplateRepository;
import com.common.mailtemplatemanage.service.MailTemplateService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author spring
 * @version 1.0
 */
@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MailTemplateRepository mailTemplateRepository;


    /***
     * find mail template by template name
     * @param queryModel
     * @return
     */
    @Override
    public DataModel findMailTemplateByName(DataModel queryModel) {
        this.validateMailTemplate(queryModel);
        return mailTemplateRepository.findMailTemplateByName(queryModel);
    }


    protected void validateMailTemplate(DataModel mailTemplateModel) {
        String validationMsg = "";
        if (StringUtils.isBlank(mailTemplateModel.getStringValue("templateName"))) {
            validationMsg = "template name can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }
}
