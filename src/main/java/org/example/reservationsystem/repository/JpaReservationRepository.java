package org.example.reservationsystem.repository;

import org.example.reservationsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long>{

}
