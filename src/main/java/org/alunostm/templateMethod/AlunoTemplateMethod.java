package org.alunostm.templateMethod;

import org.alunostm.entity.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AlunoTemplateMethod {
    private final String nomeArquivo;

    protected AlunoTemplateMethod(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public abstract boolean criterio(Aluno aluno1, Aluno aluno2);

    public Iterator<Aluno> listagemDeAlunos()throws Exception{
        List<Aluno> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                if (!linha.isBlank()) {
                    lista.add(new Aluno(linha));
                }
            }
        }

        lista.sort((a1, a2) -> {
            if (criterio(a1, a2)) return -1;
            if (criterio(a2, a1)) return 1;
            return 0;
        });

        return lista.iterator();
    }

}
