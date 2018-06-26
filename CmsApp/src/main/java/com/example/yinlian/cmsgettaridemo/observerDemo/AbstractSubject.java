package com.example.yinlian.cmsgettaridemo.observerDemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Luozhimin on 2018-06-26.10:18
 */
public abstract class AbstractSubject implements Subject {
    Vector<observer> observerVector =new Vector<>();

    @Override
    public void add(observer observer) {
        observerVector.add(observer);
    }

    @Override
    public void del(observer observer) {
           observerVector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<observer> enumeration =observerVector.elements();
        while (enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }

    }

    @Override
    public void operation() {

    }
}
