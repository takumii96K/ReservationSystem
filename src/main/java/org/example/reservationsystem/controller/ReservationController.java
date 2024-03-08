package org.example.reservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.reservationsystem.entity.Product;
import org.example.reservationsystem.form.ReservationForm;
import org.example.reservationsystem.service.spec.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//予約内容確認画面コントローラ
@Controller
@RequestMapping("takeout/product/reservation")
@RequiredArgsConstructor
public class ReservationController {
	// DI対象

	private final ProductService service;


	//入力した名前と電話番号を受け取る⇔Formに入る
	@ModelAttribute
	public ReservationForm setUpForm() {
		ReservationForm form = new ReservationForm();
		return form;
	}

	//注文内容を確認する
	@GetMapping("Product/{id}")
	public String showReservationForm(ReservationForm Form, @PathVariable Integer id, Model model) {
		Optional<Product> productOpt = service.selectOneById(id);
		//Optional<Reservation> ReservationOpt = ReservationOpt.map(t -> makeReservationForm(t));

		// 更新用のModelを作成する
		makeUpdateModel(ReservationForm form, Model model);
		return "confirmation";
	}
	   // 選択された商品の合計金額を表示
    @PostMapping("/products/selected")
    public String showSelectedProducts(@RequestParam("selectedProducts") List<Long> ids, Model model) {
        List<Product> selectedProducts = productService.getProductsByIds(ids);
        model.addAttribute("selectedProducts", selectedProducts);
        // 合計金額を計算
        double totalAmount = selectedProducts.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("totalAmount", totalAmount);
        return "selectedProducts"; // 選択された商品と合計金額を表示するビュー
    }

	/** 確定 */
	public String confirmReservation(@ModelAttribute ReservationForm form, Model model) {
        // ここで予約情報をデータベースに保存する処理を追加します
        // 例: service.saveReservation(form);

        // 予約完了ページやリストページにリダイレクト
        return "redirect:/reservation/confirm";
	}
}