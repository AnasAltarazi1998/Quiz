package com.example.demo.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "sales")
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String seller               ;
    private Date   creation_date        ;
    private double total                ;
    private int    quantities_of_sale   ;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private ClientsEntity clientEntity        ;

    public SalesEntity() {
    }

    public SalesEntity(Long id, String seller, Date creation_date, double total, int quantities_of_sale, ClientsEntity clientEntity) {
        this.id = id;
        this.seller = seller;
        this.creation_date = creation_date;
        this.total = total;
        this.quantities_of_sale = quantities_of_sale;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Date getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantities_of_sale() {
        return this.quantities_of_sale;
    }

    public void setQuantities_of_sale(int quantities_of_sale) {
        this.quantities_of_sale = quantities_of_sale;
    }

    public ClientsEntity getClientEntity() {
        return this.clientEntity;
    }

    public void setClientEntity(ClientsEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", seller='" + getSeller() + "'" +
            ", creation_date='" + getCreation_date() + "'" +
            ", total='" + getTotal() + "'" +
            ", quantities_of_sale='" + getQuantities_of_sale() + "'" +
            ", clientEntity='" + getClientEntity() + "'" +
            "}";
    }

    
    
}