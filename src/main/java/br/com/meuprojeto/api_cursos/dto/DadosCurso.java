package br.com.meuprojeto.api_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DadosCurso {

    @NotBlank(message = "O nome do curso é obrigatório")
    private String name;

    @NotBlank(message = "A categoria do curso é obrigatória")
    private String category;

    public DadosCurso(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Boolean getActive() {   
        throw new UnsupportedOperationException("Unimplemented method 'getActive'");
    }
}
