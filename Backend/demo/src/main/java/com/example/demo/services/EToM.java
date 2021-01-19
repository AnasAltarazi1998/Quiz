package com.example.demo.services;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.Entities.ClientsEntity;
import com.example.demo.Entities.ProductsEntity;
import com.example.demo.Entities.SalesEntity;
import com.example.demo.Models.ClientsModel;
import com.example.demo.Models.ProductsModel;
import com.example.demo.Models.SalesModel;

import org.springframework.stereotype.Service;

@Service
public class EToM {


                    //// Products services

    public ProductsModel convertProductFromEntityToModel( ProductsEntity p ){

        ProductsModel model = new ProductsModel();

        model.setId(p.getId());
        model.setName(p.getName());
        model.setCategory(p.getCategory());
        model.setCreation_date(p.getCreation_date());
        model.setDescription(p.getDescription());
        model.setPrice(p.getPrice());
        model.setQuantities(p.getQuantities());

        return model;

    }

    public ProductsEntity convertProductFromModelToEntity( ProductsModel productsModel ){

        ProductsEntity entity = new ProductsEntity();

        entity.setId(productsModel.getId());
        entity.setName(productsModel.getName());
        entity.setCategory(productsModel.getCategory());
        entity.setCreation_date(productsModel.getCreation_date());
        entity.setDescription(productsModel.getDescription());
        entity.setPrice(productsModel.getPrice());
        entity.setQuantities(productsModel.getQuantities());

        return entity;

    }

    public List<ProductsModel> convertProductFromListEntityToListModel( List<ProductsEntity> ListEntity ){
        List<ProductsModel> ListModel = new LinkedList<>();

        for (ProductsEntity productsEntity : ListEntity) {
            ListModel.add(convertProductFromEntityToModel(productsEntity));
        }
        
        return ListModel;
    }


                         //// Clients services


    public ClientsModel convertClientFromEntityToModel( ClientsEntity c ){

        ClientsModel model = new ClientsModel();

        model.setId(c.getId());
        model.setName(c.getName());
        model.setLast_name(c.getLast_name());
        model.setMobile(c.getMobile());

        return model;

    }

    public ClientsEntity convertClientFromModelToEntity(ClientsModel clientsModel) {
        
        ClientsEntity entity = new ClientsEntity();

        entity.setId(clientsModel.getId());
        entity.setName(clientsModel.getName());
        entity.setLast_name(clientsModel.getLast_name());
        entity.setMobile(clientsModel.getMobile());

        return entity;
    }
    
    public List<ClientsModel> convertClientFromListEntityToListModel( List<ClientsEntity> ListEntity ){
        List<ClientsModel> ListModel = new LinkedList<>();

        for (ClientsEntity clientsEntity : ListEntity) {
            ListModel.add(convertClientFromEntityToModel(clientsEntity));
        }
        
        return ListModel;
    }



                    //// Sales services


    public SalesModel convertSalesFromEntityToModel( SalesEntity s ){

        SalesModel model = new SalesModel();

        model.setId(s.getId());
        model.setClient(s.getClientEntity().getName());
        model.setCreation_date(s.getCreation_date());
        model.setSeller(s.getSeller());
        model.setTotal(s.getTotal());
        model.setQuantities_of_sale(s.getQuantities_of_sale());

        return model;

    }


    public List<SalesModel> convertSalesFromListEntityToListModel( List<SalesEntity> ListEntity ){
        List<SalesModel> ListModel = new LinkedList<>();

        for (SalesEntity salesEntity : ListEntity) {
            ListModel.add(convertSalesFromEntityToModel(salesEntity));
        }
        
        return ListModel;
    }


	

	
    
}
