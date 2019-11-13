/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesNãoCadastrados;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Pandora(SSQ)
 */
public class CadastrarClientesController implements Initializable {

    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> C1ID;
    @FXML
    private TableColumn<?, ?> C2Nome;
    @FXML
    private TableColumn<?, ?> C3CpfCnpj;
    @FXML
    private TableColumn<?, ?> C4Email;
    @FXML
    private TableColumn<?, ?> C5Telefone;
    @FXML
    private TableColumn<?, ?> C6Endereco;
    @FXML
    private JFXTextField tfID;
    @FXML
    private JFXTextField tfNome;
    @FXML
    private JFXTextField tfTelefone;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextField tfCpfCnpj;
    @FXML
    private JFXTextField tfEndereco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void agendar(ActionEvent event) {
    }
    
}
