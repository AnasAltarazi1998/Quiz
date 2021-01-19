package com.example.demo.Controllers;

import java.util.Date;
import java.util.List;

import com.example.demo.Entities.ProductsEntity;
import com.example.demo.Entities.SalesEntity;
import com.example.demo.Models.SalesModel;
import com.example.demo.Models.SalesOperationModel;
import com.example.demo.Repositories.ClientsRepository;
import com.example.demo.Repositories.ProductsRepository;
import com.example.demo.Repositories.SalesRepository;
import com.example.demo.services.EToM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( path = "/sales" )
public class SalesController {

    @Autowired
    SalesRepository salesRepository ;
    @Autowired
    ProductsRepository productsRepository ;
    @Autowired
    ClientsRepository clientsRepository ;
    @Autowired 
    EToM service ;


    @GetMapping( path = "/fetch")
    public List<SalesModel> fetchSalesOperations(){

        return service.convertSalesFromListEntityToListModel(salesRepository.fetchAllSales().get());

    }

    @PostMapping( path = "/update")
    public SalesModel editSale(@RequestBody SalesModel salesModel ){

        SalesEntity salesEntity = new SalesEntity();

        if (salesRepository.findById(salesModel.getId()).isPresent()){

            salesEntity = salesRepository.findById(salesModel.getId()).get();
            salesEntity.setId(salesModel.getId());
            salesEntity.setQuantities_of_sale(salesModel.getQuantities_of_sale());
            salesEntity.setTotal(salesModel.getTotal());
            salesEntity = salesRepository.save(salesEntity);
            return service.convertSalesFromEntityToModel(salesEntity);

        }
        else{

            salesModel.setTotal(-1);
            return salesModel;
            
        }
    }  

    @GetMapping(path = "/sale")
    public void saleOperation( @RequestBody SalesOperationModel salesOperationModel  ){

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity = productsRepository.findByName(salesOperationModel.getProduct_name()).get();
        productsEntity.setQuantities( productsEntity.getQuantities() -  salesOperationModel.getQuentities() );
        productsRepository.save(productsEntity);

        SalesEntity salesEntity = new SalesEntity();
        salesEntity.setClientEntity(clientsRepository.findByName(salesOperationModel.getClient_name()).get());
        salesEntity.setSeller(salesOperationModel.getSaller_name());
        salesEntity.setTotal(salesOperationModel.getTotal());
        salesEntity.setQuantities_of_sale(salesOperationModel.getQuentities());
        salesEntity.setCreation_date(new Date());

        salesRepository.save(salesEntity);             
    } 
}