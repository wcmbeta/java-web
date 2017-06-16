package com.water.pojo;

/**
 * Created by Water on 2017/6/16.
 * Email:water471871679@gmail.com
 */
public class Product {
    /**
     * id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 价格
     */
    private String price;
    /**
     * 小图
     */
    private String smallIcon;
    /**
     * 是否免运费
     */
    private boolean isFreightFree;
    /**
     * 地址
     */
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

    public boolean isFreightFree() {
        return isFreightFree;
    }

    public void setFreightFree(boolean freightFree) {
        isFreightFree = freightFree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", smallIcon='" + smallIcon + '\'' +
                ", isFreightFree=" + isFreightFree +
                ", address='" + address + '\'' +
                '}';
    }
}
