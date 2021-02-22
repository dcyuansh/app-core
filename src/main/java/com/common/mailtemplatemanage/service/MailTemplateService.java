package com.common.mailtemplatemanage.service;

import com.core.data.model.DataModel;

/**
 * @author spring
 * @version 1.0
 */
public interface MailTemplateService {

    DataModel findMailTemplateByName(DataModel queryModel);
}
