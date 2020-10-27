package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.entidades.Colaborador;

public class ColaboradorController implements Initializable {
	
	@FXML
	private TextField textNome;
	@FXML
	private TextField textRg;
	@FXML
	private TextField textCpf;
	@FXML
	private TextField textMatricula;
	
	
	@FXML
	private Button bCadastrar;
	@FXML
	private Button bVoltar;
	
	@FXML
	public void bVolarAcao() {
		Main.mudarTela(1);
	}
	
	@FXML
	public void bCadastrarAcao() {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome(textNome.getText());
		colaborador.setRg(textRg.getText());
		colaborador.setCpf(textCpf.getText());
		colaborador.setMatricula(textMatricula.getText());
		Main.salvarColaborador(colaborador);
		Main.listaColaborador();
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
