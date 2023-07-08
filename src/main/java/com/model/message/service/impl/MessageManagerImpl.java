package com.model.message.service.impl;

import com.model.message.enums.MessageCategoryEnum;
import com.model.message.service.Message;
import com.model.message.service.AbstractMessageManager;
import com.model.message.service.MessageStorageManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageManagerImpl extends AbstractMessageManager {


    private void addMessage(MessageCategoryEnum messageCategory, String messageKey) {
        Map messageMap = getMessages(messageCategory);
        messageMap.put(messageKey, new Message(messageCategory, messageKey, null, null, null));
    }


    private Map getMessages(MessageCategoryEnum messageCategory) {
        Map messageMap;
        String messageCategoryName = messageCategory.toString();
        if (MessageStorageManager.getInstance().has(messageCategoryName)) {
            messageMap = (Map) MessageStorageManager.getInstance().get(messageCategoryName);
        } else {
            messageMap = new LinkedHashMap();
            MessageStorageManager.getInstance().set(messageCategoryName, messageMap);
        }
        return messageMap;
    }


    @Override
    public List<Message> getAllMessage() {
        List<Message> allMessages = new ArrayList<>();
        allMessages.addAll(getMessages(MessageCategoryEnum.ERROR).values());
        allMessages.addAll(getMessages(MessageCategoryEnum.WARNING).values());
        allMessages.addAll(getMessages(MessageCategoryEnum.INFO).values());
        allMessages.addAll(getMessages(MessageCategoryEnum.SUCCESS).values());
        return allMessages;
    }


    @Override
    public void addErrorMessage(String messageKey) {
        addMessage(MessageCategoryEnum.ERROR, messageKey);
    }


    @Override
    public void addWarningMessage(String messageKey) {
        addMessage(MessageCategoryEnum.WARNING, messageKey);
    }


    @Override
    public void addInfoMessage(String messageKey) {
        addMessage(MessageCategoryEnum.INFO, messageKey);
    }


    @Override
    public void addSuccessMessage(String messageKey) {
        addMessage(MessageCategoryEnum.SUCCESS, messageKey);
    }


    @Override
    public boolean hasMessage(String messageKey) {
        boolean containKey = false;
        containKey = hasMessage(MessageCategoryEnum.ERROR, messageKey);
        if (!containKey) {
            containKey = hasMessage(MessageCategoryEnum.SUCCESS, messageKey);
        }
        if (!containKey) {
            containKey = hasMessage(MessageCategoryEnum.WARNING, messageKey);
        }
        if (!containKey) {
            containKey = hasMessage(MessageCategoryEnum.INFO, messageKey);
        }
        return containKey;
    }

    private boolean hasMessage(MessageCategoryEnum messageCategory, String messageKey) {
        Map messageMap = getMessages(messageCategory);
        return messageMap.containsKey(messageKey);
    }

    @Override
    public boolean hasSuccessMessages() {
        return getMessages(MessageCategoryEnum.SUCCESS).size() > 0;
    }

    @Override
    public boolean hasErrorMessages() {
        return getMessages(MessageCategoryEnum.ERROR).size() > 0;
    }

    @Override
    public boolean hasWarningMessages() {
        return getMessages(MessageCategoryEnum.WARNING).size() > 0;
    }

    @Override
    public boolean hasInfoMessages() {
        return getMessages(MessageCategoryEnum.INFO).size() > 0;
    }
}
