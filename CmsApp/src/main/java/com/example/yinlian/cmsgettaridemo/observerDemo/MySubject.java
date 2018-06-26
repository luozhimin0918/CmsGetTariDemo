package com.example.yinlian.cmsgettaridemo.observerDemo;

/**
 * Created by Luozhimin on 2018-06-26.10:27
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        notifyObservers();
    }
}
