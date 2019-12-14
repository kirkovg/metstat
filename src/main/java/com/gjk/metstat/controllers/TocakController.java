package com.gjk.metstat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TocakController {

  @RequestMapping(value = "/protected", method = GET)
  public String protectedResource() {
    return "Voska";
  }
}
