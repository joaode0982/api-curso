package br.com.meuprojeto.api_cursos.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.meuprojeto.api_cursos.dto.DadosAtualizacaoCurso;
import br.com.meuprojeto.api_cursos.dto.DadosCurso;
import br.com.meuprojeto.api_cursos.model.Curso;
import br.com.meuprojeto.api_cursos.repository.CursoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Curso criarCurso(@RequestBody @Valid DadosCurso dadosCurso) {
        Curso curso = new Curso(dadosCurso);  
        return cursoRepository.save(curso);   
    }

    @GetMapping
    public List<Curso> listarCursos () {
        return cursoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoCurso dados) {
        Curso curso = cursoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        curso.setName(dados.name());
        curso.setCategory(dados.category());

        Curso cursoAtualizado = cursoRepository.save(curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirCurso(@PathVariable UUID id) {
        var curso = cursoRepository.findById(id).orElseThrow();
        curso.setActive(false);
        cursoRepository.save(curso);
    }

    @GetMapping("/ativos")
    public List<Curso> listarCursosAtivos () {
        return  cursoRepository.findByActiveTrue();
    }
}


