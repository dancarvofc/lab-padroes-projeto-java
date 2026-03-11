package one.digitalinnovation.gof.chain;

public class AprovadorFinalHandler extends ValidadorPedidoHandler {

	@Override
	protected boolean executarValidacao(Pedido pedido) {
		pedido.aprovar();
		return true;
	}
}
