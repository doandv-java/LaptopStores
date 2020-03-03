package doan.stores.bussiness;

import doan.stores.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void saveUser();

    User findUserByUserName(String userName);

}
