package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "clients")
public class ClientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name      ;
    private String last_name ;
    private int    mobile    ;


    public ClientsEntity() {
    }

    public ClientsEntity(Long id, String name, String last_name, int mobile) {
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
