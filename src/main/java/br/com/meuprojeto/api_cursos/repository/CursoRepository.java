package br.com.meuprojeto.api_cursos.repository;

import java.util.List;  
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meuprojeto.api_cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
    List<Curso> findByActiveTrue();
}
