package org.example.reservationsystem.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Form*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationForm {
	
	//商品ID
private Integer id;

private String name;

private String tel;

///**[登録」or「変更」判定用*/
//private Boolean newQuiz;


}