package py.edu.lista_tareas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.sevicios.TareaServicio;

@Controller
public class TareaControlador {

  @Autowired
  private TareaServicio servicio;

  @GetMapping("/")
  public String mostrarFromulario(Model m) {
    List<Tarea> tareas = servicio.recuperarTodas();
    m.addAttribute("tarea", new Tarea());
    m.addAttribute("tareas", tareas);
    return "index";
  }

  @PostMapping("/guardar")
  public String guardar(@ModelAttribute Tarea tarea) {
    servicio.guardarTarea(tarea);

    return "redirect:/";
  }

  @PostMapping("/completar/{id}")
  public String completar(@PathVariable Long id) {
    servicio.completarTarea(id);

    return "redirect:/";
  }

  @PostMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id) {

    servicio.borrar(id);

    return "redirect:/";
  }

}
