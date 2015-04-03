package com.wangjie.androidstorageintent.sample;

import android.os.Bundle;
import android.view.View;
import com.wangjie.androidbucket.log.Logger;
import com.wangjie.androidinject.annotation.annotations.base.AIClick;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidstorageintent.R;
import com.wangjie.androidstorageintent.library.ICommunicate;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 4/2/15.
 */
@AILayout(R.layout.other)
public class OtherActivity extends BaseActivity{
    private static final String TAG = OtherActivity.class.getSimpleName();

    private ICommunicate iCommunicate;
    private String testString;
    private Float testFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initExtraFromStorage() {
        iCommunicate = getExtraFromStorage("iCommunicate", ICommunicate.class);
        testString = getExtraFromStorage("testString", String.class);
        testFloat = getExtraFromStorage("testFloat", Float.class);
    }

    @Override
    @AIClick({R.id.other_btn})
    public void onClickCallbackSample(View view) {
        switch(view.getId()){
            case R.id.other_btn:
//                Intent intent = getIntent();
//                intent.putExtra("result", "success");
//                setResult(RESULT_OK, intent);
//                finish();

                if(null == iCommunicate){
                    return;
                }
                Logger.d(TAG, "iCommunicate: " + iCommunicate);
                iCommunicate.hello("content from ACTestBActivity!");

                Logger.d(TAG, "testString: " + testString);
                Logger.d(TAG, "testFloat: " + testFloat);
                finish();

                break;
        }
    }
}