
package org.example.resevationsystem.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.form.ReservationForm;
import org.example.resevationsystem.service.spec.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 予約画面コントローラー
 * 個人情報入力フォームと、確定商品と金額の表示
 */
@Controller
@RequestMapping("takeout/product")
@RequiredArgsConstructor
public class ReservationController {

	private final ReservationService serivice;
//	private final ProductService service;

	/**
	 * ReservationFormをModelに格納する
	 * @param model objname:"ReservationForm"
	 */
	@ModelAttribute
	public void setUpForm(Model model) {
		ReservationForm form = new ReservationForm();
		model.addAttribute("ReservationForm",form);
	}

	//注文内容を確認する
	@GetMapping("/reservation")
	public String showReservationForm(ReservationForm Form, @PathVariable Integer id, Model model) {
		Optional<product> productOpt = service.selectOneById(id);
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
