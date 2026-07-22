package py.edu.lista_tareas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.lista_tareas.modelos.Tarea;

public interface ITareaRepositorio extends JpaRepository<Tarea, Long> {

}
