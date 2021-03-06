package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageRequest;

/**
 * 订单查询请求类
 * request URL: https://serverurl/app/order/list
 * request method: post
 */
public class QueryOrderRequest extends PageRequest {

    //订单状态：-1——全部；0——待付款；1——待发货；2——待收货
    private int orderStatus;

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "QueryOrderRequest{" +
                "orderStatus=" + orderStatus +
                '}';
    }
}
