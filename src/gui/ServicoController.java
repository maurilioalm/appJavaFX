package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.entidades.Servico;

public class ServicoController extends OrdemDeServicoController implements Initializable {
	
	@FXML
	private TextField textTipo;
	@FXML
	private TextField textDescricao;
	@FXML
	private TextField textPreco;
	@FXML
	private Button bConfirmar;
	@FXML
	private Button bVoltar;
	
	
	@FXML
	public void bVolarAcao() {
		Main.mudarTela(5);
	}
	@FXML
	public void bConfirmarAcao() {
		Servico servico = new Servico();
		servico.setTipoServico(textTipo.getText());
		servico.setDescricaoServico(textDescricao.getText());
		servico.setPreco(Double.parseDouble(textPreco.getText()));
		super.addServico(servico);
		Main.mudarTela(5);
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Servico");
		alerta.setHeaderText("Servico adicionado com sucesso");
		alerta.setContentText("Nome: " + servico.getTipoServico() + "\nAtualize a OS para verificar");
		alerta.show();
	}
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
