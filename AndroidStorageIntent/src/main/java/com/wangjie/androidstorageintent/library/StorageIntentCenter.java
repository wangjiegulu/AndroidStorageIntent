package com.wangjie.androidstorageintent.library;

import android.content.Context;
import android.content.Intent;
import com.wangjie.androidbucket.log.Logger;
import com.wangjie.androidbucket.utils.ABTextUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 3/31/15.
 */
public class StorageIntentCenter {
    public static final String STORAGE_INTENT_CENTER_KEY_UUID = StorageIntentCenter.class.getSimpleName() + "_UUID";
    private static final String TAG = StorageIntentCenter.class.getSimpleName();

    private Intent intent;
    private String uuid;
    private HashMap<StorageKey, Object> extras;
    private boolean isUsed;
    public StorageIntentCenter() {
        intent = new Intent();
        uuid = java.util.UUID.randomUUID().toString();
        intent.putExtra(STORAGE_INTENT_CENTER_KEY_UUID, uuid);
        isUsed = false;
    }

    public StorageIntentCenter putExtra(String intentKey, Object content){
        if (null == content) {
            return this;
        }
        StorageKey storageKey = new StorageKey(content.getClass());
        intent.putExtra(intentKey, storageKey);
        if(null == extras){
            extras = new HashMap<>();
        }
        extras.put(storageKey, content);
        return this;
    }

    public void startActivity(Context packageContext, Class<?> cls){
        if(isUsed){
            Logger.e(TAG, this + " can not be reuse!");
            return;
        }
        intent.setClass(packageContext, cls);
        if(!ABTextUtil.isEmpty(extras)){
            Set<Map.Entry<StorageKey, Object>> entrySet = extras.entrySet();
            for(Map.Entry<StorageKey, Object> entry : entrySet){
                StoragePool.storage(uuid, entry.getKey(), entry.getValue());
            }
        }
        isUsed = true;
        packageContext.startActivity(intent);
    }


}
