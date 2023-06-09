package com.negocio.practica.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * The persistent class for the seleccion database table.
 * 
 */
@Entity
@Data
@Table(name="seleccion")
public class Seleccion{

	@Id
	@SequenceGenerator(name="seleccion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seleccion_id_seq")
	private Integer id;

	private String grupo;

	private String nombre;
	
	@OneToMany(mappedBy="seleccion" , fetch = FetchType.EAGER)
	private List<Resultado> resultados;

	@ManyToOne
	private Continente continente;

}