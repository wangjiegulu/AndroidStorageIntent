package com.wangjie.androidstorageintent.library;

import com.wangjie.androidbucket.utils.ABTextUtil;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 3/30/15.
 */
public class StoragePool {
    /**
     * key   -- 标识是哪一个intent的（UUID）
     *
     *         |- key -- 存储的对象标识（StorageKey，使用UUID唯一）
     * value --|
     *         |- value -- 存储的内容
     */
    private static ConcurrentHashMap<String, HashMap<StorageKey, WeakReference<Object>>> storageMapper = new ConcurrentHashMap<>();

    private StoragePool() {
    }

    public static void storage(String tagUUID, StorageKey key, Object content) {
        if (null == key || null == content) {
            return;
        }
        HashMap<StorageKey, WeakReference<Object>> extraMapper = storageMapper.get(tagUUID);
        if (null == extraMapper) {
            extraMapper = new HashMap<>();
            storageMapper.put(tagUUID, extraMapper);
        }
        extraMapper.put(key, new WeakReference<>(content));
    }

    public static Object remove(String tagUUID, StorageKey key) {
        if (null == key) {
            return null;
        }
        HashMap<StorageKey, WeakReference<Object>> extraMapper = storageMapper.get(tagUUID);
        if (null == extraMapper) {
            return null;
        }

        WeakReference<Object> ref = extraMapper.remove(key);
        if (ABTextUtil.isEmpty(extraMapper)) {
            storageMapper.remove(tagUUID);
        }
        return null == ref ? null : ref.get();
    }

    public static HashMap<StorageKey, WeakReference<Object>> remove(String tagUUID) {
        if (null == tagUUID) {
            return null;
        }
        return storageMapper.remove(tagUUID);
    }

    public static void clear() {
        storageMapper.clear();
    }

}
