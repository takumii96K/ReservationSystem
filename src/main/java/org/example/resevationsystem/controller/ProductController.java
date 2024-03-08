package org.example.resevationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.entity.Product;
import org.example.resevationsystem.form.ProductForm;
import org.example.resevationsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
	/* DI対象 */

	private final ProductService service;

	/**
	 * セットアップ時に商品リストを全件取得する。
	 * @param model
	 */
	@ModelAttribute
	public void setupProductForm(Model model){
		ProductForm form = new ProductForm();
		List<Product> products = service.getAllProducts();
		model.addAttribute("ProductForm", form);
		model.addAttribute("products", products);
	}
	// 商品選択画面を表示
	@GetMapping
	public String showProductSelection(Model model) {
		// 商品一覧を取得してモデルに追加
		model.addAttribute("product", service.getSelectAll());
		return "product";
	}


	@PostMapping
	public String someAction(@ModelAttribute SomeForm form, HttpSession session) {
		// セッションにフォームデータを格納
		session.setAttribute("formData", form);
		// 何らかの処理...
		return "redirect:/nextPage";
	}

	@PostMapping("/reservation")
	public String showReservationPage() {
		// 予約ページへ
		return "reservation";
	}

}
