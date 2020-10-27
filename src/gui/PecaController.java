package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.entidades.Peca;

public class PecaController implements Initializable {
	
	Peca peca = new Peca();
	
	@FXML
	private TextField textCodigo;
	@FXML
	private TextField textDescricao;
	@FXML
	private TextField textPreco;
	@FXML
	private TextField textQuantidade;
	@FXML
	private Button bCadastrar;
	@FXML
	private Button bVoltar;
	
	@FXML
	public void bCadastrar() {
	peca.setCodigo(textCodigo.getText());
	peca.setDescricao(textDescricao.getText());
	peca.setPreco(Double.parseDouble(textPreco.getText()));
	peca.setQtdEstoque(Integer.parseInt(textQuantidade.getText()));
	Main.salvarPecas(peca);
	System.out.println("Ok salvo");
	Alert alerta = new Alert(Alert.AlertType.INFORMATION);
	alerta.setTitle("Peca");
	alerta.setHeaderText("Peca inserido no estoque");
	alerta.setContentText("Nome: " + peca.getDescricao() + " Valor R$: " + String.valueOf(peca.getPreco()));
	alerta.show();
	Main.listaPecas();
	
	}

	@FXML
	public void bVolarAcao() {
		Main.mudarTela(1);
		Main.setControle(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}