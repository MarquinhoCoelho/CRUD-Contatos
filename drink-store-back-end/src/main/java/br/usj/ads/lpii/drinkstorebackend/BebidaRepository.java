package br.usj.ads.lpii.drinkstorebackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BebidaRepository extends CrudRepository<Bebida, Long> {
    
    List<Bebida> findAll();

}