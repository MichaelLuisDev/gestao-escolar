package com.projeto.gestao_escolar.model;

import com.projeto.gestao_escolar.exception.RegraDeNegocioException;
import jakarta.persistence.*;

import java.time.LocalDate;

import static com.projeto.gestao_escolar.utils.ValidacaoUtils.validarTextoObrigatorio;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_do_professor", nullable = false)
    private String nomeProfessor;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpfProfessor;

    @Column(name = "data_de_nascimento",nullable = false)
    private LocalDate dataDeNascimentoProfessor;

    @Column(name = "rg")
    private String rgProfessor;

    @Column(name = "rua", nullable = false)
    private String ruaProfessor;

    @Column(name = "bairro",nullable = false)
    private String bairroProfessor;

    @Column(name = "logadouro")
    private String logadouroProfessor;

    @Column(name = "cep",nullable = false)
    private String cepProfessor;

    @Column(name = "estado",nullable = false)
    private String estadoProfessor;

    @Column(name = "cidade",nullable = false)
    private String cidadeProfessor;

    @Column(name = "uf", nullable = false)
    private String ufProfessor;

    @Column(name = "celular")
    private String celularProfessor;

    @Column(name = "email", nullable = false,unique = true)
    private String emailProfessor;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "assinatura_do_professor",nullable = false)
    private String assinaturaProfessor;

    public Professor() {
    }

    public Professor(Long id,
                     String nomeProfessor,
                     String cpfProfessor,
                     LocalDate dataDeNascimentoProfessor,
                     String rgProfessor,
                     String ruaProfessor,
                     String bairroProfessor,
                     String logadouroProfessor,
                     String cepProfessor,
                     String estadoProfessor,
                     String cidadeProfessor,
                     String ufProfessor,
                     String celularProfessor,
                     String emailProfessor,
                     String especialidade,
                     String assinaturaProfessor) {
        this.id = id;
        this.nomeProfessor = nomeProfessor;
        this.cpfProfessor = cpfProfessor;
        this.dataDeNascimentoProfessor = dataDeNascimentoProfessor;
        this.rgProfessor = rgProfessor;
        this.ruaProfessor = ruaProfessor;
        this.bairroProfessor = bairroProfessor;
        this.logadouroProfessor = logadouroProfessor;
        this.cepProfessor = cepProfessor;
        this.estadoProfessor = estadoProfessor;
        this.cidadeProfessor = cidadeProfessor;
        this.ufProfessor = ufProfessor;
        this.celularProfessor = celularProfessor;
        this.emailProfessor = emailProfessor;
        this.especialidade = especialidade;
        this.assinaturaProfessor = assinaturaProfessor;
    }

    //Métodos de validação
    public void validar(){
        validarNomeProfessor();
        validarCpfProfessor();
        validarDataDeNascimentoProfessor();
        validarBairroProfessor();
        validarRuaProfessor();
        validarCepProfessor();
        validarEstadoProfessor();
        validarCidadeProfessor();
        validarUfProfessor();
        validarEmailProfessor();
        validarAssinaturaProfessor();

    }

    private void validarNomeProfessor(){
        validarTextoObrigatorio(nomeProfessor,"nome do professor", 150);
    }
    private void validarCpfProfessor(){
        validarTextoObrigatorio(cpfProfessor,"cpf do professor",30);
    }
    private void validarDataDeNascimentoProfessor(){
        if(dataDeNascimentoProfessor == null){
            throw new RegraDeNegocioException("Precisa inserir uma data válida");
        }
    }
    private void validarBairroProfessor(){
        validarTextoObrigatorio(bairroProfessor,"bairro do professor",40);
    }
    private void validarRuaProfessor(){
        validarTextoObrigatorio(ruaProfessor,"rua do professor",20);
    }
    private void validarCepProfessor(){
        validarTextoObrigatorio(cepProfessor,"cep do professor",30);
    }
    private void validarEstadoProfessor(){
        validarTextoObrigatorio(estadoProfessor,"estado do professor",30);
    }
    private void validarCidadeProfessor(){
        validarTextoObrigatorio(cidadeProfessor,"cidade do professor",30);
    }
    private void validarUfProfessor(){
        validarTextoObrigatorio(ufProfessor,"uf do professor",5);
    }
    private void validarEmailProfessor(){
        validarTextoObrigatorio(emailProfessor,"email do professor",50);
        if (!emailProfessor.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new RegraDeNegocioException("Email inválido");
        }
    }
    private void validarAssinaturaProfessor(){
        validarTextoObrigatorio(assinaturaProfessor,"assinatura do professor",50);
    }

    public void atualizarDados(Professor novoProfessor) {
        this.nomeProfessor = novoProfessor.getNomeProfessor();
        this.cpfProfessor = novoProfessor.getCpfProfessor();
        this.dataDeNascimentoProfessor = novoProfessor.getDataDeNascimentoProfessor();
        this.rgProfessor = novoProfessor.getRgProfessor();
        this.ruaProfessor = novoProfessor.getRuaProfessor();
        this.bairroProfessor = novoProfessor.getBairroProfessor();
        this.logadouroProfessor = novoProfessor.getLogadouroProfessor();
        this.cepProfessor = novoProfessor.getCepProfessor();
        this.estadoProfessor = novoProfessor.getEstadoProfessor();
        this.cidadeProfessor = novoProfessor.getCidadeProfessor();
        this.ufProfessor = novoProfessor.getUfProfessor();
        this.celularProfessor = novoProfessor.getCelularProfessor();
        this.emailProfessor = novoProfessor.getEmailProfessor();
        this.assinaturaProfessor = novoProfessor.getAssinaturaProfessor();
        novoProfessor.validar();
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public LocalDate getDataDeNascimentoProfessor() {
        return dataDeNascimentoProfessor;
    }

    public void setDataDeNascimentoProfessor(LocalDate dataDeNascimentoProfessor) {
        this.dataDeNascimentoProfessor = dataDeNascimentoProfessor;
    }

    public String getRgProfessor() {
        return rgProfessor;
    }

    public void setRgProfessor(String rgProfessor) {
        this.rgProfessor = rgProfessor;
    }

    public String getRuaProfessor() {
        return ruaProfessor;
    }

    public void setRuaProfessor(String ruaProfessor) {
        this.ruaProfessor = ruaProfessor;
    }

    public String getBairroProfessor() {
        return bairroProfessor;
    }

    public void setBairroProfessor(String bairroProfessor) {
        this.bairroProfessor = bairroProfessor;
    }

    public String getLogadouroProfessor() {
        return logadouroProfessor;
    }

    public void setLogadouroProfessor(String logadouroProfessor) {
        this.logadouroProfessor = logadouroProfessor;
    }

    public String getCepProfessor() {
        return cepProfessor;
    }

    public void setCepProfessor(String cepProfessor) {
        this.cepProfessor = cepProfessor;
    }

    public String getEstadoProfessor() {
        return estadoProfessor;
    }

    public void setEstadoProfessor(String estadoProfessor) {
        this.estadoProfessor = estadoProfessor;
    }

    public String getCidadeProfessor() {
        return cidadeProfessor;
    }

    public void setCidadeProfessor(String cidadeProfessor) {
        this.cidadeProfessor = cidadeProfessor;
    }

    public String getUfProfessor() {
        return ufProfessor;
    }

    public void setUfProfessor(String ufProfessor) {
        this.ufProfessor = ufProfessor;
    }

    public String getCelularProfessor() {
        return celularProfessor;
    }

    public void setCelularProfessor(String celularProfessor) {
        this.celularProfessor = celularProfessor;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getAssinaturaProfessor() {
        return assinaturaProfessor;
    }

    public void setAssinaturaProfessor(String assinaturaProfessor) {
        this.assinaturaProfessor = assinaturaProfessor;
    }
}
