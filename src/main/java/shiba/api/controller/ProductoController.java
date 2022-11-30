package shiba.api.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiba.api.models.ProductoModel;
import shiba.api.services.ProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
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
    public Optional<ProductoModel> obtenerPorId(@PathVariable("id") Long id){
        return this.productoService.obtenerPorId(id);
    }

    // @GetMapping("/query")
    // public ArrayList<ProductoModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    //     return this.productoService.obtenerPorPrioridad(prioridad);
    // }

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
