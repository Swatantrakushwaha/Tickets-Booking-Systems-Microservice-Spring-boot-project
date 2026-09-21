package com.microservice.InventoryService.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {




    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "totalCapacity")
    private  Long totalCapacity;

    @Column(name = "leftCapacity")
     private Long leftCapacity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;


}
