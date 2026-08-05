package py.edu.lista_tareas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.sevicios.TareaServicio;

@RestController
@RequestMapping("/api/tareas")
public class TareaRestControlador {

  @Autowired
  private TareaServicio servicio;

  @GetMapping("/")
  public List<Tarea> mostrar() {
    return servicio.recuperarTodas();
  }

  @PostMapping("/")
  public Tarea save(@RequestBody Tarea tareaAGuardar) {
    return servicio.guardarTarea(tareaAGuardar);
  }

  @PutMapping("/")
  public Boolean completar(@RequestBody Long id) {
    return servicio.completarTarea(id);
  }

  @DeleteMapping("/")
  public void eliminar(@RequestBody Long id) {
    servicio.borrar(id);
  }
}
