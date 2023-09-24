package gm.estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import gm.estudiantes.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante,Integer> {
}
