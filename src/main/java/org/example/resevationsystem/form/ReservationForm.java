package org.example.resevationsystem.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Form*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationForm {

	//商品id
	private Integer productId;
	//商品名
	private String productName;
	//注文者名
	private String customerName;
	//注文者電話番号
	private String tel;

}