package org.alunostm.entity;

public enum CursoEnum {
    curso28("Engenharia de Software"),
    curso33("Análise e desenvolvimento de Sistemas");

    private final String nomeCurso;

    CursoEnum(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
}
