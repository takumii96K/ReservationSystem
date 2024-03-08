package org.example.reservationsystem.config;

import lombok.RequiredArgsConstructor;
import org.example.reservationsystem.entity.User;
import org.example.reservationsystem.repository.JpaUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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