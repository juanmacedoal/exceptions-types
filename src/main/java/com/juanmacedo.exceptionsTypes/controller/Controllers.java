package com.juanmacedo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Controllers {

  @GetMapping("/random")
  String getRandomInfo();
}
