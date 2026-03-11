package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;
import org.alunostm.repository.AlunoTemplateMethod;

public class PorSituacaoNome extends AlunoTemplateMethod {

    public PorSituacaoNome(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public boolean criterio(Aluno aluno1, Aluno aluno2) {
        int comparacao = Boolean.compare(aluno2.isSituacao(), aluno1.isSituacao());

        if (comparacao == 0) {
            comparacao = aluno1.getNome().compareToIgnoreCase(aluno2.getNome());
        }

        return comparacao <= 0;
    }

}
