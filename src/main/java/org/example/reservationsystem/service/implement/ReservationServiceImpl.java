package org.example.reservationsystem.service.implement;

import java.util.List;

import org.example.reservationsystem.entity.Reservation;
import org.example.reservationsystem.repository.JpaReservationRepository;
import org.example.reservationsystem.service.spec.ReservationService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
	
	private final JpaReservationRepository repository;

	@Override
	public List<Reservation> getReservationAll() {
		
		return repository.findAll();
	}
	
}
