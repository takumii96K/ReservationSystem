package org.example.resevationsystem.service.userdetails;

import lombok.RequiredArgsConstructor;
import org.example.resevationsystem.entity.projection.UserLoginProjection;
import org.example.resevationsystem.form.UserRegistrationForm;
import org.example.resevationsystem.repository.JpaUserRepository;
import org.example.resevationsystem.service.spec.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * UserDetailサービス
 */
@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService, UserService {

    private final JpaUserRepository repository;

    /**
     * User情報をDBからロードする
     *
     * @param username the username identifying the user whose data is required.
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //ログイン情報をレコードに取得
        UserLoginProjection record = repository.findProjectionByUserName(username);

        //レコードの有無を確認
        if (record == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // ユーザーに割り当てられた権限でGrantedAuthorityリストを作成
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(record.getAuthorities().toString()));

        // UserDetailsを生成
        return new User(record.getUserName(), record.getPassword(), authorities);
    }

    /**
     * ユーザー登録
     * @param user user
     */
    @Override
    public void registerUser(UserRegistrationForm form) {

    }

    /**
     * ユーザー削除
     * @param id userId
     */
    @Override
    public void deleteUser(Long id) {repository.deleteById(id);}

    /**
     * ユーザー情報更新
     * @param user user
     */
    @Override
    public void updateUser(org.example.resevationsystem.entity.User user) {
        repository.save(user);
    }
}
