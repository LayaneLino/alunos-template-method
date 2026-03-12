package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class AlunoTemplateMethod {
    private final String nomeArquivo;

    protected AlunoTemplateMethod(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public abstract boolean criterio(Aluno aluno1, Aluno aluno2);

    public Iterator<Aluno> listagemDeAlunos()throws Exception{
        ArrayList<Aluno> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                if (!linha.isBlank()) {
                    array.add(new Aluno(linha));
                }
            }
        }

        for (int i = 0; i < array.size(); i++) {
            ListIterator<Aluno> iteratorJ = array.listIterator(i);
            while (iteratorJ.hasNext()) {
                int indexJ = iteratorJ.nextIndex();
                Aluno alunoJ = iteratorJ.next();
                Aluno alunoI = array.get(i);

                if (!criterio(alunoI, alunoJ)) {
                    array.set(indexJ, alunoI);
                    array.set(i, alunoJ);
                }
            }
        }
        return array.iterator();
    }

}
