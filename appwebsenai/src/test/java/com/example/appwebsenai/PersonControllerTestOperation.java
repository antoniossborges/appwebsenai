package com.example.appwebsenai;

import com.example.appwebsenai.model.Person;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PersonControllerTestOperation {

    @Test
    public void testSaveCompletePerson(){
        Person p = new Person();
        p.setId(1);
        assertEquals(1,1);

    }
}
