
package ui.ClienteNaoCadastrado;

import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServico;


public class CadastroDeClienteController implements Initializable {

    @FXML
    private JFXTextField textFieldId;  
    @FXML
    private JFXTextField textFieldNome;    
    @FXML
    private JFXTextField textFieldCpfCnpj;
    @FXML
    private JFXTextField textFieldEmail;
    @FXML
    private JFXTextField textFieldTelefone;
    @FXML
    private JFXTextField textFieldEndereco;
    @FXML
    private Button buttonSalvar;
    @FXML
    private Button buttonEditar;
    
     //Atributo para representar o servico
    private ClienteServico servico = new ClienteServico();
    
   
    @FXML
    private TableColumn<?, ?> c1Id;
    @FXML
    private TableColumn<?, ?> c2Nome;
    @FXML
    private TableColumn<?, ?> c3CpfCnpj;
    @FXML
    private TableColumn<?, ?> c4Email;
    @FXML
    private TableColumn<?, ?> c5Telefone;
    @FXML
    private TableColumn<?, ?> c6Endereco;

    //Atributo que representa os dados para tabela
    //import javafx.collections.FXCollections;
    //import javafx.collections.ObservableList;
    private ObservableList<Cliente> dados
            = FXCollections.observableArrayList();

    //Atributo que vai armazenar qual o ator 
    //foi selecionado na tabela
    private Cliente selecionado;
    @FXML
    private TableView<Cliente> tabela;

    /**
     * Initializes the controller class. Tudo que é feito ao inicializar a
     * Janela
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Configure a tabela
        configurarTabela();

        //Carregue a lista de atores na tabela
        listarClientesTabela();

    }

    private void salvar(ActionEvent event) {
        
        //Verificar se está atualizando ou inserindo
        if(textFieldId.getText().isEmpty()){ //inserindo
            //Pega os dados do fomulário
            //e cria um objeto ator
            Cliente c1 = new Cliente(textFieldNome.getText());
            Cliente c2 = new Cliente(textFieldCpfCnpj.getText());
            Cliente c3 = new Cliente(textFieldEmail.getText());
            Cliente c4 = new Cliente(textFieldTelefone.getText());
            Cliente c5 = new Cliente(textFieldEndereco.getText());

            //Mandar o ator para a camada de servico
            servico.salvar(c1);
            servico.salvar(c2);
            servico.salvar(c3);
            servico.salvar(c4);
            servico.salvar(c5);
            
            //Exibindo mensagem
            mensagemSucesso("Cliente salvo com sucesso!");
            
            //Chama o metodo para atualizar a tabela
            listarClientesTabela();
            
        }else{ //atualizando o ator
           
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            
            //Se o botão OK foi pressionado
            if(btn.get() == ButtonType.OK){
                //Pegar os novos dados do formulário e
                //atualizar o meu ator
                selecionado.setNome(textFieldNome.getText());
                
                //Mandando pra camada de serviço salvar as alterações
                servico.editar(selecionado);
                
                //Exibindo mensagem
                mensagemSucesso("Cliente atualizado com sucesso!"); 
                
                //Chama o metodo para atualizar a tabela
                 listarClientesTabela();
            }
            
        }

        
        //Limpando o form
        textFieldId.setText("");
        textFieldNome.setText("");
    }

    public void mensagemSucesso(String m) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("SUCESSO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
    /**
     * Exibe uma mensagem de erro
     * @param m 
     */
    public void mensagemErro(String m) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }

    /**
     * Fazendo configuração das colunas da tabeça
     */
    private void configurarTabela() {

        //Dizer de onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get
        //que deve ser chamado para cada coluna
        // A string entre parênteses é o nome do atributo
        // que vc deseja chamar o get (quase sempre)
        //import javafx.scene.control.cell.PropertyValueFactory;
        c1Id.setCellValueFactory(
                new PropertyValueFactory("id"));
        c2Nome.setCellValueFactory(
                new PropertyValueFactory("nome"));
        c3CpfCnpj.setCellValueFactory(
                new PropertyValueFactory("CPF/CNPJ"));
        c4Email.setCellValueFactory(
                new PropertyValueFactory("E-mail"));
        c5Telefone.setCellValueFactory(
                new PropertyValueFactory("Telefone"));
        c6Endereco.setCellValueFactory(
                new PropertyValueFactory("Endereço"));
        
    }//configurarTabela

    /**
     * Responsável por carregar a lista de atores na tabela
     */
    private void listarClientesTabela() {
        //Limpando quaisquer dados anteriores
        dados.clear();

        //Solicitando a camada de servico a lista de atores
        List<Cliente> clientes = servico.listar();

        //Transformar a lista de atores no formato que a tabela
        //do JavaFX aceita
        dados = FXCollections.observableArrayList(clientes);

        //Jogando os dados na tabela
        tabela.setItems(dados);

    }

    private void editar(ActionEvent event) {

        //Pegar o ator que foi selecionado na tabela
        selecionado = tabela.getSelectionModel()
                .getSelectedItem();

        //Se tem algum ator selecionado
        if (selecionado != null) { //tem ator selecionado
            //Pegar os dados do ator e jogar nos campos do
            //formulario
            textFieldId.setText(
                    String.valueOf( selecionado.getId_cadastro() ) );
            textFieldNome.setText( selecionado.getNome() );    
        }else{ //não tem cliente selecionado na tabela
            mensagemErro("Selecione um Cliente.");
        }

    }
    
    /**
     * Mostra uma caixa com uma mensagem de confirmação
     * onde a pessoa vai poder responder se deseja realizar
     * uma ação
     */
    private Optional<ButtonType> mensagemDeConfirmacao(
            String mensagem, String titulo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert.showAndWait();
    }

    /*private void excluir(ActionEvent event) {
        
        //Pegar o ator que foi selecionado na tabela
        selecionado = tabela.getSelectionModel()
                .getSelectedItem();
        
        //Verifico se tem ator selecionado
        if(selecionado != null){ //existe ator selecionado
            
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            
            //Verificando se apertou o OK
            if(btn.get() == ButtonType.OK){
                
                //Manda para a camada de serviço excluir
                servico.excluir(selecionado);
                
                //mostrar mensagem de sucesso
                mensagemSucesso("Cliente excluído com sucesso");
                
                //Atualizar a tabela
                listarClientesTabela();              
                
            }
            
            
            
        }else{
            mensagemErro("Selecione um ator.");
        }*/
        
    }



