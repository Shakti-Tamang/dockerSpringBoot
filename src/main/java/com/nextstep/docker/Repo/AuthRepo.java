package com.nextstep.docker.Repo;

import com.nextstep.docker.Model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<AuthUser, String> {
//    public AuthUser findByUserRoles_Role_id(String username);

    public AuthUser findByUserName(String username);

    public AuthUser findByEmail(String email);

}
