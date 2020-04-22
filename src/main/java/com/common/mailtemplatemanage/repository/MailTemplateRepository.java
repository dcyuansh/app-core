package com.common.mailtemplatemanage.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Mapper
public interface MailTemplateRepository {

    DataModel findMailTemplateByName(DataModel queryModel);
}
