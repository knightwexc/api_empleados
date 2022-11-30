package shiba.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import shiba.api.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{
    
}
