package com.common.idcardmanage.controller;

import com.common.idcardmanage.service.IdCardService;
import com.core.controller.BaseController;
import com.core.data.model.DataModel;
import com.core.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/api/idCard")
public class IdCardController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(IdCardController.class);

    @Autowired
    private IdCardService idCardService;


    /****
     * save idCard
     * @param request
     * @param requestMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @ResponseBody
    public Map<String, Object> saveIdCard(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            idCardService.saveIdCard(queryModel);
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationExcpetion(ve, resultModel);
        } catch (Exception e) {
            this.handleException(e, resultModel);
        }
        return resultModel;
    }
}
