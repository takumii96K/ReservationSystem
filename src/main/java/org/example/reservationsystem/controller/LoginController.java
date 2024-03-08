package org.example.reservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.reservationsystem.entity.converter.UserRegistrationFormConverter;
import org.example.reservationsystem.form.UserRegistrationForm;
import org.example.reservationsystem.service.spec.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService service;
    private final UserRegistrationFormConverter convert;

    /**
     * UserRegisterFromをモデル属性に追加
     * @param model ${inputRegisterFrom}
     */
    @ModelAttribute
    public void setUpRegisterForm(Model model){
        UserRegistrationForm registerForm = new UserRegistrationForm();
        model.addAttribute("inputRegisterForm", registerForm);
    }


    @PostMapping("/register")
    public String submitForm(BindingResult result, Model model) {
        if (result.hasErrors()) {
            // エラー処理
            return "somepage";
        }
        // データ処理
        return "login"; //ログイン画面へ
    }

    @GetMapping("/login")
    public String loginForm(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("failureMessage", "IDもしくはパスワードが違います");
        }
        return "login";
    }

    /**
     * 登録画面のGET
     * @return 登録画面 "register.html"
     */
    @GetMapping("/register")
    public String registerUser(){
        return "register";
    }


    /**
     * ゲストで商品選択画面へGETリクエスト
     */
    @GetMapping("/takeout/product")
    public String showProductMenu(){
        return "product";
    }

}
