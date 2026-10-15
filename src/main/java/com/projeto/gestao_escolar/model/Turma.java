package com.projeto.gestao_escolar.model;

import com.projeto.gestao_escolar.exception.RegraDeNegocioException;
import com.projeto.gestao_escolar.model.Enum.TurnoTurma;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.projeto.gestao_escolar.utils.ValidacaoUtils.*;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_da_turma", nullable = false, unique = true)
    private String nomeTurma;

    @Column(name = "ano_letivo", nullable = false)
    private String anoLetivoTurma;

    @Column(name = "semestre", nullable = false)
    private String semestreTurma;

    @Column(name = "turno", nullable = false)
    private TurnoTurma turno;

    @Column(name = "capacidade_maxima")
    private int capacidadeMaxima;

    @Column(name = "esta_ativa")
    private Boolean isAtiva;

    @Column(name = "data_inicio")
    private Date dataInicioTurma;

    @Column(name = "data_fim")
    private Date dataFimTurma;

    @Column(name = "sala_de_aula")
    private String salaDeAulaTurma;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "turma_alunos",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunos = new HashSet<>();

    public Turma() {
    }

    public Turma(Long id,
                 String nomeTurma,
                 String anoLetivoTurma,
                 String semestreTurma,
                 TurnoTurma turno,
                 int capacidadeMaxima,
                 Boolean isAtiva,
                 Date dataInicioTurma,
                 Date dataFimTurma,
                 String salaDeAulaTurma) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.anoLetivoTurma = anoLetivoTurma;
        this.semestreTurma = semestreTurma;
        this.turno = turno;
        this.capacidadeMaxima = capacidadeMaxima;
        this.isAtiva = isAtiva;
        this.dataInicioTurma = dataInicioTurma;
        this.dataFimTurma = dataFimTurma;
        this.salaDeAulaTurma = salaDeAulaTurma;
    }

    //Métodos de validação
    public void validar(){
        validarNomeTurma();
        validarAnoLetivoTurma();
        validarSemestreTurma();
        validarTurnoTurma();
        validarEstaAtivaTurma();
    }

    private void validarNomeTurma(){
        validarTextoObrigatorio(nomeTurma,"nome da turma", 20);
    }
    private void validarAnoLetivoTurma(){
        validarInteiroObrigatorio(anoLetivoTurma,"ano_letivo",5);
    }
    private void validarSemestreTurma(){
        validarSemestre(semestreTurma,"semestre",10);
    }
    private void validarTurnoTurma(){
        validarTurnoObrigatorio(turno,"turno",50);
    }
    private void validarEstaAtivaTurma(){
        if(isAtiva == null){
            throw new RegraDeNegocioException("o campo " +isAtiva+" deve ser obrigatório");
        }
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getAnoLetivoTurma() {
        return anoLetivoTurma;
    }

    public void setAnoLetivoTurma(String anoLetivoTurma) {
        this.anoLetivoTurma = anoLetivoTurma;
    }

    public String getSemestreTurma() {
        return semestreTurma;
    }

    public void setSemestreTurma(String semestreTurma) {
        this.semestreTurma = semestreTurma;
    }

    public TurnoTurma getTurno() {
        return turno;
    }

    public void setTurno(TurnoTurma turno) {
        this.turno = turno;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Boolean getAtiva() {
        return isAtiva;
    }

    public void setAtiva(Boolean ativa) {
        isAtiva = ativa;
    }

    public Date getDataInicioTurma() {
        return dataInicioTurma;
    }

    public void setDataInicioTurma(Date dataInicioTurma) {
        this.dataInicioTurma = dataInicioTurma;
    }

    public Date getDataFimTurma() {
        return dataFimTurma;
    }

    public void setDataFimTurma(Date dataFimTurma) {
        this.dataFimTurma = dataFimTurma;
    }

    public String getSalaDeAulaTurma() {
        return salaDeAulaTurma;
    }

    public void setSalaDeAulaTurma(String salaDeAulaTurma) {
        this.salaDeAulaTurma = salaDeAulaTurma;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return capacidadeMaxima == turma.capacidadeMaxima && Objects.equals(id, turma.id) && Objects.equals(nomeTurma, turma.nomeTurma) && Objects.equals(anoLetivoTurma, turma.anoLetivoTurma) && Objects.equals(semestreTurma, turma.semestreTurma) && turno == turma.turno && Objects.equals(isAtiva, turma.isAtiva) && Objects.equals(dataInicioTurma, turma.dataInicioTurma) && Objects.equals(dataFimTurma, turma.dataFimTurma) && Objects.equals(salaDeAulaTurma, turma.salaDeAulaTurma) && Objects.equals(alunos, turma.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTurma, anoLetivoTurma, semestreTurma, turno, capacidadeMaxima, isAtiva, dataInicioTurma, dataFimTurma, salaDeAulaTurma, alunos);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", anoLetivoTurma='" + anoLetivoTurma + '\'' +
                ", semestreTurma='" + semestreTurma + '\'' +
                ", turno=" + turno +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", isAtiva=" + isAtiva +
                ", dataInicioTurma=" + dataInicioTurma +
                ", dataFimTurma=" + dataFimTurma +
                ", salaDeAulaTurma='" + salaDeAulaTurma + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
