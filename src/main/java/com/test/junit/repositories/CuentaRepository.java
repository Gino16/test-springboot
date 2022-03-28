package com.test.junit.repositories;

import com.test.junit.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByPersona(String persona);
//    List<Cuenta> findAll();

//    Cuenta findOneById(Long id);

//    void update(Cuenta cuenta);
}
