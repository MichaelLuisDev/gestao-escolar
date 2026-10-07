package com.projeto.gestao_escolar.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_do_aluno", nullable = false)
    private String nomeAluno;

    @Column(name = "cpf", nullable = false)
    private String cpfAluno;

    @Column(name = "data_de_nascimento",nullable = false)
    private LocalDate dataDeNascimentoAluno;

    @Column(name = "rg")
    private String rgAluno;

    @Column(name = "rua", nullable = false)
    private String ruaAluno;

    @Column(name = "bairro",nullable = false)
    private String bairroAluno;

    @Column(name = "logadouro")
    private String logadouroAluno;

    @Column(name = "cep",nullable = false)
    private String cepAluno;

    @Column(name = "estado",nullable = false)
    private String estadoAluno;

    @Column(name = "cidade",nullable = false)
    private String cidadeAluno;

    @Column(name = "uf", nullable = false)
    private String ufAluno;

    @Column(name = "celular")
    private String celularAluno;

    @Column(name = "email", nullable = false)
    private String emailAluno;

    @Column(name = "nome_da_mãe",nullable = false)
    private String nomeMaeAluno;

    @Column(name = "nome_do_pai")
    private String nomePaiAluno;

    @Column(name = "assinatura_do_aluno",nullable = false)
    private String assinaturaAluno;

    public Aluno() {
    }

    public Aluno(Long id,
                 String nomeAluno,
                 String cpfAluno,
                 LocalDate dataDeNascimentoAluno,
                 String rgAluno, String ruaAluno,
                 String bairroAluno,
                 String logadouroAluno,
                 String cepAluno,
                 String estadoAluno,
                 String cidadeAluno,
                 String ufAluno,
                 String celularAluno,
                 String emailAluno,
                 String nomeMaeAluno,
                 String nomePaiAluno,
                 String assinaturaAluno) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.dataDeNascimentoAluno = dataDeNascimentoAluno;
        this.rgAluno = rgAluno;
        this.ruaAluno = ruaAluno;
        this.bairroAluno = bairroAluno;
        this.logadouroAluno = logadouroAluno;
        this.cepAluno = cepAluno;
        this.estadoAluno = estadoAluno;
        this.cidadeAluno = cidadeAluno;
        this.ufAluno = ufAluno;
        this.celularAluno = celularAluno;
        this.emailAluno = emailAluno;
        this.nomeMaeAluno = nomeMaeAluno;
        this.nomePaiAluno = nomePaiAluno;
        this.assinaturaAluno = assinaturaAluno;
    }

    //Métodos de validação
    public void validar(){
        validarNomeAluno();
        validarCpfAluno();
        validarDataDeNascimentoAluno();
        validarBairroAluno();
        validarRuaAluno();
        validarCepAluno();
        validarEstadoAluno();
        validarCidadeAluno();
        validarUfAluno();
        validarEmailAluno();
        validarMaeAluno();
        validarAssinaturaAluno();

    }

    private void validarNomeAluno(){
        validarTextoObrigatorio(nomeAluno,"nome do aluno", 150);
    }
    private void validarCpfAluno(){
        validarTextoObrigatorio(cpfAluno,"cpf do aluno",30);
    }
    private void validarDataDeNascimentoAluno(){
        if(dataDeNascimentoAluno == null){
            throw new RegraDeNegocioException("Precisa inserir uma data válida");
        }
    }

    private void validarBairroAluno(){
        validarTextoObrigatorio(bairroAluno,"bairro do aluno",40);
    }
    private void validarRuaAluno(){
        validarTextoObrigatorio(ruaAluno,"rua do aluno",20);
    }
    private void validarCepAluno(){
        validarTextoObrigatorio(cepAluno,"cep do aluno",30);
    }
    private void validarEstadoAluno(){
        validarTextoObrigatorio(estadoAluno,"estado do aluno",30);
    }
    private void validarCidadeAluno(){
        validarTextoObrigatorio(cidadeAluno,"cidade do aluno",30);
    }
    private void validarUfAluno(){
        validarTextoObrigatorio(ufAluno,"uf do aluno",5);
    }
    private void validarEmailAluno(){
        validarTextoObrigatorio(emailAluno,"email do aluno",50);
        if (!emailAluno.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new RegraDeNegocioException("Email inválido");
        }
    }

    private void validarMaeAluno(){
        validarTextoObrigatorio(nomeMaeAluno,"nome da mãe",50);
    }
    private void validarAssinaturaAluno(){
        validarTextoObrigatorio(assinaturaAluno,"assinatura do aluno",50);
    }

    public void atualizarDados(Aluno novoAluno) {
        this.nomeAluno = novoAluno.getNomeAluno();
        this.cpfAluno = novoAluno.getCpfAluno();
        this.dataDeNascimentoAluno = novoAluno.getDataDeNascimentoAluno();
        this.rgAluno = novoAluno.getRgAluno();
        this.ruaAluno = novoAluno.getRuaAluno();
        this.bairroAluno = novoAluno.getBairroAluno();
        this.logadouroAluno = novoAluno.getLogadouroAluno();
        this.cepAluno = novoAluno.getCepAluno();
        this.estadoAluno = novoAluno.getEstadoAluno();
        this.cidadeAluno = novoAluno.getCidadeAluno();
        this.ufAluno = novoAluno.getUfAluno();
        this.celularAluno = novoAluno.getCelularAluno();
        this.emailAluno = novoAluno.getEmailAluno();
        this.nomeMaeAluno = novoAluno.getNomeMaeAluno();
        this.nomePaiAluno = novoAluno.getNomePaiAluno();
        this.assinaturaAluno = novoAluno.getAssinaturaAluno();
        novoAluno.validar();
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public LocalDate getDataDeNascimentoAluno() {
        return dataDeNascimentoAluno;
    }

    public void setDataDeNascimentoAluno(LocalDate dataDeNascimentoAluno) {
        this.dataDeNascimentoAluno = dataDeNascimentoAluno;
    }

    public String getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getRuaAluno() {
        return ruaAluno;
    }

    public void setRuaAluno(String ruaAluno) {
        this.ruaAluno = ruaAluno;
    }

    public String getBairroAluno() {
        return bairroAluno;
    }

    public void setBairroAluno(String bairroAluno) {
        this.bairroAluno = bairroAluno;
    }

    public String getLogadouroAluno() {
        return logadouroAluno;
    }

    public void setLogadouroAluno(String logadouroAluno) {
        this.logadouroAluno = logadouroAluno;
    }

    public String getCepAluno() {
        return cepAluno;
    }

    public void setCepAluno(String cepAluno) {
        this.cepAluno = cepAluno;
    }

    public String getEstadoAluno() {
        return estadoAluno;
    }

    public void setEstadoAluno(String estadoAluno) {
        this.estadoAluno = estadoAluno;
    }

    public String getCidadeAluno() {
        return cidadeAluno;
    }

    public void setCidadeAluno(String cidadeAluno) {
        this.cidadeAluno = cidadeAluno;
    }

    public String getUfAluno() {
        return ufAluno;
    }

    public void setUfAluno(String ufAluno) {
        this.ufAluno = ufAluno;
    }

    public String getCelularAluno() {
        return celularAluno;
    }

    public void setCelularAluno(String celularAluno) {
        this.celularAluno = celularAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public String getNomeMaeAluno() {
        return nomeMaeAluno;
    }

    public void setNomeMaeAluno(String nomeMaeAluno) {
        this.nomeMaeAluno = nomeMaeAluno;
    }

    public String getNomePaiAluno() {
        return nomePaiAluno;
    }

    public void setNomePaiAluno(String nomePaiAluno) {
        this.nomePaiAluno = nomePaiAluno;
    }

    public String getAssinaturaAluno() {
        return assinaturaAluno;
    }

    public void setAssinaturaAluno(String assinaturaAluno) {
        this.assinaturaAluno = assinaturaAluno;
    }
}
