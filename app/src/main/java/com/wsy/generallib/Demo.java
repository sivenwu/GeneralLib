package com.wsy.generallib;

import android.app.Activity;
import android.os.Bundle;

import com.nostra13.universalimageloader.utils.L;
import com.wsy.generallib.model.BaiduMode;

import cn.wsy.httplib.HttpClientUtil;
import cn.wsy.httplib.HttpRespondResult;
import cn.wsy.httplib.base.HttpMethod;

/**
 * Created by wsy on 16/7/14.
 */
public class Demo extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoForHttp();
    }

    public void demoForHttp(){
        HttpClientUtil.SEND(HttpMethod.POST_JSON, this,new BaiduMode("wusy1", "wusy2")
                , new HttpRespondResult() {
                    @Override
                    public void onSuccess(String content) {
                        L.i("wusy "+content);
                    }

                    @Override
                    public void onFailure(Throwable error, String content) {

                    }
                });
    }
}
