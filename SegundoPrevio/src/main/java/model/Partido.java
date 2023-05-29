package model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * The persistent class for the partido database table.
 * 
 */
@Entity
@Data
@Table(name="partido")
public class Partido {
	
	@Id
	@SequenceGenerator(name="partido_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "partido_id_seq")
	private Integer id;

	private Timestamp fecha;

	@ManyToOne
	private Estadio estadio;

	@OneToMany(mappedBy="partido")
	private List<Resultado> resultados;


}