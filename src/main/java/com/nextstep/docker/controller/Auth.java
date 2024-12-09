package com.nextstep.docker.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("v1/docker/user")
@Tag(name = "Create user",description = "api for authenticating user")
public class Auth {
    private static final Logger logger= LoggerFactory.getLogger(Auth.class);


}
