package com.negocio.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.practica.entities.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer>{

}
