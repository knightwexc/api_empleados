package shiba.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiba.api.models.ProductoModel;
import shiba.api.repositories.ProductoRepository;
import shiba.api.services.ProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/productos")
public class ProductoController {
     @Autowired
    ProductoService productoService;
    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto){
        return this.productoService.guardarProducto(producto);
    }

    @GetMapping(path = "/{id}")
    public List<ProductoModel> findByEmpleadoEquals(@PathVariable("id") Long id){
        List<ProductoModel> findByEmpleadoEquals = this.productoService.findByEmpleadoEquals(id);
        System.out.println("findByAppleNameEquals = " + findByEmpleadoEquals);
        return findByEmpleadoEquals;
    }

    @GetMapping(path = "/avg")
    public int avg(){
        return this.productoService.avg();
    }

    @GetMapping(path = "/sum")
    public int sum(){
        return this.productoService.sum();
    }

    @GetMapping(path = "/min")
    public Long min(){
        return this.productoService.min();
    }

    @GetMapping(path = "/max")
    public Long max(){
        return this.productoService.max();
    }

    @GetMapping(path = "/sum={id}")
    public int sumEmpleado(@PathVariable("id") Long id){
        return this.productoService.sumEmpleado(id);
    }

    @GetMapping(path = "/avg={id}")
    public int avgEmpleado(@PathVariable("id") Long id){
        return this.productoService.avgEmpleado(id);
    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok= this.productoService.eliminarProducto(id);
        if (ok){
            return "Eliminado exitosamente " + id;
        } else{
            return "Error, no se ha eliminado: " + id;
        }
    }
}
