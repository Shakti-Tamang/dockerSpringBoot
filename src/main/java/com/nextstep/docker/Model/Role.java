package com.nextstep.docker.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Schema(hidden = true)
    @Id
    private String role_id;
    //    Using @Enumerated(EnumType.STRING) ensures that the string
//    representation (e.g., "Worker", "Admin", "President") of the enum values
//            is stored in the database, rather than their ordinal
//                    values (0, 1, 2).
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles roleName;

    @OneToMany(mappedBy ="userRoles",cascade = CascadeType.ALL)
    @JsonManagedReference("userRole")
    private List<AuthUser> rolesUser;

    public enum Roles {
        Worker,
        Admin,
        President
    }


}


