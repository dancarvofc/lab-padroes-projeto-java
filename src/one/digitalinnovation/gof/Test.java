package one.digitalinnovation.gof;

import one.digitalinnovation.gof.chain.Pedido;
import one.digitalinnovation.gof.chain.ProcessadorPedido;
import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;

public class Test {

	public static void main(String[] args) {
		
		// Singleton
		
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		// Strategy
		
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento normal = new ComportamentoNormal();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		robo.mover();
		
		// Facade
		
		Facade facade = new Facade();
		facade.migrarCliente("Venilton", "14801788");
		
		// Chain of Responsibility
		ProcessadorPedido processadorPedido = new ProcessadorPedido(1000.0);
		
		Pedido pedidoAprovado = new Pedido("Joana", 850.0, true, false);
		Pedido pedidoClienteInativo = new Pedido("Mario", 500.0, false, false);
		Pedido pedidoFraude = new Pedido("Carla", 300.0, true, true);
		Pedido pedidoAcimaDoLimite = new Pedido("Renato", 5000.0, true, false);
		
		processarPedido(processadorPedido, pedidoAprovado);
		processarPedido(processadorPedido, pedidoClienteInativo);
		processarPedido(processadorPedido, pedidoFraude);
		processarPedido(processadorPedido, pedidoAcimaDoLimite);
	}

	private static void processarPedido(ProcessadorPedido processadorPedido, Pedido pedido) {
		processadorPedido.processar(pedido);
		System.out.println("Pedido cliente: " + pedido.getCliente());
		System.out.println("Aprovado: " + pedido.isAprovado());
		if (!pedido.isAprovado()) {
			System.out.println("Motivo: " + pedido.getMotivoReprovacao());
		}
		System.out.println("---");
	}
}
