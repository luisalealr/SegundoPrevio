package com.negocio.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.practica.entities.Continente;
import com.negocio.practica.entities.Seleccion;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer>{

}
