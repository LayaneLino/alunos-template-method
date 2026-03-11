package org.alunostm.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.alunostm.entity.Aluno;
import org.alunostm.repository.AlunoTemplateMethod;
import org.alunostm.templateMethod.*;

import java.util.ArrayList;

public class AlunoController {

    @FXML private ComboBox<String> comboOrdenacao;
    @FXML private TableView<Aluno> tabelaAlunos;
    @FXML private TableColumn<Aluno, String> colNome;
    @FXML private TableColumn<Aluno, String> colCurso;
    @FXML private TableColumn<Aluno, String> colSituacao;
    @FXML private TableColumn<Aluno, String> colEnfase;

    private final String arquivo = "RelatorioDasEnfases.csv";

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNome()));
        colCurso.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCurso().getNomeCurso()));
        colSituacao.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().isSituacao() ? "Sim" : "Não"));
        colEnfase.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEnfase()));

        ObservableList<String> opcoes = FXCollections.observableArrayList(
                "Por Nome", "Por Sobrenome", "Por Situação e Nome",
                "Por Curso e Nome", "Por Ênfase e Nome", "Por Curso, Ênfase e Nome",
                "Por Ênfase, Curso e Nome", "Situação, Ênfase, Curso e Nome"
        );
        comboOrdenacao.setItems(opcoes);
    }

    @FXML
    void tratarBotaoGerar() {
        int selecao = comboOrdenacao.getSelectionModel().getSelectedIndex();
        if (selecao == -1) {
            return;
        }

        AlunoTemplateMethod alunoTemplateMethod = switch (selecao) {
            case 0 -> new PorNome(arquivo);
            case 1 -> new PorSobrenome(arquivo);
            case 2 -> new PorSituacaoNome(arquivo);
            case 3 -> new PorCursoNome(arquivo);
            case 4 -> new PorEnfaseNome(arquivo);
            case 5 -> new PorCursoEnfaseNome(arquivo);
            case 6 -> new PorEnfaseCursoNome(arquivo);
            case 7 -> new PorSituEnfCursNome(arquivo);
            default -> null;
        };

        try {
            if (selecao == 1) {
                colNome.setCellValueFactory(cellData ->
                        new SimpleStringProperty(cellData.getValue().getNomePadronizado()));
            } else {
                colNome.setCellValueFactory(cellData ->
                        new SimpleStringProperty(cellData.getValue().getNome()));
            }
            atualizarTabela(alunoTemplateMethod.listagemDeAlunos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela(ArrayList<Aluno> lista) {
        ObservableList<Aluno> dados = FXCollections.observableArrayList(lista);
        tabelaAlunos.setItems(dados);
    }
}