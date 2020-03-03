package doan.stores.bussiness.implement;

import doan.stores.bussiness.UserService;
import doan.stores.domain.User;
import doan.stores.domain.UserPrincipal;
import doan.stores.persistenct.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser() {

    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserNameIs(userName);
    }

    @Override
    public UserPrincipal loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserNameIs(userName);
        if (user == null) {
            log.error("Unknown User");
            throw new UsernameNotFoundException("Unknown User");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new UserPrincipal(
                user, true, true, true, true,
                grantedAuthorities);
    }

}
