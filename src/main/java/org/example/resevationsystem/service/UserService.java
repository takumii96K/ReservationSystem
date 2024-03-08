package org.example.resevationsystem.service;

import org.example.resevationsystem.entity.User;
import org.example.resevationsystem.form.UserRegistrationForm;

public interface UserService {


    void registerUser(UserRegistrationForm form);
    /**
     * ユーザー削除
     */
    void deleteUser(Long id);

    void updateUser(User user);
}
