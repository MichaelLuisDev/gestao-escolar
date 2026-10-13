package com.projeto.gestao_escolar.controller;

import com.projeto.gestao_escolar.dto.ProfessorRequestDTO;
import com.projeto.gestao_escolar.dto.ProfessorResponseDTO;
import com.projeto.gestao_escolar.mapper.ProfessorMapper;
import com.projeto.gestao_escolar.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProfessorController {

    @Autowired
    private final ProfessorService professorService;
    private final ProfessorMapper mapper;

    public ProfessorController(ProfessorService professorService, ProfessorMapper mapper) {
        this.professorService = professorService;
        this.mapper = mapper;
    }

    @PostMapping("/professor")
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@RequestBody @Valid ProfessorRequestDTO professor) {
        ProfessorResponseDTO novoProfessor = mapper.toResponseDTO(professorService.cadastraProfessor(mapper.toEntity(professor)));
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @GetMapping("/professor")
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessors() {
        List<ProfessorResponseDTO> professors = mapper.toResponseDTOList(professorService.buscaTodosOsProfessores());
        if (professors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable("id") Long id) {
        ProfessorResponseDTO professor = mapper.toResponseDTO(professorService.buscaProfessorPorId(id));
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/professor/{id}")
    public ResponseEntity<ProfessorResponseDTO> updateProfessor(@PathVariable("id") long id, @RequestBody ProfessorRequestDTO professor) {
        ProfessorResponseDTO professorAtualizado = mapper.toResponseDTO(professorService.atualizaCadastroProfessor(id,mapper.toEntity(professor)));
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/professor/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id") long id) {
        professorService.removeProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
