package com.wsy.generallib;

import android.app.Activity;
import android.os.Bundle;

import com.wsy.generallib.model.BaiduMode;

import cn.wsy.httplib.HttpClientUtil;
import cn.wsy.httplib.HttpRespondResult;
import cn.wsy.httplib.RequestEnetity;
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
        HttpClientUtil.SEND(HttpMethod.POST, this, new RequestEnetity(new BaiduMode("wusy1", "wusy2"),false)
                , new HttpRespondResult() {
                    @Override
                    public void onSuccess(String content) {

                    }

                    @Override
                    public void onFailure(Throwable error, String content) {

                    }
                });
    }
}
