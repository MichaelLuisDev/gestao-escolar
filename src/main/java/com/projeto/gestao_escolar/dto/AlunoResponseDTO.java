package com.projeto.gestao_escolar.dto;

public record AlunoResponseDTO(
        String nome_do_aluno,
        String cpf,
        String email,
        String assinatura_do_aluno
) {
}
