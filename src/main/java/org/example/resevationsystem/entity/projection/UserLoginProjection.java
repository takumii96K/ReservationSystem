package org.example.resevationsystem.entity.projection;

import org.example.resevationsystem.entity.enumeration.AuthorityKind;

/**
 * 認証用 ユーザーログインプロジェクション
 */
public interface UserLoginProjection {
    String getUserName();
    String getPassword();
    AuthorityKind getAuthorities();
}