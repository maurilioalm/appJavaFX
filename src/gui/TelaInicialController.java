package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaInicialController implements Initializable{
	

	@FXML
	private TextField nomeColaborador;
	@FXML
	private PasswordField matriculaColaborador;
	@FXML
	private Button bLogar;
	@FXML
	private Button bCadastrarColaborador;
	@FXML
	private Button bCadastrarPeca;
	@FXML
	private Button bCadastrarCliente;
	
	
	
	
	@FXML
	public void bLogarAcao() {
		if(Main.autenticacao(nomeColaborador.getText(), matriculaColaborador.getText())){
			OrdemDeServicoController osc = new OrdemDeServicoController();
			osc.criarColaboradorOrdemServico(matriculaColaborador.getText());
			Main.mudarTela(5);
	
		}else {
		System.out.println("Erro no login ou senha, coloque o nome e matricula correto");
		}
	}
	
	@FXML
	public void bCadastrarColaboradorAcao() {
		Main.mudarTela(2);
	}
	@FXML
	public void bCadastrarPecaAcao() {
		Main.mudarTela(3);
	}
	@FXML
	public void bCadastrarClienteAcao() {
		Main.mudarTela(4);
	}
	
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
