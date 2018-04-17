package com.demo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车 javabean
 */
public class Cart {
    //该购物车中存储的n个购物项
    private Map<String,CartItem> cartItems = new HashMap<String,CartItem>();

    //购物车的商品总计
    private double total;

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotal() {
        return total;
    }
}
