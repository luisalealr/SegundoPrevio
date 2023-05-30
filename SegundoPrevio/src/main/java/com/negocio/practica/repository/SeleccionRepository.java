package com.negocio.practica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.practica.entities.Continente;
import com.negocio.practica.entities.Seleccion;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
	
	List<Seleccion> findByGrupo(String grupo);
}
