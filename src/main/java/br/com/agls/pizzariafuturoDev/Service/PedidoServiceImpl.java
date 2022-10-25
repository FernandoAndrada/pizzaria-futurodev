package br.com.agls.pizzariafuturoDev.Service;

import br.com.agls.pizzariafuturoDev.Model.Repository.PedidoRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.MesaService;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.PedidoService;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import br.com.agls.pizzariafuturoDev.entity.Pedido;
import br.com.agls.pizzariafuturoDev.entity.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaService mesaService;

    @Override
    public Pedido salvar(Pedido pedido) {

        Pedido pedidoSalvo = this.pedidoRepository.save(pedido);

        if(pedidoSalvo.getId() != null) {
            Mesa mesaReservada = this.mesaService.buscar(pedidoSalvo.getMesa().getId());
            mesaReservada.setStatus(false);
            this.mesaService.atualizar(mesaReservada);
        }

        return pedidoSalvo;
    }

    @Override
    public Pedido atualizar(Pedido pedido) {
        Pedido pedidoPesquisado = buscar(pedido.getId());
        pedidoPesquisado.setPedidoPrato(pedido.getPedidoPrato());

        return this.pedidoRepository.save(pedido);
    }

    @Override
    public Pedido buscar(Long id) {
        return this.pedidoRepository
                .findById(id)
                .orElseThrow(() ->{
                    throw new EntityExistsException("Não foi possível encontrar um pedido com id: "+ id);
                });
    }

    @Override
    public List<Pedido> listar() {

        return this.pedidoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }


    @Override
    public Pedido fecharConta(Long idPedido) {
        Pedido pedidoFechado = null;
        Pedido pedidoPesquisado = buscar(idPedido);
        Double valorConta = calcularValorConta(pedidoPesquisado.getPedidoPrato());
        pedidoPesquisado.setValorTotal(valorConta);

        //TODO Implementar pagamento
        pedidoPesquisado.setIsPago(true);

        try {
            pedidoFechado = this.pedidoRepository.save(pedidoPesquisado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        atualizarMesa(pedidoPesquisado.getMesa());
        return pedidoFechado;
    }



    private Double calcularValorConta(List<Prato> pratosPedidos) {
        Double total = 0.0;

        if(pratosPedidos != null || ! pratosPedidos.isEmpty()){
            for (Prato prato: pratosPedidos ){
                total += prato.getValor();
            }
        }
        return total;
    }
    private void atualizarMesa(Mesa mesa) {
        Mesa mesaPesquisada = this.mesaService.buscar((mesa.getId()));
        mesaPesquisada.setStatus(true);
        this.mesaService.atualizar(mesaPesquisada);
    }
}
