package br.usj.ads.lpii.drcobertores.drcobertores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;



import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CobertorController {
    
    @Autowired
    CobertorRepository cobertorRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        List<Cobertor> lista = cobertorRepository.findAll();

        ModelAndView modelAndView = new ModelAndView ("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    @GetMapping(value="/mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Cobertor pessoa = cobertorRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("bebida", pessoa);
        return modelAndView;
    }
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        Cobertor pessoa = new Cobertor();


        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", pessoa);
        return modelAndView;
    }

    @PostMapping(value="/cadastrar")
    public String postMethodName(Cobertor pessoa) {
        cobertorRepository.save(pessoa);
       
        return "redirect:/";
    }

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        cobertorRepository.deleteById(id);

        return "redirect:/";
    }
    @GetMapping(value="/editar/{id}")
    public ModelAndView getMethodName(@PathVariable Long id) {
        Cobertor bebida = cobertorRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", bebida);
        return modelAndView;
    }
}