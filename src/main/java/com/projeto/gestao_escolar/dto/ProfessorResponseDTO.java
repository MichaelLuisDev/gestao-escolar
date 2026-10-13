package com.projeto.gestao_escolar.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProfessorResponseDTO(
        @Schema(description = "nome do professor")
        String nome_do_professor,
        @Schema(description = "cpf do professor")
        String cpf,
        @Schema(description = "email do professor")
        String email,
        @Schema(description = "assinatura do professor")
        String assinatura_do_professor
) {
}
