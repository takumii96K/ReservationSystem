package org.example.reservationsystem.service.spec;


import java.util.List;

import org.example.reservationsystem.entity.Reservation;

public interface ReservationService 
{
	List<Reservation> getReservationAll(); //全件取得

}
