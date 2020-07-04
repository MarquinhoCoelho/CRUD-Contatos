package br.edu.usj.ads.alpi.helloname;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloName {
    @PostMapping(value = "USJ")
    public ModelAndView postHelloName(@RequestParam String nome) {
        String mensagem = "Ola, " + nome + "!";

        ModelAndView modelAndView = new ModelAndView("hello-name");
        modelAndView.addObject("mensagem", mensagem);

        return modelAndView;
    }

}
