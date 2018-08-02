package com.ums.asus.umspaydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yinlian.tariff.index.ApiManager;
import com.example.yinlian.tariff.model.ReqDetailJson;
import com.socks.library.KLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiManager apiManager=ApiManager.getInstance(getApplicationContext());
        ReqDetailJson reqDetailJson=new ReqDetailJson();
        reqDetailJson.setTariffDescList("");
        apiManager.getTariffInfo("4637b348589c493fbac91b6b5f0029f1",reqDetailJson,new ApiManager.RespCallBack() {
            @Override
            public void onResponse(String jsonRespString) {
                KLog.json("ApiMa",jsonRespString);
            }
        }, new ApiManager.RespErrorCallBack() {
            @Override
            public void onError(String errorStr) {
                KLog.d("ApiMa",errorStr);
            }
        });
    }
}
