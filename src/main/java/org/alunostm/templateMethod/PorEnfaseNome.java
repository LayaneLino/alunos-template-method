package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

public class PorEnfaseNome extends AlunoTemplateMethod {

    public PorEnfaseNome(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public boolean criterio(Aluno aluno1, Aluno aluno2) {
        int comparacao = aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase());

        if (comparacao == 0) {
            comparacao = aluno1.getNome().compareToIgnoreCase(aluno2.getNome());
        }

        return comparacao <= 0;
    }

}
