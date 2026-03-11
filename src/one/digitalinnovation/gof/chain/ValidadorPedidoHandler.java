package one.digitalinnovation.gof.chain;

public abstract class ValidadorPedidoHandler {

	private ValidadorPedidoHandler proximo;

	public ValidadorPedidoHandler setProximo(ValidadorPedidoHandler proximo) {
		this.proximo = proximo;
		return proximo;
	}

	public void validar(Pedido pedido) {
		boolean valido = executarValidacao(pedido);
		if (valido && proximo != null) {
			proximo.validar(pedido);
		}
	}

	protected abstract boolean executarValidacao(Pedido pedido);
}
