package com.nextstep.docker.controller;

import com.nextstep.docker.Model.AuthUser;
import com.nextstep.docker.Repo.AuthRepo;
import com.nextstep.docker.Reponse.ApiResponse;
import com.nextstep.docker.servcie.JwtService;
import com.nextstep.docker.servcie.UserDetailInfo;
import com.nextstep.docker.servcie.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("v1/docker")
@Tag(name = "Create user", description = "api for authenticating user")
public class Auth {


    private static final Logger logger = LoggerFactory.getLogger(Auth.class);


    @Autowired
    AuthRepo authRepo;
    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/saveUser")
    @Operation(summary = "save user", description = "api for registering user")
    public ResponseEntity<ApiResponse> saveAllUsers(@Valid @RequestBody AuthUser auth) {
        AuthUser authUser = authRepo.findByUserName(auth.getUserName());

        if (authUser != null) {

            ApiResponse apiResponse = ApiResponse.builder().message("user alreday exist").statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
        userService.saveUser(auth);

        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping("/logIn")
    @Operation(summary = "login", description = "api to login")
    public ResponseEntity<ApiResponse> logInUser(@RequestBody AuthUser authUser) {
        AuthUser authUser1 = authRepo.findByEmail(authUser.getEmail());

        if (authUser1 != null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUser1.getUserName(), authUser.getPassword()));

            if (authentication.isAuthenticated()) {
                UserDetailInfo userDetails = (UserDetailInfo) authentication.getPrincipal();
                String token = jwtService.GenerateToken(userDetails);
                String refreshToken = jwtService.GenerateRefreshToken(userDetails);

                ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).token(token).refresh_token(refreshToken).build();
                return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
            } else {
                ApiResponse apiResponse = ApiResponse.builder().message("usernot found").statusCode(HttpStatus.UNAUTHORIZED.UNAUTHORIZED.value()).build();
                return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
            }

        } else {
            ApiResponse apiResponse = ApiResponse.builder().message("unauthrorized access").statusCode(HttpStatus.NOT_FOUND.value()).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
    }


}
