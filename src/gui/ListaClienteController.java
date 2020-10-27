package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.entidades.Cliente;

public class ListaClienteController extends OrdemDeServicoController implements Initializable {

	@FXML
	private TableView<Cliente> tblClientes;
	@FXML
	private TableColumn<Cliente, String> clNome;
	@FXML
	private TableColumn<Cliente, String> clCpf;
	@FXML
	private TableColumn<Cliente, String> clTelefone;
	@FXML
	private TableColumn<Cliente, String> clEmail;
	@FXML
	private TextField textCpf;
	
	private ObservableList<Cliente> obsCliente;
	
	
	
	

	@FXML
	private Button bVoltar;
	@FXML
	private Button bSelecionar;
	@FXML
	private Button bAtualizar;
	@FXML
	private Button bCadastrar;

	@FXML
	public void bVolarAcao() {
		Main.mudarTela(5);
	}
	@FXML
	public void bAtualizarAcao() {
		System.out.println(Main.listaCliente());
		tblClientes.getItems().setAll(Main.listaCliente());
	}
	

	@FXML
	public void bSelecionarrAcao() {
		Cliente cliente = Main.localizarCliente(textCpf.getText());
		super.addCliente(cliente);
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Cliente");
		alerta.setHeaderText("Cliente selecionado");
		alerta.setContentText("Nome: " + cliente.getNome() + "\nAtualize a OS para verificar");
		alerta.show();
		Main.mudarTela(5);

	}
	@FXML
	public void bCadastrarAcao() {
		Main.mudarTela(4);
	}

	@FXML
	public void inicialize() {
		if (tblClientes != null)
			tblClientes.getItems().setAll(Main.listaCliente());
	}

	public void refreshTable() {
		tblClientes.getItems().setAll(Main.listaCliente());
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        clCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        clTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        clEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        
        obsCliente = FXCollections.observableArrayList();
	}

	/*
	 * public void refreshTable() {
	 * 
	 * }
	 */

}
