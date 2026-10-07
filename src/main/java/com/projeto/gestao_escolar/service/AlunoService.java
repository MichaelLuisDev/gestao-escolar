package com.projeto.gestao_escolar.service;

import com.projeto.gestao_escolar.model.Aluno;

import java.util.List;

public interface AlunoService {
    public Aluno cadastraAluno(Aluno alunoNovo);
    public List<Aluno> buscaTodosOsAlunos();
    public Aluno buscaAlunoPorId(Long id);
    public Aluno atualizaCadastroAluno(Long id, Aluno aluno);
    public void removeAluno(Long id);
}
