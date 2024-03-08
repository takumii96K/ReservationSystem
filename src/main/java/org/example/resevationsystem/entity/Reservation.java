package org.example.resevationsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation
{
	private long reservationId;
	private String reserverName;	//予約者の名前
	private LocalDateTime dateTime;	//予約日時
	private String tel;				//電話番号
}
