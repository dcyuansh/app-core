package com.common.payservicemanage.controller;

import com.common.payservicemanage.service.PayRouteService;
import com.controller.AbstractBaseController;
import com.model.data.DataModel;
import com.model.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author DC Yuan
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
            this.handleSuccess(resultModel, payResult);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }
}
