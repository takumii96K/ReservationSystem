package org.example.resevationsystem.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Form */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductForm {
	
	/** 商品（ID） */
	private Integer id;
	
	/** 商品名 */
	private String productName;
	
	/** 商品金額 */
	private Integer productPrice;
	
	/** 在庫個数 */
	private Integer stock;

}
