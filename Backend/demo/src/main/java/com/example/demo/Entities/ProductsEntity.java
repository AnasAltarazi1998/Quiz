package com.example.demo.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name          ;
    private String description   ;
    private String category      ;
    private Date   creation_date ;
    private int    quantities    ;
    private int    price         ;

    public ProductsEntity() {
    }

    public ProductsEntity(Long id, String name, String description, String category, Date creation_date, int quantities,int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.creation_date = creation_date;
        this.quantities = quantities;
        this.price = price;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getQuantities() {
        return this.quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "{" +
                "  id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", category='" + getCategory() + "'" +
                ", creation_date='" + getCreation_date() + "'" +
                ", quantities='" + getQuantities() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }







    
    
}
