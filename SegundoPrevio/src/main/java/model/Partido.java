package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;


/**
 * The persistent class for the partido database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp fecha;

	@ManyToOne
	private Estadio estadio;

	@OneToMany(mappedBy="partido")
	private List<Resultado> resultados;


}