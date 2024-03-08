package org.example.reservationsystem.entity.projection;

import org.example.reservationsystem.entity.enumeration.AuthorityKind;

/**
 * 認証用 ユーザーログインプロジェクション
 */
public interface UserLoginProjection {
    String getUserName();
    String getPassword();
    AuthorityKind getAuthorities();
}