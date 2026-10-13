package com.projeto.gestao_escolar.service;

import com.projeto.gestao_escolar.model.Professor;

import java.util.List;

public interface ProfessorService {
    public Professor cadastraProfessor(Professor professorNovo);
    public List<Professor> buscaTodosOsProfessores();
    public Professor buscaProfessorPorId(Long id);
    public Professor atualizaCadastroProfessor(Long id, Professor professor);
    public void removeProfessor(Long id);
}
