package com.core.message.service;

import com.core.message.service.impl.MessageManagerImpl;

import java.util.List;

public abstract class AbstractMessageManager {

    private static AbstractMessageManager message_instance;

    public static AbstractMessageManager getInstance() {
        if (message_instance == null) {
            message_instance = new MessageManagerImpl();
        }
        return message_instance;
    }

    public abstract boolean hasMessage(String messageKey);

    public abstract boolean hasSuccessMessages();

    public abstract boolean hasErrorMessages();

    public abstract boolean hasWarningMessages();

    public abstract boolean hasInfoMessages();

    public abstract void addErrorMessage(String messageKey);

    public abstract void addWarningMessage(String messageKey);

    public abstract void addInfoMessage(String messageKey);

    public abstract void addSuccessMessage(String messageKey);

    public abstract List<Message> getAllMessage();
}
