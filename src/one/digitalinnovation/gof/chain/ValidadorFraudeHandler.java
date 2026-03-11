package one.digitalinnovation.gof.chain;

public class ValidadorFraudeHandler extends ValidadorPedidoHandler {

	@Override
	protected boolean executarValidacao(Pedido pedido) {
		if (pedido.isSuspeitaFraude()) {
			pedido.reprovar("Pedido bloqueado por suspeita de fraude.");
			return false;
		}
		return true;
	}
}
