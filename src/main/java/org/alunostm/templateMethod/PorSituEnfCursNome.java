package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

public class PorSituEnfCursNome extends AlunoTemplateMethod {

    public PorSituEnfCursNome(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public boolean criterio(Aluno aluno1, Aluno aluno2) {
        int comparacao = Boolean.compare(aluno2.isSituacao(), aluno1.isSituacao());

        if (comparacao == 0) {
            comparacao = aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase());
        }

        if (comparacao == 0) {
            comparacao = aluno1.getCurso().getNomeCurso().compareToIgnoreCase(aluno2.getCurso().getNomeCurso());
        }

        if (comparacao == 0) {
            comparacao = aluno1.getNome().compareToIgnoreCase(aluno2.getNome());
        }

        return comparacao <= 0;
    }

}
