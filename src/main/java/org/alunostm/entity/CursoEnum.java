package org.alunostm.entity;

public enum CursoEnum {
    ENG("28", "Engenharia de Software"),
    ADS("33", "Análise e Desenvolvimento de Sistemas");

    private final String codigo;
    private final String nomeCurso;

    CursoEnum(String codigo, String nomeCurso) {
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public static CursoEnum converteCodigoCurso(String codigo) {
        for (CursoEnum c : values()) {
            if (c.codigo.equals(codigo)) {
                return c;
            }
        }
        return null;
    }

}
