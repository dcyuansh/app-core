package com.common.commbus.controller;


import com.common.commbus.dto.CommBussDTO;
import com.common.commbus.service.CommBussService;
import com.common.commbus.vo.CommBussVO;
import com.core.controller.AbstractBaseController;
import com.core.data.model.DataModel;
import com.core.exception.ValidationException;
import com.core.pagehelper.pojo.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * (CommBuss)表控制层
 *
 * @author spring.yuan
 * @since 2022-08-11 12:47:14
 */
@RestController
@RequestMapping("/api/commBuss")
public class CommBussController extends AbstractBaseController {

    @Autowired
    private CommBussService commBussService;


    @RequestMapping(method = RequestMethod.POST, value = "/query")
    public Map<String, Object> queryByPage(@RequestBody CommBussDTO commBussDTO) {
        DataModel resultModel = new DataModel();
        try {
            PaginationInfo<CommBussVO> commBussResult = commBussService.queryByPage(commBussDTO);
            this.handleSuccess(resultModel, commBussResult);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }

}

