package com.test.junit.repositories;

import com.test.junit.entities.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancoRepository extends JpaRepository<Banco, Long> {
//    List<Banco> findAll();

//    Banco findOneById(Long id);

//    void update(Banco banco);
}
