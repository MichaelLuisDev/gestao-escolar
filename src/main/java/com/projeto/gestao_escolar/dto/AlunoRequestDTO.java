package com.projeto.gestao_escolar.dto;

import java.time.LocalDate;

public record AlunoRequestDTO(
        String nome_do_aluno,
        String cpf,
        LocalDate data_de_nascimento,
        String rg,
        String rua,
        String bairro,
        String cep,
        String uf,
        String email,
        String estado,
        String cidade,
        String nome_da_mae,
        String nome_do_pai,
        String assinatura_do_aluno,
        String celular,
        String logadouro
) {
}
