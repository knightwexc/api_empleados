package shiba.api.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import shiba.api.models.EmpleadoModel;


@Repository
public interface  EmpleadoRepository extends CrudRepository<EmpleadoModel, Long>{
    // public abstract ArrayList<EmpleadoModel> findByPrioridad(Integer prioridad);
}
