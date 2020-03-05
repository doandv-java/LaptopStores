package doan.stores.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserRequest {

    private Long id;

    private String userName;

    private String password;

    private String role;

    private String name;

    private String birthDay;

    private int gender;

    private String address;

    private String phone;

    private String imageLink;

    private MultipartFile image;

    private int state;

    private int deleted;

    private String userNameOld;
}

