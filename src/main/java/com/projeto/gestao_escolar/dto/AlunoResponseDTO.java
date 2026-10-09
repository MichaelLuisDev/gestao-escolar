package com.projeto.gestao_escolar.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoResponseDTO(
        @Schema(description = "nome do aluno")
        String nome_do_aluno,
        @Schema(description = "cpf do aluno")
        String cpf,
        @Schema(description = "email do aluno")
        String email,
        @Schema(description = "assinatura do aluno")
        String assinatura_do_aluno
) {
}
