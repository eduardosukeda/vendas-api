package com.jepescados.vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jepescados.vendasapi.model.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

	boolean existsByNome(String nome);
}
