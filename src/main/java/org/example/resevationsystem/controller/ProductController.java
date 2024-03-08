package org.example.resevationsystem.controller;

import org.example.resevationsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Productコントローラ */
@Controller
@RequestMapping("/takeout/product")
public class ProductController {

	/* DI対象 */
	@Autowired
	ProductService service;

	// 商品選択画面を表示
	@GetMapping("/product")
	public String showProductSelection(Model model) {
		// 商品一覧を取得してモデルに追加
		model.addAttribute("product", service.getSelectAll());
		return "product";
	}

	@PostMapping("/reservation")
	public String showReservationPage() {
		// 予約ページへ
		return "reservation";
	}
}
