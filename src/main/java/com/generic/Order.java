package com.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 */
public class Order<T> {

    private String orderName;

    private int orderId;

    private T t;

    public List<T> list = new ArrayList<>();

    /**
     * 声明泛型方法
     *
     * @param e
     * @param <E>
     * @return
     */
    public <E> E getE(E e) {
        return e;
    }

    /**
     * 实现数组到集合的复制
     *  <T> T[] toArray(T[] a);
     * @param e
     * @param <E>
     * @return
     */
    public <E> List<E> toArray(E[] e, List<E> list) {
        for (E e1 : e) {
            list.add(e1);
        }
        return list;
    }

    public void add() {
        list.add(t);
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", t=" + t +
                '}';
    }


}



