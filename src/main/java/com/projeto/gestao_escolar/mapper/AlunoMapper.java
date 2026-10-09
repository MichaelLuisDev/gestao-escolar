package com.projeto.gestao_escolar.mapper;


import com.projeto.gestao_escolar.dto.AlunoRequestDTO;
import com.projeto.gestao_escolar.dto.AlunoResponseDTO;
import com.projeto.gestao_escolar.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


import java.util.List;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AlunoMapper {



    //Entity -> ResponseDTO
    @Mapping(source = "nomeAluno", target = "nome_do_aluno")
    @Mapping(source = "cpfAluno", target = "cpf")
    @Mapping(source = "emailAluno", target = "email")
    @Mapping(source = "assinaturaAluno", target = "assinatura_do_aluno")
    AlunoResponseDTO toResponseDTO(Aluno aluno);


    List<AlunoResponseDTO> toResponseDTOList(List<Aluno> alunos);



    //RequestDTO -> Entity (Criação)

    @Mapping(target = "id", ignore = true) // O ID é gerado pelo banco
    @Mapping(source = "nome_do_aluno", target = "nomeAluno")
    @Mapping(source = "cpf", target = "cpfAluno")
    @Mapping(source = "data_de_nascimento", target = "dataDeNascimentoAluno")
    @Mapping(source = "rg", target = "rgAluno")
    @Mapping(source = "rua", target = "ruaAluno")
    @Mapping(source = "bairro", target = "bairroAluno")
    @Mapping(source = "cep", target = "cepAluno")
    @Mapping(source = "uf", target = "ufAluno")
    @Mapping(source = "email", target = "emailAluno")
    @Mapping(source = "estado", target = "estadoAluno")
    @Mapping(source = "cidade", target = "cidadeAluno")
    @Mapping(source = "nome_da_mae", target = "nomeMaeAluno")
    @Mapping(source = "nome_do_pai", target = "nomePaiAluno")
    @Mapping(source = "assinatura_do_aluno", target = "assinaturaAluno")
    @Mapping(source = "celular", target = "celularAluno")
    @Mapping(source = "logadouro", target = "logadouroAluno")
    Aluno toEntity(AlunoRequestDTO requestDTO);


    List<Aluno> toEntityList(List<AlunoRequestDTO> requestDTOs);



    //ATUALIZAÇÃO: RequestDTO -> Entity Existente
    @Mapping(target = "id", ignore = true) // Nunca sobrescreve o ID na atualização
    @Mapping(source = "nome_do_aluno", target = "nomeAluno")
    @Mapping(source = "cpf", target = "cpfAluno")
    @Mapping(source = "data_de_nascimento", target = "dataDeNascimentoAluno")
    @Mapping(source = "rg", target = "rgAluno")
    @Mapping(source = "rua", target = "ruaAluno")
    @Mapping(source = "bairro", target = "bairroAluno")
    @Mapping(source = "cep", target = "cepAluno")
    @Mapping(source = "uf", target = "ufAluno")
    @Mapping(source = "email", target = "emailAluno")
    @Mapping(source = "estado", target = "estadoAluno")
    @Mapping(source = "cidade", target = "cidadeAluno")
    @Mapping(source = "nome_da_mae", target = "nomeMaeAluno")
    @Mapping(source = "nome_do_pai", target = "nomePaiAluno")
    @Mapping(source = "assinatura_do_aluno", target = "assinaturaAluno")
    @Mapping(source = "celular", target = "celularAluno")
    @Mapping(source = "logadouro", target = "logadouroAluno")
    void updateEntityFromDto(AlunoRequestDTO requestDTO, @MappingTarget Aluno aluno);
}

