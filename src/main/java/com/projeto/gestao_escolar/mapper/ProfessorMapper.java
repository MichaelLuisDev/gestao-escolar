package com.projeto.gestao_escolar.mapper;

import com.projeto.gestao_escolar.dto.ProfessorRequestDTO;
import com.projeto.gestao_escolar.dto.ProfessorResponseDTO;
import com.projeto.gestao_escolar.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfessorMapper {

    //Entity -> ResponseDTO
    @Mapping(source = "nomeProfessor", target = "nome_do_professor")
    @Mapping(source = "cpfProfessor", target = "cpf")
    @Mapping(source = "emailProfessor", target = "email")
    @Mapping(source = "assinaturaProfessor", target = "assinatura_do_professor")
    ProfessorResponseDTO toResponseDTO(Professor professor);


    List<ProfessorResponseDTO> toResponseDTOList(List<Professor> professors);



    //RequestDTO -> Entity (Criação)

    @Mapping(target = "id", ignore = true) // O ID é gerado pelo banco
    @Mapping(source = "nome_do_professor", target = "nomeProfessor")
    @Mapping(source = "cpf", target = "cpfProfessor")
    @Mapping(source = "data_de_nascimento", target = "dataDeNascimentoProfessor")
    @Mapping(source = "rg", target = "rgProfessor")
    @Mapping(source = "rua", target = "ruaProfessor")
    @Mapping(source = "bairro", target = "bairroProfessor")
    @Mapping(source = "cep", target = "cepProfessor")
    @Mapping(source = "uf", target = "ufProfessor")
    @Mapping(source = "email", target = "emailProfessor")
    @Mapping(source = "estado", target = "estadoProfessor")
    @Mapping(source = "cidade", target = "cidadeProfessor")
    @Mapping(source = "assinatura_do_professor", target = "assinaturaProfessor")
    @Mapping(source = "celular", target = "celularProfessor")
    @Mapping(source = "logadouro", target = "logadouroProfessor")
    Professor toEntity(ProfessorRequestDTO requestDTO);


    List<Professor> toEntityList(List<ProfessorRequestDTO> requestDTOs);



    //ATUALIZAÇÃO: RequestDTO -> Entity Existente
    @Mapping(target = "id", ignore = true) // Nunca sobrescreve o ID na atualização
    @Mapping(source = "nome_do_professor", target = "nomeProfessor")
    @Mapping(source = "cpf", target = "cpfProfessor")
    @Mapping(source = "data_de_nascimento", target = "dataDeNascimentoProfessor")
    @Mapping(source = "rg", target = "rgProfessor")
    @Mapping(source = "rua", target = "ruaProfessor")
    @Mapping(source = "bairro", target = "bairroProfessor")
    @Mapping(source = "cep", target = "cepProfessor")
    @Mapping(source = "uf", target = "ufProfessor")
    @Mapping(source = "email", target = "emailProfessor")
    @Mapping(source = "estado", target = "estadoProfessor")
    @Mapping(source = "cidade", target = "cidadeProfessor")
    @Mapping(source = "assinatura_do_professor", target = "assinaturaProfessor")
    @Mapping(source = "celular", target = "celularProfessor")
    @Mapping(source = "logadouro", target = "logadouroProfessor")
    void updateEntityFromDto(ProfessorRequestDTO requestDTO, @MappingTarget Professor professor);
}
