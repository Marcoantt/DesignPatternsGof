package com.gof.designpatterns.repository;

import com.gof.designpatterns.model.Prato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends CrudRepository<Prato, String> {
}
