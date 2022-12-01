package shiba.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shiba.api.models.ProductoModel;
import shiba.api.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public List<ProductoModel> findByEmpleadoEquals(Long id) {
        return productoRepository.findByEmpleadoEquals(id);
    }

    public int avg() {
        return productoRepository.avg();
    }

    public int sum() {
        return productoRepository.sum();
    }

    public Long max() {
        return productoRepository.max();
    }

    public Long min() {
        return productoRepository.min();
    }

    public int sumEmpleado(Long id) {
        try {
            productoRepository.sumEmpleado(id);
            return productoRepository.sumEmpleado(id);
        } catch (Exception err) {
            return 0;
        }
    }

    public int avgEmpleado(Long id) {
        try {
            productoRepository.avgEmpleado(id);
            return productoRepository.avgEmpleado(id);
        } catch (Exception err) {
            return 0;
        }
    }

    // public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad){
    // return productoRepository.findByPrioridad(prioridad);
    // }
    public boolean eliminarProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
