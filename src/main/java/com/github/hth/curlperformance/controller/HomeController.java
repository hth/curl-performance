package com.github.hth.curlperformance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class HomeController {

    @RequestMapping
    public Mono<ResponseEntity<String>> home() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("Home of lord"));
    }
}
