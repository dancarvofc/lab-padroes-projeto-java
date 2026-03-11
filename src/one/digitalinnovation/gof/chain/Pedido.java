package one.digitalinnovation.gof.chain;

public class Pedido {

	private final String cliente;
	private final double valor;
	private final boolean clienteAtivo;
	private final boolean suspeitaFraude;
	private boolean aprovado;
	private String motivoReprovacao;

	public Pedido(String cliente, double valor, boolean clienteAtivo, boolean suspeitaFraude) {
		this.cliente = cliente;
		this.valor = valor;
		this.clienteAtivo = clienteAtivo;
		this.suspeitaFraude = suspeitaFraude;
	}

	public String getCliente() {
		return cliente;
	}

	public double getValor() {
		return valor;
	}

	public boolean isClienteAtivo() {
		return clienteAtivo;
	}

	public boolean isSuspeitaFraude() {
		return suspeitaFraude;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void aprovar() {
		this.aprovado = true;
		this.motivoReprovacao = null;
	}

	public void reprovar(String motivoReprovacao) {
		this.aprovado = false;
		this.motivoReprovacao = motivoReprovacao;
	}

	public String getMotivoReprovacao() {
		return motivoReprovacao;
	}
}
