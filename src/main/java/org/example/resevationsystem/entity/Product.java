package org.example.resevationsystem.entity;

import jakarta.persistence.Column;
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
	@Column(name = "product_id")
	private long productId;		//商品ID
	
	@Column(name = "product_name")
	private String productName;	//商品名
	
	@Column(name = "product_price")
	private int productPrice;	//売上金額
	
	@Column(name = "product_stock")
	private int productStock;	//在庫数
}
