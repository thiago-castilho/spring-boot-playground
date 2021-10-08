package dev.rrlabs.hellorrlabs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @GetMapping("/teste")
    public ResponseEntity<Hello> hello() {
        log.info("Hello Thiago");
        return ResponseEntity.ok(Hello.builder().message("Hello Thiago").build());
    }
}
