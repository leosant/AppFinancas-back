package com.appfinancas.controllers.v1;

import com.appfinancas.controllers.AbstractUserController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends AbstractUserController {
}
