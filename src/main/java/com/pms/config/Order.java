package com.pms.config;

/**
 *
 * @author Asu
 */
public class Order {

    private String orderID;
    private String orderName;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderName=" + orderName + '}';
    }

}
