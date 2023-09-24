package gm.estudiantes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="estudiantes") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEstudiante;

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
}
