package org.example.reservationsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private long reservationId;

	@NotNull
	@Column(name="customer_name")
	private String CustomerName;//予約者の名前

	@NotNull
	@Column(name="reservation_time")
	private LocalDateTime dateTime;	//予約日時

	@Column(name="customer_name")
	private String tel;				//電話番号
}