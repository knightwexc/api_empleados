package shiba.api.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import shiba.api.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long>{
    List<ProductoModel> findByEmpleadoEquals(Long empleado);
    
    @Query(value = "SELECT AVG(cantidad) FROM productos", nativeQuery = true)
    public int avg();

    @Query(value = "SELECT SUM(cantidad) FROM productos", nativeQuery = true)
    public int sum();

    @Query(value = "SELECT cantidad FROM productos WHERE cantidad = (SELECT MAX(cantidad ) FROM productos)", nativeQuery = true)
    public Long max();

    @Query(value = "SELECT cantidad FROM productos WHERE cantidad = (SELECT MIN(cantidad ) FROM productos)", nativeQuery = true)
    public Long min();

    @Query(value= "SELECT SUM(Cantidad) FROM productos WHERE empleado LIKE %:empleado%",nativeQuery = true)
    int sumEmpleado(@Param("empleado")Long empleado);

    @Query(value= "SELECT AVG(Cantidad) FROM productos WHERE empleado LIKE %:empleado%",nativeQuery = true)
    int avgEmpleado(@Param("empleado")Long empleado);


}
