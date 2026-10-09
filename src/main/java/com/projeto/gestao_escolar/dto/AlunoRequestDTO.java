package com.projeto.gestao_escolar.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record AlunoRequestDTO(
        @Schema(description = "nome do aluno")
        String nome_do_aluno,
        @Schema(description = "cpf do aluno")
        String cpf,
        @Schema(description = "data de nascimento do aluno")
        LocalDate data_de_nascimento,
        @Schema(description = "rg do aluno")
        String rg,
        @Schema(description = "rua do aluno")
        String rua,
        @Schema(description = "bairro do aluno")
        String bairro,
        @Schema(description = "cep do aluno")
        String cep,
        @Schema(description = "uf do aluno")
        String uf,
        @Schema(description = "email do aluno")
        String email,
        @Schema(description = "estado do aluno")
        String estado,
        @Schema(description = "cidade do aluno")
        String cidade,
        @Schema(description = "nome da mãe do aluno")
        String nome_da_mae,
        @Schema(description = "nome do pai do aluno")
        String nome_do_pai,
        @Schema(description = "assinatura do aluno")
        String assinatura_do_aluno,
        @Schema(description = "celular do aluno")
        String celular,
        @Schema(description = "logadoura do aluno")
        String logadouro
) {
}
