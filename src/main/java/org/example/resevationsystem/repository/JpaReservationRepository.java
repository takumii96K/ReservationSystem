package org.example.resevationsystem.repository;

import org.example.resevationsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long>{

}
