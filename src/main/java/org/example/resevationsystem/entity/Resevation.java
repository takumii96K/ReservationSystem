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
public class Resevation
{
	private long resevationId;
	private String resevationName;
	private LocalDateTime dateTime;
	private String address;
	private boolean status;
	
}
