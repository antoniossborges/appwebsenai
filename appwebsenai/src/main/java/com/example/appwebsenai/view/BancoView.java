package com.example.appwebsenai.view;

import com.example.appwebsenai.controller.BancoController;
import com.example.appwebsenai.model.AccountType;
import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class BancoView {

    @Autowired
    private BancoController bancoController;


    @PostMapping("/criaconta")
    public ContaCorrentePF criarConta(@PathParam("name") String name, @PathParam("type") String type) throws Exception {
        return bancoController.criarConta(name, type);
    }

    @GetMapping("/type")
    public String listAccountType(){
        String text = AccountType.CONTA_CORRENTE + ", " + AccountType.CONTA_POUPANCA;
        return text;
    }

    @GetMapping("/consultaconta")
    public ContaCorrentePF consultaConta(@PathParam("name") String name){
        return bancoController.consultaConta(name);
    }

}
