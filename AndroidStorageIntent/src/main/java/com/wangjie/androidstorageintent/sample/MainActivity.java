package com.wangjie.androidstorageintent.sample;

import android.view.View;
import com.wangjie.androidbucket.log.Logger;
import com.wangjie.androidinject.annotation.annotations.base.AIClick;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidstorageintent.R;
import com.wangjie.androidstorageintent.library.ICommunicate;
import com.wangjie.androidstorageintent.library.StorageIntentCenter;

@AILayout(R.layout.main)
public class MainActivity extends BaseActivity implements ICommunicate {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    @AIClick({R.id.ac_test_a_btn})
    public void onClickCallbackSample(View view) {
        switch (view.getId()) {
            case R.id.ac_test_a_btn:
//                startActivityForResult(new Intent(context, ACTestBActivity.class), 12345);
                new StorageIntentCenter()
                        .putExtra("iCommunicate", this)
                        .putExtra("testString", "hello world")
                        .putExtra("testFloat", 3.2f)
                        .startActivity(context, OtherActivity.class);

                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Logger.d(TAG, "requestCode: " + requestCode + ", resultCode: " + resultCode + ", data: " + data);
//        Logger.d(TAG, "result: " + (null == data ? "null" : data.getStringExtra("result")));
//    }

    @Override
    public void hello(String content) {
        Logger.d(TAG, "hello received: " + content);
    }

}
