package com.example.demo.Models;


public class ClientsModel {

    private Long   id;
    private String name      ;
    private String last_name ;
    private int    mobile    ;
    


    public ClientsModel() {
    }

    public ClientsModel(Long id, String name, String last_name, int mobile) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.mobile = mobile;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getMobile() {
        return this.mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", mobile='" + getMobile() + "'" +
            "}";
    }





    
}
