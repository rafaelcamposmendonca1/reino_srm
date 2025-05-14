package com.srm.projeto.repository;

import com.srm.projeto.entity.Reino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReinoRepository extends JpaRepository<Reino, Long>{
    Optional<Reino> findByNome(String nome);
}
