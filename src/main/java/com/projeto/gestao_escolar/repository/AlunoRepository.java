package com.projeto.gestao_escolar.repository;

import com.projeto.gestao_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT c FROM Aluno c WHERE LOWER(c.nomeAluno) LIKE LOWER(CONCAT('%', :nomeAluno, '%'))")
    List<Aluno> buscarPorNomeAluno(@Param("nome_Aluno") String nome);

    boolean existsByEmailAluno(String emailAluno);
}
