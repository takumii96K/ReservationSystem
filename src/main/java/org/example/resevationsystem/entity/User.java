package org.example.resevationsystem.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.resevationsystem.entity.converter.UserAuthorityConverter;
import org.example.resevationsystem.entity.enumeration.AuthorityKind;

import java.io.Serializable;

@Entity
@Data
@Table(name ="user_table")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /* ユーザーID (PK)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /* ユーザー名 */
    @NotBlank
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    /* パスワード */
    @NotBlank

    @Column(name ="user_password", nullable = false)
    private String password;

    @NotNull
    @Column(name ="user_tel",nullable = false)
    private String tel;

    /* ユーザー権限種別 */
    @Convert(converter = UserAuthorityConverter.class)
    @Column(name = "authority_kind")
    private AuthorityKind authorities;

}