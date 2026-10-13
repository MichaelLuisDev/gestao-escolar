package com.projeto.gestao_escolar.service.impl;

import com.projeto.gestao_escolar.exception.RecursoNaoEncontradoException;
import com.projeto.gestao_escolar.model.Professor;
import com.projeto.gestao_escolar.repository.ProfessorRepository;
import com.projeto.gestao_escolar.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor cadastraProfessor(Professor professorNovo) {
        professorNovo.validar();
        return professorRepository.save(professorNovo);
    }

    @Override
    public List<Professor> buscaTodosOsProfessores() {
        return professorRepository.findAll();
    }

    @Override
    public Professor buscaProfessorPorId(Long id) {
        if(id == null){
            throw new RecursoNaoEncontradoException("O ID é inválido");
        }
        if(!professorRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("O professor não foi encontrado");
        }
        return professorRepository.findById(id).get();
    }

    @Override
    public Professor atualizaCadastroProfessor(Long id, Professor professor) {
        Professor professorLocalizado =
                professorRepository.findById(id).orElseThrow(()->
                        new RecursoNaoEncontradoException("Professor não localizado na base de dados"));
        professorLocalizado.atualizarDados(professor);
        professorLocalizado.validar();
        professorRepository.save(professorLocalizado);
        return professorLocalizado;

    }

    @Override
    public void removeProfessor(Long id) {
        if(id == null){
            throw new IllegalArgumentException("A entrada não pode ser null");
        }
        if(!professorRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }
}
