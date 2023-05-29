package com.negocio.practica.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the continente database table.
 * 
 */
@Entity
@Data
@Table(name="continente")
public class Continente{

	@Id
	@SequenceGenerator(name="continente_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "continente_id_seq")
	private Integer id;

	private String nombre;

	@OneToMany(mappedBy="continente")
	private List<Seleccion> seleccions;

}