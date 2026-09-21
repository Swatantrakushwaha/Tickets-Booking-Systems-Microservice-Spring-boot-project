package com.microservice.InventoryService.Repository;

import com.microservice.InventoryService.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VenueRepository  extends JpaRepository<Venue , Long> {
}
