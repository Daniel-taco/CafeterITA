package com.example.cafeterita;

public class ListElement {
    public String name;
    public String price;
    public String codeProd;

    public ListElement(String name, String price, String codeProd) {
        this.name = name;
        this.price = price;
        this.codeProd = codeProd;
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
    public String getCodeProd() {
        return codeProd;
    }

    public void setCodeProd(String codeProd) {
        this.codeProd = codeProd;
    }
}
