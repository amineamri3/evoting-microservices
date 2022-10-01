package com.evoting.chatbotservice.Controllers;

import com.evoting.chatbotservice.Models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/test")
public class testController {


    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<Response> methodName() {

        if (true){

            Map<String, String> mydata = new HashMap<String, String>(){
                {
                    put("key1Example", "Value1Example");
                    put("key2Example", "Value2Example");
                }
            };
            return ResponseEntity.ok(
                    Response.builder()
                            .data(mydata)
                            .message("response success")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()
            );
        }else {
            return ResponseEntity.ok(
                    Response.builder()
                            .message("response error")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build()
            );
        }
    }
}
