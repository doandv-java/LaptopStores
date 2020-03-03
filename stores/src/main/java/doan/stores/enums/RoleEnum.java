package doan.stores.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum RoleEnum {
    ROLE_CUSTOMER(0, "ROLE_CUSTOMER"),
    ROLE_EMP(1, "ROLE_EMP"),
    ROLE_ADMIN(2, "ROLE_ADMIN");


    private int code;

    private String text;

    RoleEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static RoleEnum ofCode(int code) {
        return EnumSet.allOf(RoleEnum.class).stream()
                .filter(roleEnum -> roleEnum.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public static RoleEnum ofText(String text) {
        return EnumSet.allOf(RoleEnum.class).stream()
                .filter(roleEnum -> roleEnum.getText().equals(text))
                .findFirst()
                .orElse(null);
    }

}
