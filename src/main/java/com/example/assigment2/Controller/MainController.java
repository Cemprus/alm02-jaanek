package com.example.assigment2.Controller;

import com.example.assigment2.Model.Person;
import com.example.assigment2.Model.Translator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value={"/error"}, method = RequestMethod.GET)
    public ModelAndView error(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Person person = new Person();
        modelAndView.addObject("person", person);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView findFortune(Person person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (person.getName().length() == 0||person.getNationality().length() == 0||person.getEthnicity().length() == 0){
            modelAndView.addObject("mes", "All fields must be filled!");
            modelAndView.setViewName("home");
        }else {
            Translator translator = new Translator(person);
            modelAndView.addObject("mes1", translator.getFirstPart());
            modelAndView.addObject("mes2", translator.getSecondPart());
            modelAndView.addObject("mes3", translator.getThirdPart());
            modelAndView.setViewName("fortune");
        }
        return modelAndView;
    }
}
