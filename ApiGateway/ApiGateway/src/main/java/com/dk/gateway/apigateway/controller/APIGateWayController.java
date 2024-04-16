package com.dk.gateway.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gateway")
public class APIGateWayController {





    @GetMapping
    public ResponseEntity<List<String>> findAPIGateway(){
        List<String> returnArray=new ArrayList<>();
        returnArray.add("String1");
        return ResponseEntity.ok(returnArray);
    }



}
