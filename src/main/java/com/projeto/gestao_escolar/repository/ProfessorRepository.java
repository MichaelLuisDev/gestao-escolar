package com.projeto.gestao_escolar.repository;

import com.projeto.gestao_escolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT c FROM Professor c WHERE LOWER(c.nomeProfessor) LIKE LOWER(CONCAT('%', :nomeProfessor, '%'))")
    List<Professor> buscarPorNomeProfessor(@Param("nome_Professor") String nome);

    boolean existsByEmailProfessor(String emailProfessor);
}
