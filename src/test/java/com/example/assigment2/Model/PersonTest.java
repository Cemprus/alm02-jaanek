package com.example.assigment2.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testSetAndGet() {
		Person p = new Person();
		p.setName("test");
		assertEquals("test", p.getName());
		p.setNationality("test1");
		assertEquals("test1", p.getNationality());
		p.setEthnicity("test2");
		assertEquals("test2", p.getEthnicity());
		p.setBirth(5);
		assertEquals(5, p.getBirth());
		p.setGender(1);
		assertEquals(1, p.getGender());
	}

}
