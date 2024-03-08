package org.example.resevationsystem.config;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.entity.User;
import org.example.resevationsystem.repository.JpaUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * DataInitializer
 * 起動時に実行
 *
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final JpaUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AdminProperties adminProperties; // プロパティファイルから読み込んだ管理者情報

    /**
     * 管理者プロパティの初期化
     * @param args args
     */
    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        //管理者ユーザーを初期登録(admin:Properties参照）
        User admin = new User();
        admin.setUserName(adminProperties.getUsername());
        admin.setPassword(passwordEncoder.encode(adminProperties.getPassword()));
        admin.setTel(adminProperties.getTel());
        admin.setAuthorities(adminProperties.getAuthorities());
        repository.save(admin);
    }
}