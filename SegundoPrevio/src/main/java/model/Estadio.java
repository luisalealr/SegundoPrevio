package model;


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
 * The persistent class for the estadio database table.
 * 
 */
@Entity
@Data
@Table(name="estadio")
public class Estadio {

	@Id
	@SequenceGenerator(name="estadio_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estadio_id_seq")
	private Integer id;

	private Integer capacidad;

	private String nombre;

	@OneToMany(mappedBy="estadio")
	private List<Partido> partidos;

}