package com.example.demo.Controllers;

import java.util.List;

import com.example.demo.Entities.ClientsEntity;
import com.example.demo.Models.ClientsModel;
import com.example.demo.Repositories.ClientsRepository;
import com.example.demo.services.EToM;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/clients")
public class ClientsController {

    @Autowired
    ClientsRepository clientsRepository ;
    @Autowired
    EToM service ;

    
    @PostMapping( path = "/create")
    public ClientsModel createClient( @RequestBody ClientsModel clientsModel ){

        ClientsEntity clientsEntity = new ClientsEntity();

        if ( clientsRepository.findByMobile(clientsModel.getMobile()).isPresent()){

            clientsModel.setName("error"); 
            return clientsModel ;

        }
        else{

            clientsEntity = service.convertClientFromModelToEntity(clientsModel);
            clientsEntity = clientsRepository.save(clientsEntity);
            clientsModel  = service.convertClientFromEntityToModel(clientsEntity);
            return clientsModel ;

        }
    }

    @GetMapping( path = "/fetch")
    public List<ClientsModel> fetchClients(){

        return service.convertClientFromListEntityToListModel(clientsRepository.fetchAllClients().get());

    }

    @PostMapping( path = "/edit")
    public ClientsModel editClient(@RequestBody ClientsModel clientsModel ){

        ClientsEntity clientsEntity = new ClientsEntity();

        if (clientsRepository.findById(clientsModel.getId()).isPresent()){

            clientsEntity = clientsRepository.findById(clientsModel.getId()).get();
            clientsEntity = service.convertClientFromModelToEntity(clientsModel);
            clientsEntity = clientsRepository.save(clientsEntity);
            return service.convertClientFromEntityToModel(clientsEntity);

        }
        else{

            clientsEntity.setName("error");
            return service.convertClientFromEntityToModel(clientsEntity);
            
        }
    }  
    
    
}
