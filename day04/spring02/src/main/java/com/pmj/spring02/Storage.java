package com.pmj.spring02;

// 제네릭
public class Storage<P> {
    private P item;

    public P getItem() {
        return item;
    }

    public void setItem(P item) {
        this.item = item;
    }

}
