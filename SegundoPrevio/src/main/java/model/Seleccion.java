package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the seleccion database table.
 * 
 */
@Entity
@NamedQuery(name="Seleccion.findAll", query="SELECT s FROM Seleccion s")
public class Seleccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String grupo;

	private String nombre;
	
	@OneToMany(mappedBy="seleccion")
	private List<Resultado> resultados;

	@ManyToOne
	private Continente continente;

}