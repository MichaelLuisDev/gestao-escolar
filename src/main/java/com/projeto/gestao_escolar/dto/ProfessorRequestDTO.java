package com.projeto.gestao_escolar.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record ProfessorRequestDTO(
        @Schema(description = "nome do professor")
        String nome_do_professor,
        @Schema(description = "cpf do professor")
        String cpf,
        @Schema(description = "data de nascimento do professor")
        LocalDate data_de_nascimento,
        @Schema(description = "rg do professor")
        String rg,
        @Schema(description = "rua do professor")
        String rua,
        @Schema(description = "bairro do professor")
        String bairro,
        @Schema(description = "cep do professor")
        String cep,
        @Schema(description = "uf do professor")
        String uf,
        @Schema(description = "email do professor")
        String email,
        @Schema(description = "estado do professor")
        String estado,
        @Schema(description = "cidade do professor")
        String cidade,
        @Schema(description = "assinatura do professor")
        String assinatura_do_professor,
        @Schema(description = "celular do professor")
        String celular,
        @Schema(description = "logadoura do professor")
        String logadouro
) {
}
