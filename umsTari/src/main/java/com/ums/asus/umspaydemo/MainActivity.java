package com.ums.asus.umspaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yinlian.tariff.index.ApiManager;
import com.example.yinlian.tariff.model.ReqDetailJson;
import com.socks.library.KLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.taocanOne)
    TextView taocanOne;
    @BindView(R.id.taocanTwo)
    TextView taocanTwo;
    @BindView(R.id.taocanThree)
    TextView taocanThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ApiManager apiManager = ApiManager.getInstance(getApplicationContext());
        ReqDetailJson reqDetailJson = new ReqDetailJson();
        reqDetailJson.setTariffDescList("");
        apiManager.getTariffInfo("4637b348589c493fbac91b6b5f0029f1", reqDetailJson, new ApiManager.RespCallBack() {
            @Override
            public void onResponse(String jsonRespString) {
                try {
                    JSONObject dd = new JSONObject(jsonRespString);
                    String state = dd.getString("state");
                    if (state != null && state.equals("0001")) {
                        JSONObject jsonObject = dd.getJSONObject("data");
                        JSONArray ewe = jsonObject.getJSONArray("tariffInfoList");
                        for (int i = 0; i < ewe.length(); i++) {
                            JSONObject ddd = ewe.getJSONObject(i);
                            String infoStr = "";
                            infoStr += ddd.getString("tariffTag") + ":" + ddd.getString("tariffDesc") + "\n";
                            infoStr += "原价：" + ddd.getInt("originalPrice") + "\n";
                            infoStr += "现价：" + ddd.getInt("presentPrice") + "\n";
                            infoStr += "折扣价：" + ddd.getInt("discount") + "\n";
                            infoStr += "试用期：" + ddd.getInt("probation") + "天\n";
                            if (i == 0) {
                                taocanOne.setText(infoStr);
                            } else if (i == 1) {
                                taocanTwo.setText(infoStr);
                            } else if (i == 2) {
                                taocanThree.setText(infoStr);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    @OnClick({R.id.taocanOne, R.id.taocanTwo, R.id.taocanThree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.taocanOne:
                break;
            case R.id.taocanTwo:
                break;
            case R.id.taocanThree:
                break;
        }
    }
}
