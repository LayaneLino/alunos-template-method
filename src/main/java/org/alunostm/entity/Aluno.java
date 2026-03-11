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
        String[] vetor = str.split(";");
        this.nome = vetor[0].trim();
        String numeroCurso = vetor[1].trim();
        this.curso = CursoEnum.valueOf("curso" + numeroCurso);
        this.situacao = vetor[2].trim().equalsIgnoreCase("sim");
        this.enfase = vetor[3].trim();
    }

    public String getNomePadronizado() {
        String[] partes = this.nome.trim().split(" ");
        if (partes.length <= 1) {
            return this.nome;
        }

        int indiceSobrenome = partes.length - 1;
        String ultimo = partes[indiceSobrenome];

        String ignorar = "Filho Júnior Junior Neto Neto Sobrinho";

        if (ignorar.toLowerCase().contains(ultimo.toLowerCase()) && partes.length > 2) {
            String sobrenomeAnterior = partes[partes.length - 2];
            return sobrenomeAnterior + ", " + juntarNomes(partes, partes.length - 2);
        }

        return ultimo + ", " + juntarNomes(partes, partes.length - 1);
    }

    private String juntarNomes(String[] partes, int indiceOmitidoParaNaoRepetir) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            if (i == indiceOmitidoParaNaoRepetir) {
                continue;
            }
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
