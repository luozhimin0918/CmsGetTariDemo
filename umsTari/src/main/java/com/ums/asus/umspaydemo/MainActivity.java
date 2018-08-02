package com.ums.asus.umspaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinlian.tariff.index.ApiManager;
import com.example.yinlian.tariff.model.ReqDetailJson;
import com.example.yinlian.tariff.model.TariffInfoRespBean;
import com.socks.library.KLog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @butterknife.BindView(R.id.taocanOne)
    TextView taocanOne;
    @butterknife.BindView(R.id.taocanTwo)
    TextView taocanTwo;
    @butterknife.BindView(R.id.taocanThree)
    TextView taocanThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        ApiManager apiManager = ApiManager.getInstance(getApplicationContext());
        ReqDetailJson reqDetailJson = new ReqDetailJson();
        reqDetailJson.setTariffDescList("");
        apiManager.getTariffInfo("4637b348589c493fbac91b6b5f0029f1", reqDetailJson, new ApiManager.RespCallBack() {
            @Override
            public void onResponse(String jsonRespString) {
             /*  TariffInfoRespBean  tariffInfoRespBean =    JSON.parseObject(jsonRespString, TariffInfoRespBean.class);
                if(tariffInfoRespBean!=null&&tariffInfoRespBean.getState()!=null&&tariffInfoRespBean.getState().equals("0001")){

                    if(tariffInfoRespBean.getData()!=null&&tariffInfoRespBean.getData().getTariffInfoList()!=null){

                        List<TariffInfoRespBean.DataBean.TariffInfoListBean> infoListBeanList = tariffInfoRespBean.getData().getTariffInfoList();

                        for(int i =0;i<infoListBeanList.size();i++){
                            String infoStr ="";
                            TariffInfoRespBean.DataBean.TariffInfoListBean OnTari =   infoListBeanList.get(i);
                            infoStr+=OnTari.getTariffTag()+":"+OnTari.getTariffDesc()+"\n";
                            infoStr+="原价："+OnTari.getOriginalPrice()+"\n";
                            infoStr+="现价："+OnTari.getPresentPrice()+"\n";
                            infoStr+="折扣价："+OnTari.getDiscount()+"\n";
                            infoStr+="试用期："+OnTari.getProbation()+"天\n";
                            if(i==0){
                                taocanOne.setText(infoStr);
                            }else if(i==1){
                                taocanTwo.setText(infoStr);
                            }else if(i==2){
                                taocanThree.setText(infoStr);
                            }
                        }
                    }


                }else{
                    Toast.makeText(getApplicationContext(),tariffInfoRespBean.getMsg(),Toast.LENGTH_SHORT).show();
                }*/
                KLog.json("ApiMa", jsonRespString);
            }
        }, new ApiManager.RespErrorCallBack() {
            @Override
            public void onError(String errorStr) {
                KLog.d("ApiMa", errorStr);
            }
        });
    }
}
