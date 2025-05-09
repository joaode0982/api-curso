package br.com.meuprojeto.api_cursos.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso (
    @NotNull
    String name,

    @NotNull
    String category
    
){} 
