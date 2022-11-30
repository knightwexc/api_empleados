package shiba.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shiba.api.repositories.EmpleadoRepository;
import shiba.api.models.EmpleadoModel;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }

    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }

    public boolean editarEmpleado(Long id, EmpleadoModel empleado){
        empleado.setId(id);
        try{
            empleadoRepository.save(empleado);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Optional<EmpleadoModel> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }
    //     public ArrayList<EmpleadoModel> obtenerPorPrioridad(Integer prioridad){
    //     return empleadoRepository.findByPrioridad(prioridad);
    // }
    public boolean eliminarEmpleado(Long id){
        try{
            empleadoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
