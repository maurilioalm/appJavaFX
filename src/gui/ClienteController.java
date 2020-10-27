package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.entidades.Cliente;

public class ClienteController implements Initializable {
	
	@FXML
	private TextField textNome;
	@FXML
	private TextField textRg;
	@FXML
	private TextField textCpf;
	@FXML
	private TextField textTelefone;
	@FXML
	private TextField textEndereco;
	@FXML
	private TextField textEmail;
	
	@FXML
	private Button bVoltar;
	@FXML
	private Button bCadastrar;
	
	@FXML
	public void bVolarAcao() {
		Main.mudarTela(1);
		Main.setControle(0);
	}
	@FXML
	public void bCadastrarAcao() {
		Cliente cliente = new Cliente();
		cliente.setNome(textNome.getText());
		cliente.setRg(textRg.getText());
		cliente.setCpf(textCpf.getText());
		cliente.setTelefone(textTelefone.getText());
		cliente.setEndereco(textEndereco.getText());
		cliente.setEmail(textEmail.getText());
		Main.salvarCliente(cliente);
		Main.listaCliente();
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Cliente");
		alerta.setHeaderText("Criado com sucesso");
		alerta.setContentText("Nome: " + cliente.getNome());
		alerta.show();
		System.out.println("Cliente Cadastrado" + cliente);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
