package com.evoting.authservice.Controllers;

import com.evoting.authservice.Models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/auth")
public class authController {


    @GetMapping("/login/{username}/{password}")
    @ResponseBody
    public ResponseEntity<Response> login(@PathVariable String username, @PathVariable String password ) {

        if (username.equals("test") && password.equals("test")){

            Map<String, String> mydata = new HashMap<String, String>(){
                {
            put("token", "azeadkajdozkdj");
        }
            };
            return ResponseEntity.ok(
                Response.builder()
                        .data(mydata)
                        .message("login success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
        }else {
            return ResponseEntity.ok(
                    Response.builder()
                            .message("login failed")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build()
            );
        }
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello";
    }
}
