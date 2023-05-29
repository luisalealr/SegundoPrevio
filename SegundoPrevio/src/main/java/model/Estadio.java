package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the estadio database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Estadio.findAll", query="SELECT e FROM Estadio e")
public class Estadio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer capacidad;

	private String nombre;

	@OneToMany(mappedBy="estadio")
	private List<Partido> partidos;

}