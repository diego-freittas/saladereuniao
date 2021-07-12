package br.com.diegofreitas.saladereuniao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("teste")
    public String testControler(){
        return "Teste Controler";
    }
}
