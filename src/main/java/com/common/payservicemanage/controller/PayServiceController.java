package com.common.payservicemanage.controller;

import com.common.payservicemanage.service.PayRouteService;
import com.core.controller.AbstractBaseController;
import com.core.data.model.DataModel;
import com.core.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author spring.yuan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/pay")
public class PayServiceController extends AbstractBaseController {

    @Autowired
    private PayRouteService payRouteService;


    @RequestMapping(method = RequestMethod.POST, value = "/send")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel payModel = this.getInputData(requestMap);
            DataModel payResult = payRouteService.pay(payModel);
            this.handleSuccess(payResult, resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }
}
