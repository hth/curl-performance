package com.github.hth.curlperformance;

import com.github.hth.curlperformance.controller.HomeController;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CurlPerformanceApplicationTests {

    @Test
    void contextLoads() {
    }

    @RepeatedTest(3)
    void doSomething() {
        Mono<ResponseEntity<String>> home = new HomeController().home();
        StepVerifier.create(home)
                .expectNext(ResponseEntity.ok("Home of lord"))
                .verifyComplete();
    }
}
