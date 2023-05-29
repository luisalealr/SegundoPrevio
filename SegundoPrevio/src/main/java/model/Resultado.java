package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * The persistent class for the resultado database table.
 * 
 */
@Entity
@Data
@Table(name="resultado")
public class Resultado{

	@Id
	@SequenceGenerator(name="resultado_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "resultado_id_seq")
	private Integer id;

	private Integer amarillas;

	private Integer goles;

	private Integer rojas;

	@ManyToOne
	private Partido partido;

	@ManyToOne
	private Seleccion seleccion;

}