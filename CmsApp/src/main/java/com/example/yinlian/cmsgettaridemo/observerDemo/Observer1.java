package com.example.yinlian.cmsgettaridemo.observerDemo;

import com.socks.library.KLog;

/**
 * Created by Luozhimin on 2018-06-26.9:53
 */
public class Observer1 implements observer {
    @Override
    public void update() {
        KLog.d("observer hava received");
    }

}
