package com.model.message.service;

import com.model.message.enums.MessageCategoryEnum;
import lombok.Data;

@Data
public class Message {
    private String messageKey;
    private MessageCategoryEnum messageCategory;
    private String fieldId;
    private Object rejectedValue;
    private Object[] messageParameters;

    public Message(String[] codes, Object[] messageParameters, String defaultMessage) {
    }

    public Message(MessageCategoryEnum messageCategory, String messageKey, Object[] messageParameters, String fieldId) {
        this.messageKey = messageKey;
        this.messageCategory = messageCategory;
        this.fieldId = fieldId;
        this.messageParameters = messageParameters;
    }

    public Message(MessageCategoryEnum messageCategory, String messageKey, Object[] messageParameters, String fieldId,
                   Object rejectedValue) {
        this.messageKey = messageKey;
        this.messageCategory = messageCategory;
        this.fieldId = fieldId;
        this.rejectedValue = rejectedValue;
        this.messageParameters = messageParameters;
    }
}
