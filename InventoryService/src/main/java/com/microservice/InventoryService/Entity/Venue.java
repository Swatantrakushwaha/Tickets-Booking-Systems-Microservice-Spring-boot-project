package com.microservice.InventoryService.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venue")
public class Venue {



    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "totalCapacity")
    private  Long totalCapacity;


    @Column(name = "address")
    private  String address;





}
