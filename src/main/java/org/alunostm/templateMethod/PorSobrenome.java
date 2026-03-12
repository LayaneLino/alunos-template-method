package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

public class PorSobrenome extends AlunoTemplateMethod {

    public PorSobrenome(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public boolean criterio(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNomePadronizado().compareToIgnoreCase(aluno2.getNomePadronizado()) <= 0;
    }

}
