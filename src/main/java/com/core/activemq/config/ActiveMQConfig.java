/*
package com.core.activemq.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


*/
/**
 * @author dc.yuan
 * @version 1.0
 *//*

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;


    */
/**
     * @return
     * @desc 邮件队列
     *//*

    @Bean(name = "mailQueue")
    public Queue mailQueue() {
        return new ActiveMQQueue("sms.mail.queue");
    }

    */
/**
     * @return
     * @desc 任务队列
     *//*

    @Bean(name = "taskQueue")
    public Queue taskQueue() {
        return new ActiveMQQueue("sms.task.queue");
    }

    */
/**
     * @return
     * @desc 发布主题
     *//*

    @Bean(name = "topic")
    public Topic topic() {
        return new ActiveMQTopic("sms.topic");
    }

    */
/**
     * @return
     * @desc 发布提醒主题
     *//*

    @Bean(name = "remindTopic")
    public Topic remindTopic() {
        return new ActiveMQTopic("sms.remind.topic");
    }


    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(username, password, brokerUrl);
    }

    @Bean(name = "jmsMessageTemplate")
    public JmsMessagingTemplate jmsMessageTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }


    */
/**
     * @param connectionFactory
     * @return
     * @desc 在Queue模式中，对消息的监听需要对containerFactory进行配置
     *//*

    @Bean("queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }


    */
/**
     * @param connectionFactory
     * @return
     * @desc 在Topic模式中，对消息的监听需要对containerFactory进行配置
     *//*

    @Bean("topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
*/
