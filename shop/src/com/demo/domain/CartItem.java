package com.demo.domain;

/**
 * 购物车项 javabean
 */
public class CartItem {
    private Product product;
    private int buyNum;
    private double subtotal;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
