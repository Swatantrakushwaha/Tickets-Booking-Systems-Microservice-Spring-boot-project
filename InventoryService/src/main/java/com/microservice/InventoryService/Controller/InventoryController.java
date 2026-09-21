package com.microservice.InventoryService.Controller;

import com.microservice.InventoryService.Response.EventInventoryResponse;
import com.microservice.InventoryService.Service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class InventoryController {


    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping("/inventory/events")
     public List<EventInventoryResponse> inventoryGetAllEvents( ){
        return inventoryService.getAllEvents();
    }



}
