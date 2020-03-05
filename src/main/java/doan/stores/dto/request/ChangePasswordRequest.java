package doan.stores.dto.request;

import doan.stores.validation.annotation.EqualsString;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@EqualsString(first = "passwordNew", second = "confirmPassword", message = "Mật khẩu mới chưa hợp lệ")
public class ChangePasswordRequest {

    @NotBlank(message = "Mật khẩu không được để rỗng")
    private String passwordOld;

    @NotBlank(message = "Mật khẩu mới chưa được nhập")
    private String passwordNew;
    @NotBlank(message = "Bạn chưa nhập lại mật khẩu")
    private String confirmPassword;
}
