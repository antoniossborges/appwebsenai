package br.org.sesisenai.controller;

import br.org.sesisenai.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {


}
