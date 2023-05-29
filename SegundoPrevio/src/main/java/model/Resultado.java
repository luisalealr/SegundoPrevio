package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Data;


/**
 * The persistent class for the resultado database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Resultado.findAll", query="SELECT r FROM Resultado r")
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer amarillas;

	private Integer goles;

	private Integer rojas;

	@ManyToOne
	private Partido partido;

	@ManyToOne
	private Seleccion seleccion;

}