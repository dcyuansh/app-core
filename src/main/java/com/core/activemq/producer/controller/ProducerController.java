/*
package com.core.activemq.producer.controller;

import com.core.controller.AbstractBaseController;
import com.core.data.model.DataModel;
import com.core.exception.ValidationException;
import com.core.utils.UUidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

*/
/**
 * @author DC Yuan
 * @version 1.0
 *//*

@RestController
@RequestMapping("/api/mq")
public class ProducerController extends AbstractBaseController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue mailQueue;

    @RequestMapping(method = RequestMethod.POST, value = "/queue")
    public Map<String, Object> sendQueue(HttpServletRequest request, @RequestBody Map<String, Object> requestMap) {
        DataModel resultModel = new DataModel();
        try {
            String message = UUidUtils.getUUID() + " ---> " + requestMap.toString();
            LOG.info("发布队列sms.mail.queue信息：" + message);
            jmsMessagingTemplate.convertAndSend(this.mailQueue, message);
        } catch (ValidationException ve) {
            this.handleValidationException(resultModel, ve);
        } catch (Exception e) {
            this.handleException(resultModel, e);
        }
        return resultModel;
    }
}
*/
