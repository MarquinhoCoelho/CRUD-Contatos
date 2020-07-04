package br.edu.usj.ads.lpii.drinkstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;



import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class BebidaController {

    @Autowired
    BebidaRepository bebidaRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        List<Bebida> lista = bebidaRepository.findAll();

        ModelAndView modelAndView = new ModelAndView ("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Bebida bebida = bebidaRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("bebida", bebida);
        return modelAndView;
    }
    
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        Bebida bebida = new Bebida();


        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", bebida);
        return modelAndView;
    }
    
    @PostMapping(value="/cadastrar")
    public String postMethodName(Bebida bebida) {
        bebidaRepository.save(bebida);
       
        return "redirect:/";
    }
    
    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        bebidaRepository.deleteById(id);

        return "redirect:/";
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getMethodName(@PathVariable Long id) {
        Bebida bebida = bebidaRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", bebida);
        return modelAndView;
    }
}