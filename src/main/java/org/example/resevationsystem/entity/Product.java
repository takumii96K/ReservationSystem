package org.example.resevationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;	
	private String productName;
	private int productPrice;
	private int productStock;
}
