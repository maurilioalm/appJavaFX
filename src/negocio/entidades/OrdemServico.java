package negocio.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import negocio.entidades.enums.StatusServico;

public class OrdemServico {

	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private Integer numOS;
	private StatusServico statusServico;
	private Colaborador colaborador;
	private Cliente cliente;
	private Servico servico;
	private Double desconto;
	private Double adiantamento;
	private String tipoPagamento;

	private List<Peca> pecas = new ArrayList<Peca>();

	public OrdemServico() {
		this.dataEntrada = dataEntrada.now();
		this.numOS = positivo();
		this.adiantamento = (double) 0;
		this.desconto = (double) 0;
	}

	public OrdemServico(StatusServico statusServico, Colaborador colaborador, Cliente cliente, Servico servico) {
		super();
		this.dataEntrada = dataEntrada.now();
		this.numOS = positivo();
		this.statusServico = statusServico;
		this.colaborador = colaborador;
		this.cliente = cliente;
		this.servico = servico;
		this.adiantamento = (double) 0;
		this.desconto = (double) 0;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer positivo() {
		Integer numOS = new Random().nextInt();
		if (numOS < 0) {
			return numOS * -1;
		}
		return numOS;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double i) {
		this.desconto = i;
	}

	public Double getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(Double adiantamento) {
		this.adiantamento = adiantamento;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada() {
		this.dataEntrada = dataEntrada.now();
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getNumOS() {
		return numOS;
	}

	public void setNumOS(Integer numOS) {
		this.numOS = numOS;
	}

	public StatusServico getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(StatusServico statusServico) {
		this.statusServico = statusServico;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(Peca peca) {
		peca.setQtdEstoque(peca.getQtdEstoque() -1);
		pecas.add(peca);
	}

	public void removePecas() {
		pecas.removeAll(pecas);
	}

	public Peca localizarPeca(List<Peca> list) {
		Peca localizada = new Peca();
		for (Peca peca : list) {
			localizada = peca;
		}
		return localizada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numOS == null) ? 0 : numOS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (numOS == null) {
			if (other.numOS != null)
				return false;
		} else if (!numOS.equals(other.numOS))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdemServico [dataEntrada = " + dataEntrada + ", dataSaid a= " + dataSaida + ", numOS = " + numOS
				+ ", statusServico=" + statusServico + ", colaborador=" + colaborador + ", cliente=" + cliente
				+ ", servico = " + servico + ", desconto = " + desconto + ", adiantamento = " + adiantamento
				+ ", tipoPagamento = " + tipoPagamento + ", pecas = " + pecas + "]";
	}

	

}
