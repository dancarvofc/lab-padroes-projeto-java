package one.digitalinnovation.gof.chain;

public class ProcessadorPedido {

	private final ValidadorPedidoHandler primeiroValidador;

	public ProcessadorPedido(double limiteAprovacaoAutomatica) {
		ValidadorPedidoHandler validadorClienteAtivo = new ValidadorClienteAtivoHandler();
		ValidadorPedidoHandler validadorLimite = new ValidadorLimiteValorHandler(limiteAprovacaoAutomatica);
		ValidadorPedidoHandler validadorFraude = new ValidadorFraudeHandler();
		ValidadorPedidoHandler aprovadorFinal = new AprovadorFinalHandler();

		validadorClienteAtivo
				.setProximo(validadorLimite)
				.setProximo(validadorFraude)
				.setProximo(aprovadorFinal);

		this.primeiroValidador = validadorClienteAtivo;
	}

	public void processar(Pedido pedido) {
		primeiroValidador.validar(pedido);
	}
}
