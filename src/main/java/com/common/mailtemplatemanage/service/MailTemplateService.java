package com.common.mailtemplatemanage.service;

import com.core.data.model.DataModel;

/**
 * @author dc.yuan
 * @version 1.0
 */
public interface MailTemplateService {

    DataModel findMailTemplateByName(DataModel queryModel);
}
