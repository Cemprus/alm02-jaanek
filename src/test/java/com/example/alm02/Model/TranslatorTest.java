package com.example.alm02.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();

    @Test
    void getDuration() {
        assertTrue(translator.getDuration(3).contains(" day"));
        assertTrue(translator.getDuration(6).contains(" week"));
        assertTrue(translator.getDuration(9).contains(" month"));
        assertTrue(translator.getDuration(10).contains(" year"));
    }

    @Test
    void getFirstPart() {
        translator.setPerson(new Person("a","","",0,0));
        assertTrue(translator.getFirstPart().contains("Next week will happen something which you have waited for more than a"));
        translator.setPerson(new Person("g","","",0,0));
        assertTrue(translator.getFirstPart().contains("You will have more bud luck next week then you had it for the entire"));
        translator.setPerson(new Person("m","","",0,0));
        assertTrue(translator.getFirstPart().contains("Good luck shall be yours for the entire"));
        translator.setPerson(new Person("x","","",0,0));
        assertTrue(translator.getFirstPart().contains("You shall receive more money than you expect for the next"));
    }

    @Test
    void getSecondPart() {
        translator.setPerson(new Person("","","",2,0));
        assertTrue(translator.getSecondPart().contains("day"));
        translator.setPerson(new Person("","","",2,1));
        assertTrue(translator.getSecondPart().contains("day"));
        translator.setPerson(new Person("","","",2,2));
        assertTrue(translator.getSecondPart().contains("day"));

        translator.setPerson(new Person("","","",22,0));
        assertTrue(translator.getSecondPart().contains("week"));
        translator.setPerson(new Person("","","",22,1));
        assertTrue(translator.getSecondPart().contains("week"));
        translator.setPerson(new Person("","","",22,2));
        assertTrue(translator.getSecondPart().contains("week"));

        translator.setPerson(new Person("","","",1,0));
        assertTrue(translator.getSecondPart().contains("month"));
        translator.setPerson(new Person("","","",1,1));
        assertTrue(translator.getSecondPart().contains("month"));
        translator.setPerson(new Person("","","",1,2));
        assertTrue(translator.getSecondPart().contains("month"));

        translator.setPerson(new Person("","","",17,0));
        assertTrue(translator.getSecondPart().contains("year"));
        translator.setPerson(new Person("","","",17,1));
        assertTrue(translator.getSecondPart().contains("year"));
        translator.setPerson(new Person("","","",17,2));
        assertTrue(translator.getSecondPart().contains("year"));
    }
    @Test
    void getThirdPart() {
        translator.setPerson(new Person("","a","a",0,0));
        assertTrue(translator.getThirdPart().contains("you next"));
        assertTrue(translator.getThirdPart().contains("you can"));
        translator.setPerson(new Person("","a","z",0,0));
        assertTrue(translator.getThirdPart().contains("your friend next"));
        assertTrue(translator.getThirdPart().contains("you can"));
        translator.setPerson(new Person("","z","a",0,0));
        assertTrue(translator.getThirdPart().contains("you next"));
        assertTrue(translator.getThirdPart().contains("your friend can"));
        translator.setPerson(new Person("","z","z",0,0));
        assertTrue(translator.getThirdPart().contains("your friend next"));
        assertTrue(translator.getThirdPart().contains("your friend can"));
    }

    @Test
    void getPerson() {
        assertNull(translator.getPerson());
        Person person = new Person();
        translator.setPerson(person);
        assertEquals(translator.getPerson(),person);
    }

    @Test
    void getRf() {
        assertNotNull(translator.getRf());
        RandomFactor rf = new RandomFactor();
        translator.setRf(rf);
        assertEquals(translator.getRf(),rf);
    }

    @Test
    void constructor() {
        Translator translator1 = new Translator();
        assertNull(translator1.getPerson());
        assertNotNull(translator1.getRf());
        Person person = new Person();
        Translator translator2 = new Translator(person);
        assertEquals(translator2.getPerson(), person);
        assertNotNull(translator1.getRf());
        RandomFactor rf = new RandomFactor();
        Translator translator3 = new Translator(person, rf);
        assertEquals(translator3.getPerson(), person);
        assertEquals(translator3.getRf(), rf);
    }
}