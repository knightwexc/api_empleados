package shiba.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class EmpleadoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long Id;
	private String Nombre;
	private String Apellidos;
	private String Puesto;
	private String Sucursal;
	private String Domicilio;
	private Integer Sueldo;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}

	public String getSucursal() {
		return Sucursal;
	}

	public void setSucursal(String sucursal) {
		Sucursal = sucursal;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	public Integer getSueldo() {
		return Sueldo;
	}

	public void setSueldo(Integer sueldo) {
		Sueldo = sueldo;
	}
}
