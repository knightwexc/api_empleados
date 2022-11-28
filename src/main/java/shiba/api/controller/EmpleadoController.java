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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiba.api.models.EmpleadoModel;
import shiba.api.services.EmpleadoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

    @PostMapping()
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerPorId(@PathVariable("id") Long id){
        return this.empleadoService.obtenerPorId(id);
    }

    // @GetMapping("/query")
    // public ArrayList<EmpleadoModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    //     return this.empleadoService.obtenerPorPrioridad(prioridad);
    // }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok= this.empleadoService.eliminarEmpleado(id);
        if (ok){
            return "Eliminado exitosamente " + id;
        } else{
            return "Error, no se ha eliminado: " + id;
        }
    }
}
