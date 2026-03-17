package org.alunostm.entity;

public class Aluno {
    private final String nome;
    private final CursoEnum curso;
    private final boolean situacao;
    private final String enfase;

    public Aluno(String nome, CursoEnum curso, boolean situacao, String enfase) {
        this.nome = nome;
        this.curso = curso;
        this.situacao = situacao;
        this.enfase = enfase;
    }

    public Aluno(String str){
        String[] dados = str.split(";");
        this.nome = dados[0].trim();
        this.curso = CursoEnum.converteCodigoCurso(dados[1].trim());
        this.situacao = dados[2].trim().equalsIgnoreCase("sim");
        this.enfase = dados[3].trim();
    }

    public String getNomePadronizado() {
        String[] partes = this.nome.trim().split("\\s+");

        if (partes.length <= 1){
            return this.nome;
        }

        String sufixosIgnorar = " Filho Filha Júnior Junior Neto Neta Sobrinho Sobrinha ";
        String preposicoesIgnorar = " de da do das dos ";

        int ultimoIndice = partes.length - 1;
        String ultimo = partes[ultimoIndice];

        int indiceDeCorte;

        if (sufixosIgnorar.toLowerCase().contains(" " + ultimo.toLowerCase() + " ") && partes.length > 2) {
            int i = ultimoIndice - 1;

            if (preposicoesIgnorar.toLowerCase().contains(" " + partes[i].toLowerCase() + " ") && i > 0) {
                indiceDeCorte = i - 1;
            } else {
                indiceDeCorte = i;
            }
        } else {
            indiceDeCorte = ultimoIndice;
        }

        String sobrenomeDeDestaque = partes[indiceDeCorte];
        return sobrenomeDeDestaque + ", " + montarRestante(partes, indiceDeCorte);
    }

    private String montarRestante(String[] partes, int indiceOmitido) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            if (i == indiceOmitido) continue;
            sb.append(partes[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public String getNome() {
        return nome;
    }

    public CursoEnum getCurso() {
        return curso;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public String getEnfase() {
        return enfase;
    }

}
