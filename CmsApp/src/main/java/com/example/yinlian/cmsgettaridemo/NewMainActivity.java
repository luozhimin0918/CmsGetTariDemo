package com.example.yinlian.cmsgettaridemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.yinlian.tariff.index.ApiManager;
import com.example.yinlian.tariff.model.ReqDetailJson;
import com.socks.library.KLog;

public class NewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
