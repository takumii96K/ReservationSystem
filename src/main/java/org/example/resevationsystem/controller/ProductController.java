package org.example.resevationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.service.spec.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Productコントローラ */
@Controller
@RequestMapping("/takeout/product")
@RequiredArgsConstructor
public class ProductController {
	/* DI対象 */

	private final ProductService service;

	// 商品選択画面を表示
	@GetMapping
	public String showProductSelection(Model model) {
		// 商品一覧を取得してモデルに追加
		model.addAttribute("product", service.getAllProducts());
		return "product";
	}

	@PostMapping()
	public String showReservationPage() {
		// 予約ページへ
		return "reservation";
	}

}
