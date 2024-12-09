package com.nextstep.docker.servcie;

import com.nextstep.docker.Model.AuthUser;
import com.nextstep.docker.Repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AuthUser user = userRepo.findByUserName(username);
        if(user == null){

            throw new UsernameNotFoundException("could not found user..!!");
        }

        return new UserDetailInfo(user);
    }


}