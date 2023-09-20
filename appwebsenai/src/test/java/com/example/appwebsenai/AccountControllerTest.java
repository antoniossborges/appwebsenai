package com.example.appwebsenai;

import com.example.appwebsenai.controller.Controller;
import com.example.appwebsenai.model.Person;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountControllerTest {

    @Autowired
    private Controller personController;

    @BeforeEach
    public void setup() {
        int i = 0;

    }

    @Test
    public void testSavePerson() {
        Person antonio = personController.addPerson("Antonio", "m");
        Assertions.assertNotNull(antonio.getId());
        Assertions.assertEquals(antonio.getId(), 1);
    }

    @Test
    public void testFindPerson() {
        Person antonio = personController.findPerson("antonio");
        Assertions.assertNull(antonio.getId());

    }


}
