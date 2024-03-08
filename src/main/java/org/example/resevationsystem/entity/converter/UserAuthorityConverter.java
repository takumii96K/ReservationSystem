package org.example.resevationsystem.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.resevationsystem.entity.enumeration.AuthorityKind;


/**
 * 権限種別の コード↔︎enum コンバーター
 */
@Converter(autoApply = true)
public class UserAuthorityConverter<AuthorityKin> implements AttributeConverter<AuthorityKind, String> {

    /**
     * enumからDB(code)へ変換
     * @param authorityKind 権限種別enum
     * @return Enumに対応するコード値
     */
    @Override
    public String convertToDatabaseColumn(AuthorityKind authorityKind) {
        return authorityKind.getCode();
    }

    /**
     * DB(code)からenumへ変換
     * @param dbData コード値
     * @return dbのコード値を権限種別enum
     */
    @Override
    public AuthorityKind convertToEntityAttribute(String dbData) {
        return AuthorityKind.from(dbData);
    }
}