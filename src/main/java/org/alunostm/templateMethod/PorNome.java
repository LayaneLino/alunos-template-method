package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

public class PorNome extends AlunoTemplateMethod {

    public PorNome(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public boolean criterio(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0;
    }

}
