package com.example.yinlian.cmsgettaridemo.observerDemo;


/**
 * Created by Luozhimin on 2018-06-26.10:10
 */
public interface Subject {
    /*增加观察者*/
    public void add(observer observer);

    /*删除观察者*/
    public void del(observer observer);

    /*通知所有的观察者*/
    public void notifyObservers();

    /*自身的操作*/
    public void operation();
}
