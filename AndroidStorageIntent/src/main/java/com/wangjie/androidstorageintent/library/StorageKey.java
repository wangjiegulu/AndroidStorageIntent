package com.wangjie.androidstorageintent.library;

import java.io.Serializable;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 3/30/15.
 */
public class StorageKey implements Serializable {
    private long generateKeyTime;
    private String contentTypeName;
    private String uuid;

    public StorageKey(){
        generateKeyTime = System.currentTimeMillis();
        uuid = java.util.UUID.randomUUID().toString();
    }
    public StorageKey(Class contentType) {
        this();
        this.contentTypeName = contentType.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ((Object)this).getClass() != o.getClass()) return false;

        StorageKey that = (StorageKey) o;

        return that.uuid.equals(uuid);
    }

    @Override
    public int hashCode() {
        int result = (int) (generateKeyTime ^ (generateKeyTime >>> 32));
        result = 31 * result + (contentTypeName != null ? contentTypeName.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return String.format("%d_%s_%s", generateKeyTime, contentTypeName, uuid);
    }
}
