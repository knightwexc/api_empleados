package shiba.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shiba.api.models.ProductoModel;
import shiba.api.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }
    public Optional<ProductoModel> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }
    //     public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad){
    //     return productoRepository.findByPrioridad(prioridad);
    // }
    public boolean eliminarProducto(Long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
