package model;

import java.io.Serializable;

public class Product implements Serializable{
    private Integer id;
    private String productno;
    private String productname;
    private double price;

    // 新增的建構子（帶有 id）
    public Product(Integer id, String productno, String productname, double price) {
        this.id = id;
        this.productno = productno;
        this.productname = productname;
        this.price = price;
    }

    // 原本的建構子（不帶 id，用於新增產品）
    public Product(String productno, String productname, double price) {
        this.productno = productno;
        this.productname = productname;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
