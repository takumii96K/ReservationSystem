package org.example.resevationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.entity.Product;
import org.example.resevationsystem.service.spec.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/** Productコントローラ */
@Controller
@RequestMapping("/takeout/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@ModelAttribute
	public void setupProductForm(Model model){
		List<Product> products = service.getAllProducts();
		model.addAttribute("products", products);

	}

	// 商品選択画面を表示
	@GetMapping
	public String showProductSelection(Model model) {
		return "/product";
	}

	@PostMapping("/reservation")
	public String showReservationPage() {
		// 予約ページへ
		return "reservation";
	}

}
