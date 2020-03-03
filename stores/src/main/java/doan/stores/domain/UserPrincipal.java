package doan.stores.domain;

import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;

public class UserPrincipal extends org.springframework.security.core.userdetails.User {

    private User user;

    public UserPrincipal(User user, boolean enabled, boolean accountNonExpired,
                         boolean credentialsNonExpired,
                         boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserName(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
