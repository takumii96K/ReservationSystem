package org.example.resevationsystem.service;

import java.util.List;

import org.example.resevationsystem.entity.Reservation;
import org.example.resevationsystem.repository.JpaReservationRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
	
	private final JpaReservationRepository repository;

	@Override
	public List<Reservation> getReservationAll() {
		
		return repository.findAll();
	}
	
}
