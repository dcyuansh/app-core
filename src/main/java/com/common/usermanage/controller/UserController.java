package com.common.usermanage.controller;

import com.common.usermanage.service.UserService;
import com.core.controller.AbstractBaseController;
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
import java.util.List;
import java.util.Map;


/**
 * @author DC Yuan
 * @version 1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends AbstractBaseController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    /**
     * @param request
     * @param requestMap
     * @return
     * @desc save user info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @ResponseBody
    public Map<String, Object> saveUser(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            userService.saveUser(queryModel);
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * @param request
     * @param requestMap
     * @return
     * @desc user login
     */
    @RequestMapping(method = RequestMethod.POST, value = "/query")
    @ResponseBody
    public Map<String, Object> findUser(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            DataModel userModel = userService.findUser(queryModel);
            this.handleSuccess(resultModel, userModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * @param request
     * @param requestMap
     * @return
     * @desc query all user info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/query/all")
    @ResponseBody
    public Map<String, Object> findUserList(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            List<DataModel> userModel = userService.findUserList(queryModel);
            this.handleSuccess(resultModel, userModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * @param request
     * @return
     * @desc delete user info by user name
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ResponseBody
    public Map<String, Object> deleteUser(HttpServletRequest request) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(request);
            userService.deleteUser(queryModel);
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }


    /**
     * @param request
     * @param requestMap
     * @return
     * @desc update user info by user name
     */
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    @ResponseBody
    public Map<String, Object> updateUser(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            DataModel queryModel = this.getInputData(requestMap);
            userService.updateUser(queryModel);
            this.handleSuccess(resultModel);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }
}
