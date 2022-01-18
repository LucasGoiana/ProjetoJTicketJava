package br.com.lucasgoiana.projetojticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("profile")
public class ProfileController {

    @GetMapping(value = "/")
    public void getAllBankOfBlood() {
        // return bankOfBloodService.getAllBankOfBlood();
    }
}