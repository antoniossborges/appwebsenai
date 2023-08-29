package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BancoRepository extends CrudRepository<ContaCorrentePF, Long> {
    //Optional<ContaCorrentePF> findById(Long id);
}
