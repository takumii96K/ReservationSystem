package org.example.resevationsystem.service.spec;


import java.util.List;

import org.example.resevationsystem.entity.Reservation;

public interface ReservationService 
{
	List<Reservation> getReservationAll(); //全件取得

}
