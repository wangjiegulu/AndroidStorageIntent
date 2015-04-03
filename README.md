# AndroidStorageIntent
实现Activity间传递任意数据

##使用方式（从MainActivity跳转到OtherActivity，把MainActivity的当前对象传递到OtherActivity）
###MainActivity中：
    new StorageIntentCenter()
          .putExtra("iCommunicate", this) // 传递当前对象this（MainActivity），putExtra方法可以放置任何类型
          .putExtra("testString", "hello world")
          .putExtra("testFloat", 3.2f)
          .startActivity(context, OtherActivity.class);

###OtherActivity中重写initExtraFromStorage()方法，取出数据：
    iCommunicate = getExtraFromStorage("iCommunicate", ICommunicate.class);
    testString = getExtraFromStorage("testString", String.class);
    testFloat = getExtraFromStorage("testFloat", Float.class);

License
=======

    Copyright 2015 Wang Jie

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing blacklist and
    limitations under the License.
