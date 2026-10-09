package com.projeto.gestao_escolar.controller;

import com.projeto.gestao_escolar.dto.AlunoRequestDTO;
import com.projeto.gestao_escolar.dto.AlunoResponseDTO;
import com.projeto.gestao_escolar.mapper.AlunoMapper;
import com.projeto.gestao_escolar.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;
    private final AlunoMapper mapper;

    public AlunoController(AlunoService alunoService, AlunoMapper mapper) {
        this.alunoService = alunoService;
        this.mapper = mapper;
    }

    @PostMapping("/aluno")
    public ResponseEntity<AlunoResponseDTO> createAluno(@RequestBody @Valid AlunoRequestDTO aluno) {
        AlunoResponseDTO novoAluno = mapper.toResponseDTO(alunoService.cadastraAluno(mapper.toEntity(aluno)));
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping("/aluno")
    public ResponseEntity<List<AlunoResponseDTO>> getAllAlunos() {
        List<AlunoResponseDTO> alunos = mapper.toResponseDTOList(alunoService.buscaTodosOsAlunos());
        if (alunos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> getAlunoById(@PathVariable("id") Long id) {
        AlunoResponseDTO aluno = mapper.toResponseDTO(alunoService.buscaAlunoPorId(id));
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> updateAluno(@PathVariable("id") long id, @RequestBody AlunoRequestDTO aluno) {
        AlunoResponseDTO alunoAtualizado = mapper.toResponseDTO(alunoService.atualizaCadastroAluno(id,mapper.toEntity(aluno)));
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable("id") long id) {
        alunoService.removeAluno(id);
        return ResponseEntity.noContent().build();
    }

}
