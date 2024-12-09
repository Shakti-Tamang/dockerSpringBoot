package com.nextstep.docker.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "auth_user")
public class AuthUser {
    @Schema(hidden = true)
    @Id
    private String userId;

    @Column(nullable = false)
    @Schema(required = true)
    private String userName;

    @Column(nullable = false)
    @Schema(required = true)
    @Email(message = "must be email")
    private String email;

    @Column(nullable = false)
    @Schema(required = true)
    private String password;

    @Column(nullable = false)
    @Schema(required = true)
    private String roleName;

    @Schema(hidden = true)
    @ManyToOne()
    @JsonManagedReference("userRole")
    @JoinColumn(name = "role_id")
    private Role userRoles;
}
