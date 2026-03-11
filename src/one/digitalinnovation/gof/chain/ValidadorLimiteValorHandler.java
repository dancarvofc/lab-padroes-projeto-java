package one.digitalinnovation.gof.chain;

public class ValidadorLimiteValorHandler extends ValidadorPedidoHandler {

	private final double limite;

	public ValidadorLimiteValorHandler(double limite) {
		this.limite = limite;
	}

	@Override
	protected boolean executarValidacao(Pedido pedido) {
		if (pedido.getValor() > limite) {
			pedido.reprovar("Valor acima do limite aprovado automaticamente.");
			return false;
		}
		return true;
	}
}
