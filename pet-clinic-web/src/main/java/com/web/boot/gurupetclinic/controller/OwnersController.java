package com.web.boot.gurupetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){

        return "owners/index";
    }
}
