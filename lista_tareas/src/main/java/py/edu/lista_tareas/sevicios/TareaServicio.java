package py.edu.lista_tareas.sevicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.repositorios.ITareaRepositorio;

@Service
public class TareaServicio {

  @Autowired
  private ITareaRepositorio repo;

  public Tarea guardarTarea(Tarea tarea) {
    return repo.save(tarea);
  }

  public List<Tarea> recuperarTodas() {
    return repo.findAll();
  }

  public Boolean completarTarea(Long id) {
    Tarea tareaACompletar = repo.findById(id).get();
    if (tareaACompletar == null) {
      return false;
    } else {
      tareaACompletar.setCompletada(true);
      repo.save(tareaACompletar);
      return true;
    }
  }

}
