package com.example.demo.Models;

public class SalesOperationModel {

    private String product_name ;
    private String client_name ;
    private String saller_name ;
    private int quentities ;
    private double total ;


    public SalesOperationModel() {
    }

    public SalesOperationModel(String product_name, String client_name, String saller_name, int quentities, double total) {
        this.product_name = product_name;
        this.client_name = client_name;
        this.saller_name = saller_name;
        this.quentities = quentities;
        this.total = total;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getClient_name() {
        return this.client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getSaller_name() {
        return this.saller_name;
    }

    public void setSaller_name(String saller_name) {
        this.saller_name = saller_name;
    }

    public int getQuentities() {
        return this.quentities;
    }

    public void setQuentities(int quentities) {
        this.quentities = quentities;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
            " product_name='" + getProduct_name() + "'" +
            ", client_name='" + getClient_name() + "'" +
            ", saller_name='" + getSaller_name() + "'" +
            ", quentities='" + getQuentities() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }

    
}
