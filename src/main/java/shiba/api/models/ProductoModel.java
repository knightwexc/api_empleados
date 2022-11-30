package shiba.api.models;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long Id;
    private Date Fecha;
    private Integer Cantidad;
    private Long Id_empleado;

    public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

    public Long getId_empleado() {
		return Id_empleado;
	}
	public void setId_empleado(Long id_empleado) {
		Id_empleado = id_empleado;
	}

    public Integer getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}
}
