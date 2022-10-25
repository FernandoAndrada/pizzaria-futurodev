package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.entity.Pedido;

import java.util.List;

public interface PedidoService extends DefaultCrud<Pedido>{

   Pedido fecharConta(Long idPedido);
}
