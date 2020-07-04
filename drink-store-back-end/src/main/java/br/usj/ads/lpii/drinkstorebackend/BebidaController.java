package br.usj.ads.lpii.drinkstorebackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;








@Controller
@ResponseBody
@CrossOrigin
public class BebidaController {
    
    @Autowired
    BebidaRepository bebidaRepository;

    @GetMapping(value="/")
    public List<Bebida> getTodos(){

        List<Bebida> lista = bebidaRepository.findAll();
        
        return lista;
    }
    
    @GetMapping(value="/{id}")
    public Bebida getItem(@PathVariable Long id) {
        Bebida bebida = bebidaRepository.findById(id).get();
        return bebida;
    }
    @PostMapping(value="/cadastrar")
    public Bebida postCadastrar(Bebida bebida) {
        Bebida bebidaSalva = bebidaRepository.save(bebida);
        return bebidaSalva;
    }
    
    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        bebidaRepository.deleteById(id);
    }
    

}