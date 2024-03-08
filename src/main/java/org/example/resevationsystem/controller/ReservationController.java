//
//package org.example.resevationsystem.controller;
//
//import java.util.Optional;
//
//import org.example.Reservationsystem.ReservationForm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
////予約内容確認画面コントローラ
//
//@RequestMapping("takeout/product/reservation")
//public class ReservationController {
//	// DI対象
//	@Autowired
//	ProductService service;
//
//
//	//入力した名前と電話番号を受け取る⇔Formに入る
//	@ModelAttribute
//	public ReservationForm setUpForm() {
//		ReservationForm form = new ReservationForm();
//		return form;
//	}
//
//	//注文内容を確認する
//	@GetMapping("Product/{id}")
//	public String showReservationForm(ReservationForm Form, @PathVariable Integer id, Model model) {
//		Optional<product> productOpt = service.selectOneById(id);
//		//Optional<Reservation> ReservationOpt = ReservationOpt.map(t -> makeReservationForm(t));
//
//		// 更新用のModelを作成する
//		makeUpdateModel(ReservationForm form, Model model);
//		return "confirmation";
//	}
//	   // 選択された商品の合計金額を表示
//    @PostMapping("/products/selected")
//    public String showSelectedProducts(@RequestParam("selectedProducts") List<Long> ids, Model model) {
//        List<Product> selectedProducts = productService.getProductsByIds(ids);
//        model.addAttribute("selectedProducts", selectedProducts);
//        // 合計金額を計算
//        double totalAmount = selectedProducts.stream().mapToDouble(Product::getPrice).sum();
//        model.addAttribute("totalAmount", totalAmount);
//        return "selectedProducts"; // 選択された商品と合計金額を表示するビュー
//    }
//
//	/** 確定 */
//	public String confirmReservation(@ModelAttribute ReservationForm form, Model model) {
//        // ここで予約情報をデータベースに保存する処理を追加します
//        // 例: service.saveReservation(form);
//
//        // 予約完了ページやリストページにリダイレクト
//        return "redirect:/reservation/confirm";
//	}
//}
