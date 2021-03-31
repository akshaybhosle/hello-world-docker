package com.tophat.interview.helloworld.controller;/* a0b02xy created on 2021-03-29 inside the package - com.tophat.interview.helloworld.controller */

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "/v1/hello")
public class HelloController {

  @GetMapping("/ping")
  public String index() {
    log.info("Ping info.");
    return "Hello World!";
  }

}
