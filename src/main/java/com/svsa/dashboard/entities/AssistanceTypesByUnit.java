package com.svsa.dashboard.entities;

import java.util.Objects;

public class AssistanceTypesByUnit {

    private Unit unit;
    private Integer qtdAtendimentoRecepcao;
    private Integer qtdAtendimentoSocial;
    private Integer qtdAtendimentoAtualizacaoCadUnico;
    private Integer qtdAtendimentoCadastramentoCadUnico;
    private Integer qtdVisitaDomiciliar;

    public AssistanceTypesByUnit() {}

    public AssistanceTypesByUnit(Integer qtdAtendimentoRecepcao, Integer qtdAtendimentoSocial,
                                 Integer qtdAtendimentoAtualizacaoCadUnico, Integer qtdAtendimentoCadastramentoCadUnico, Integer qtdVisitaDomiciliar) {
        this.qtdAtendimentoRecepcao = qtdAtendimentoRecepcao;
        this.qtdAtendimentoSocial = qtdAtendimentoSocial;
        this.qtdAtendimentoAtualizacaoCadUnico = qtdAtendimentoAtualizacaoCadUnico;
        this.qtdAtendimentoCadastramentoCadUnico = qtdAtendimentoCadastramentoCadUnico;
        this.qtdVisitaDomiciliar = qtdVisitaDomiciliar;
    }

    public AssistanceTypesByUnit(Unit unit, Integer qtdAtendimentoRecepcao, Integer qtdAtendimentoSocial,
                                 Integer qtdAtendimentoAtualizacaoCadUnico, Integer qtdAtendimentoCadastramentoCadUnico, Integer qtdVisitaDomiciliar) {
        this.unit = unit;
        this.qtdAtendimentoRecepcao = qtdAtendimentoRecepcao;
        this.qtdAtendimentoSocial = qtdAtendimentoSocial;
        this.qtdAtendimentoAtualizacaoCadUnico = qtdAtendimentoAtualizacaoCadUnico;
        this.qtdAtendimentoCadastramentoCadUnico = qtdAtendimentoCadastramentoCadUnico;
        this.qtdVisitaDomiciliar = qtdVisitaDomiciliar;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getQtdAtendimentoRecepcao() {
        return qtdAtendimentoRecepcao;
    }

    public void setQtdAtendimentoRecepcao(Integer qtdAtendimentoRecepcao) {
        this.qtdAtendimentoRecepcao = qtdAtendimentoRecepcao;
    }

    public Integer getQtdAtendimentoSocial() {
        return qtdAtendimentoSocial;
    }

    public void setQtdAtendimentoSocial(Integer qtdAtendimentoSocial) {
        this.qtdAtendimentoSocial = qtdAtendimentoSocial;
    }

    public Integer getQtdAtendimentoAtualizacaoCadUnico() {
        return qtdAtendimentoAtualizacaoCadUnico;
    }

    public void setQtdAtendimentoAtualizacaoCadUnico(Integer qtdAtendimentoAtualizacaoCadUnico) {
        this.qtdAtendimentoAtualizacaoCadUnico = qtdAtendimentoAtualizacaoCadUnico;
    }

    public Integer getQtdAtendimentoCadastramentoCadUnico() {
        return qtdAtendimentoCadastramentoCadUnico;
    }

    public void setQtdAtendimentoCadastramentoCadUnico(Integer qtdAtendimentoCadastramentoCadUnico) {
        this.qtdAtendimentoCadastramentoCadUnico = qtdAtendimentoCadastramentoCadUnico;
    }

    public Integer getQtdVisitaDomiciliar() {
        return qtdVisitaDomiciliar;
    }

    public void setQtdVisitaDomiciliar(Integer qtdVisitaDomiciliar) {
        this.qtdVisitaDomiciliar = qtdVisitaDomiciliar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssistanceTypesByUnit that = (AssistanceTypesByUnit) o;
        return qtdAtendimentoRecepcao == that.qtdAtendimentoRecepcao && qtdAtendimentoSocial == that.qtdAtendimentoSocial && qtdAtendimentoAtualizacaoCadUnico == that.qtdAtendimentoAtualizacaoCadUnico && qtdAtendimentoCadastramentoCadUnico == that.qtdAtendimentoCadastramentoCadUnico && qtdVisitaDomiciliar == that.qtdVisitaDomiciliar && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, qtdAtendimentoRecepcao, qtdAtendimentoSocial, qtdAtendimentoAtualizacaoCadUnico, qtdAtendimentoCadastramentoCadUnico, qtdVisitaDomiciliar);
    }
}
