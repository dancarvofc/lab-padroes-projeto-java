package one.digitalinnovation.gof.chain;

public class ValidadorClienteAtivoHandler extends ValidadorPedidoHandler {

	@Override
	protected boolean executarValidacao(Pedido pedido) {
		if (!pedido.isClienteAtivo()) {
			pedido.reprovar("Cliente inativo.");
			return false;
		}
		return true;
	}
}
