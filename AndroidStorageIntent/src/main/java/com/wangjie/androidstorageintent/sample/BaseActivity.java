package com.wangjie.androidstorageintent.sample;

import android.os.Bundle;
import com.wangjie.androidinject.annotation.present.AIActivity;
import com.wangjie.androidstorageintent.library.StorageIntentCenter;
import com.wangjie.androidstorageintent.library.StorageKey;
import com.wangjie.androidstorageintent.library.StoragePool;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 4/2/15.
 */
public class BaseActivity extends AIActivity {
    private String storageIntentCenterUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initExtraFromStorage();
        // remove extra from StoragePool
        StoragePool.remove(storageIntentCenterUUID);
    }

    protected void initExtraFromStorage() {
    }

    protected final <T> T getExtraFromStorage(String key, Class<T> contentType) {
        StorageKey storageKey = (StorageKey) getIntent().getSerializableExtra(key);
        if (null == storageIntentCenterUUID) {
            storageIntentCenterUUID = getIntent().getStringExtra(StorageIntentCenter.STORAGE_INTENT_CENTER_KEY_UUID);
        }
        return (T) StoragePool.remove(storageIntentCenterUUID, storageKey);
    }

}
