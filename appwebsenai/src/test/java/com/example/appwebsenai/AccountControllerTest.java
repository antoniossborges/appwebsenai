package com.example.appwebsenai;

import com.example.appwebsenai.controller.Controller;
import com.example.appwebsenai.model.ContaCorrentePF;
import com.example.appwebsenai.model.Person;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountControllerTest {

    @Autowired
    private Controller personController;

    @Test
    @Order(1)
    public void _1testSavePerson() {
        Person antonio = personController.addPerson("antonio", "m");
        Assertions.assertNotNull(antonio.getId());
        Assertions.assertEquals(antonio.getName(), "antonio");
        Assertions.assertEquals(antonio.getId(), 1);
    }

    @Test
    @Order(2)
    public void _2testFindPerson() {
        _1testSavePerson();
        Person antonio = personController.findPerson("antonio");
        Assertions.assertNotNull(antonio.getId());
        Assertions.assertEquals(antonio.getId(), 1);
        Assertions.assertEquals(antonio.getName(), "antonio");
        Assertions.assertEquals(antonio.getSexo(), "m");
    }

    @Test
    @Order(3)
    public void _3testUpdatePerson() {
        _1testSavePerson();
        Person antonio = personController.findPerson("antonio");
        antonio.setName("Antonio");
        antonio.setContaCorrentePF(new ContaCorrentePF());
        personController.editPerson(antonio);
        Assertions.assertNotNull(antonio.getId());
        Assertions.assertEquals(antonio.getId(), 1);
        Assertions.assertEquals(antonio.getSexo(), "m");
        Assertions.assertEquals(antonio.getName(), "Antonio");
        Assertions.assertNotNull(antonio.getContaCorrentePF());
    }

    @Test
    @Order(4)
    public void _2testFindPersonById() {
        _1testSavePerson();
        Person antonio = personController.findPersonById(1);
        Assertions.assertNotNull(antonio.getId());
        Assertions.assertEquals(antonio.getId(), 1);
        Assertions.assertEquals(antonio.getName(), "antonio");
        Assertions.assertEquals(antonio.getSexo(), "m");
    }


}
