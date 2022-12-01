package shiba.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiba.api.models.EmpleadoModel;
import shiba.api.services.EmpleadoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.POST })
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados() {
        return empleadoService.obtenerEmpleados();
    }

    @PostMapping()
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel empleado) {
        return this.empleadoService.guardarEmpleado(empleado);
    }

    @PutMapping(path = "/{id}")
    public String editarEmpleado(@PathVariable("id") Long id, @RequestBody EmpleadoModel empleado) {
        boolean ok = this.empleadoService.editarEmpleado(id, empleado);
        if (ok) {
            return "Empleado editado exitosamente " + id;
        } else {
            return "Error, no se ha editado empleado id: " + id;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.empleadoService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, String> eliminarPorId(@PathVariable("id") Long id) {
        HashMap<String, String> map = new HashMap<>();
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        if (ok) {
            map.put("message", "Empleado:" + id + " eliminado exitosamente");
            return map;
        } else {
            map.put("message", "Error al eliminar");
            return map;

        }
    }

}
