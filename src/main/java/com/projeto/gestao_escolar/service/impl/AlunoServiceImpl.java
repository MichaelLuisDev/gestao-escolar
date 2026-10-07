package com.projeto.gestao_escolar.service.impl;

import com.projeto.gestao_escolar.exception.RecursoNaoEncontradoException;
import com.projeto.gestao_escolar.model.Aluno;
import com.projeto.gestao_escolar.repository.AlunoRepository;
import com.projeto.gestao_escolar.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno cadastraAluno(Aluno alunoNovo) {
        alunoNovo.validar();
        return alunoRepository.save(alunoNovo);
    }

    @Override
    public List<Aluno> buscaTodosOsAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscaAlunoPorId(Long id) {
        if(id == null){
            throw new RecursoNaoEncontradoException("O ID é inválido");
        }
        if(!alunoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("O aluno não foi encontrado");
        }
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno atualizaCadastroAluno(Long id, Aluno aluno) {
        Aluno alunoLocalizado =
                alunoRepository.findById(id).orElseThrow(()->
                        new RecursoNaoEncontradoException("Aluno não localizado na base de dados"));
        alunoLocalizado.atualizarDados(aluno);
        return alunoLocalizado;

    }

    @Override
    public void removeAluno(Long id) {
        if(id == null){
            throw new IllegalArgumentException("A entrada não pode ser null");
        }
        if(!alunoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
