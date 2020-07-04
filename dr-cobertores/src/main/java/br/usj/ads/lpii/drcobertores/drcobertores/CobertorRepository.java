package br.usj.ads.lpii.drcobertores.drcobertores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CobertorRepository extends CrudRepository <Cobertor, Long> {
    
    
        List<Cobertor> findAll();
}