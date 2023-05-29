package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the continente database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Continente.findAll", query="SELECT c FROM Continente c")
public class Continente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	@OneToMany(mappedBy="continente")
	private List<Seleccion> seleccions;

}