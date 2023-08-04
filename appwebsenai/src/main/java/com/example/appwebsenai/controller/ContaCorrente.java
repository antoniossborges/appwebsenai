package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;

import javax.websocket.server.PathParam;

public interface ContaCorrente {

    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    Double consultaSaldo(ContaCorrentePF conta);

}
