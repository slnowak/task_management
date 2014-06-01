package com.springapp.mvc.service;

import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by novy on 01.06.14.
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.springapp.mvc.model.User user = userDao.getByPrimaryKey(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(com.springapp.mvc.model.User user, List<GrantedAuthority> authorities) {
        final String username = user.getUsername();
        final String password = user.getPassword();
        boolean isEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked;
        isEnabled = accountNonExpired = credentialsNonExpired = accountNonLocked = user.getActive();

        return new User(username, password, isEnabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(authorities);
    }
}

