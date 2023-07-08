package com.core.message.service;

import com.core.utils.KeyGenerationUtils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MessageStorageManager {

    private volatile static MessageStorageManager c_instance;

    private static final String SETUP_FOR_REQUEST_INDICATOR = "setup.for.request";

    private final Map storagePerThreadMap = new Hashtable();


    public static MessageStorageManager getInstance() {
        if (c_instance == null) {
            synchronized (KeyGenerationUtils.class) {
                if (c_instance == null) {
                    c_instance = new MessageStorageManager();
                }
            }
        }
        return c_instance;
    }

    public boolean has(String key) {
        Object value = getRequestStorageMap().get(key);
        boolean valueExists = value != null;
        return valueExists;
    }

    public Object get(String key) {
        Map rsm = getRequestStorageMap();
        Object value = rsm.get(key);
        if (value == null) {
            IllegalArgumentException e = new IllegalArgumentException("Illegal Argument'" + key + "'");
            throw e;
        }
        return value;
    }


    public void set(String key, Object value) {
        getRequestStorageMap().put(key, value);
    }

    public Object remove(String key) {
        Map rsm = getRequestStorageMap();
        Object value = rsm.remove(key);
        if (value == null) {
            IllegalArgumentException e = new IllegalArgumentException("Illegal Argument '" + key + "'");
            throw e;
        }
        return value;
    }

    private void clear() {
        getRequestStorageMap().clear();
    }

    public boolean isSetupForRequest() {
        boolean setupForRequest = false;
        if (has(SETUP_FOR_REQUEST_INDICATOR)) {
            setupForRequest = ((Boolean) get(SETUP_FOR_REQUEST_INDICATOR)).booleanValue();
        }
        return setupForRequest;
    }

    private void setupForRequest(Map map) {
        if (map != this.getRequestStorageMap()) {
            clear();
            if (map != null) {
                storagePerThreadMap.put(Thread.currentThread(), map);
            } else {
                storagePerThreadMap.put(Thread.currentThread(), new HashMap());
            }
            set(SETUP_FOR_REQUEST_INDICATOR, Boolean.TRUE);
        }
    }

    public void cleanupFromRequest() {
        clear();
        set(SETUP_FOR_REQUEST_INDICATOR, Boolean.FALSE);
    }

    public void resetFromRequest() {
        if (storagePerThreadMap.containsKey(Thread.currentThread())) {
            storagePerThreadMap.remove(Thread.currentThread());
        }
        storagePerThreadMap.put(Thread.currentThread(), new HashMap());
    }

    private Map getRequestStorageMap() {
        Map map = (Map) storagePerThreadMap.get(Thread.currentThread());
        if (map == null) {
            map = new HashMap();
            storagePerThreadMap.put(Thread.currentThread(), map);
        }
        return map;
    }
}
