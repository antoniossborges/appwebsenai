package com.example.appwebsenai;

import com.example.appwebsenai.controller.BancoController;
import com.example.appwebsenai.controller.BancoRepository;
import com.example.appwebsenai.model.AccountType;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountControlerMockTest {
    @MockBean
    private BancoRepository bancoRepositoryMock;
    @Autowired
    private BancoController bancoController;

    @Test
    public void testRentabilidade(){

        ContaCorrentePF c = criaConta();
        when(bancoRepositoryMock.findById(1L)).thenReturn(Optional.of(c));
        bancoRepositoryMock.findById(1l);

        ContaCorrentePF conta = bancoController.consultaConta(1l);
        Assertions.assertEquals(100, conta.getSaldo(), "Método de rentabildade foi afetado");

        verify(bancoRepositoryMock).findById(1l);


    }

    private ContaCorrentePF criaConta(){
        ContaCorrentePF contaParaTeste = new ContaCorrentePF();
        contaParaTeste.setNumeroConta(1L);
        contaParaTeste.setSaldo(100D);
        contaParaTeste.setAccountType(AccountType.CONTA_POUPANCA);

        return contaParaTeste;
    }
}
