package br.com.meuprojeto.api_cursos.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.meuprojeto.api_cursos.dto.DadosCurso;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Curso {

    

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO) 
    private UUID id;

    private String name;
    private String category; 

    private Boolean active = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Construtor que recebe um DadosCurso
    public Curso(DadosCurso dadosCurso) {
        this.name = dadosCurso.getName();
        this.category = dadosCurso.getCategory();
        this.active = dadosCurso.getActive();
    }

    // Construtor padrão
    public Curso() {
    }
    
}
