package com.nextstep.docker.servcie;

import com.nextstep.docker.Model.AuthUser;
import com.nextstep.docker.Model.Role;
import com.nextstep.docker.Repo.AuthRepo;
import com.nextstep.docker.Repo.RoleRepo;
import com.nextstep.docker.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepo roleRepo;
    @Autowired
    AuthRepo authRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void saveUser(AuthUser authUser) {
        try{

        Role roles = roleRepo.findByRoleName(Role.Roles.valueOf(authUser.getRoleName()));

        if (roles == null) {
            roles = new Role();
            String roleId = StringUtils.generateRandomAlphaNumeric(5);
            roles.setRoleName(Role.Roles.valueOf(authUser.getRoleName()));
            roles.setRole_id(roleId);
            roleRepo.save(roles);
        }

        authUser.setUserRoles(roles);

        if (authUser.getUserId() == null || authUser.getUserId().trim().isEmpty()) {
            String userId = StringUtils.generateRandomAlphaNumeric(5);
            authUser.setUserId(userId);
        }

        authUser.setUserRoles(roles);
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authRepo.save(authUser);

      }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println("error"+ex.getMessage());
        }
        }
}
