package org.example.resevationsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation
{

	//主キー
	@Id
	private long resevationId;
	private String resevationName;
	private LocalDateTime dateTime;
	private String tel;
	private boolean status;
	
}
