package com.example.alm02.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.example.alm02.Model.Person;
import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
	MainController mc = new MainController();

	@Test
	void testError() {
		assertTrue(mc.error().getViewName().contentEquals("error"));
	}

	@Test
	void testHome() {
		assertTrue(mc.home().getViewName().contentEquals("home"));
	}

	@Test
	void testFindFortune() {
		ModelAndView mav = mc.findFortune(new Person("","test","test",1,1), null);
		assertTrue(mav.getViewName().contentEquals("home"));
		mav = mc.findFortune(new Person("test","","test",1,1), null);
		assertTrue(mav.getViewName().contentEquals("home"));
		mav = mc.findFortune(new Person("test","test","",1,1), null);
		assertTrue(mav.getViewName().contentEquals("home"));
		mav = mc.findFortune(new Person("test","test","test",1,1), null);
		assertTrue(mav.getViewName().contentEquals("fortune"));
	}

}
