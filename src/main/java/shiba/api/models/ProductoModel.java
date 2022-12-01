package shiba.api.models;
import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String fecha;
	private String hora;
    private Integer cantidad;
    private Long empleado;

	public Long getId() {
		return id;
	}

    public String getFecha() {
		return fecha;
	}
	public void setFecha(String Fecha) {
		fecha = Fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String Hora) {
		hora = Hora;
	}

    public Long getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Long Empleado) {
		empleado = Empleado;
	}

    public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer Cantidad) {
		cantidad = Cantidad;
	}
}
