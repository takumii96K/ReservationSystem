package org.example.reservationsystem.service.spec;

import org.example.reservationsystem.entity.User;
import org.example.reservationsystem.form.UserRegistrationForm;

public interface UserService {


    void registerUser(UserRegistrationForm form);

    /**
     * ユーザー削除
     */
    void deleteUser(Long id);

    void updateUser(User user);
}
