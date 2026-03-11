package org.alunostm.repository;

import org.alunostm.entity.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class AlunoTemplateMethod {
    private final String nomeArquivo;

    protected AlunoTemplateMethod(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public abstract boolean criterio(Aluno aluno1, Aluno aluno2);

    public ArrayList<Aluno> listagemDeAlunos()throws Exception{
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
            for (int j = i; j < array.size(); j++) {
                if (!criterio(array.get(i),array.get(j))) {
                    Aluno temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        return array;
    }

}
