package com.gof.designpatterns.service.impl;

import com.gof.designpatterns.model.Cliente;
import com.gof.designpatterns.model.Pedido;
import com.gof.designpatterns.model.Prato;
import com.gof.designpatterns.repository.ClienteRepository;
import com.gof.designpatterns.repository.PedidoRepository;
import com.gof.designpatterns.repository.PratoRepository;
import com.gof.designpatterns.service.AdminService;
import com.gof.designpatterns.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

import java.util.random.RandomGenerator;

@Service
public class ServiceImpl implements ClienteService, AdminService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PratoRepository pratoRepository;

    @Override
    //Cliente
    public Iterable<Pedido> conferirPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    //Cliente
    public Pedido conferirPedidoPeloId(Long numPedido) {
        Optional<Pedido> pedido = pedidoRepository.findById(numPedido);
        return pedido.get();
    }

    @Override
    //Cliente
    public Iterable<Prato> conferirPratos() {
        return pratoRepository.findAll();
    }

    @Override
    //Cliente
    public void fazerPedido(String nome, String nomePedido) {
        //Verificando se existe o prato pedido
        if (!pratoRepository.existsById(nomePedido)) {
            //Criando o prato caso nao exista para persistir o programa
            Prato prato = new Prato();
            prato.setNomePrato(nomePedido);
            prato.setPreco(19.99);
            prato.setQuantidade(1);
            pratoRepository.save(prato);
        }
        //Criando o pedido
        Pedido pedido = new Pedido();
        pedido.setPrato(procurarPrato(nomePedido));
        pedidoRepository.save(pedido);

        //Verificando se o cliente existe
        Cliente cliente = new Cliente();
        for (Cliente C:clienteRepository.findAll()) {
            //Se existir alguém com o nome fornecido, será adicionado o pedido
            if (C.getNome().equals(nome)) {
                for(Pedido P:pedidoRepository.findAll()) {
                    if (P.getPrato().getNomePrato().equals(nomePedido)) {
                        C.getPedido().add(P);
                        clienteRepository.save(C);
                        break;
                    }
                }
            } else {
                cliente.setNome(nome);
                for(Pedido P:pedidoRepository.findAll()) {
                    if (P.getPrato().getNomePrato().equals(nomePedido)) {
                        C.getPedido().add(P);
                        clienteRepository.save(C);
                        break;
                    }
                }
            }
        }
    }

    @Override
    //Cliente
    public void pagarPedido(Long numPedido) {
        pedidoRepository.deleteById(numPedido);
    }

    //Admin
    public void cancelarPedido(Long numPedido) {
        pedidoRepository.deleteById(numPedido);
    }

    //Admin
    @Override
    public void adicionarPrato(Prato prato) {
        pratoRepository.save(prato);
    }

    //Admin
    @Override
    public Iterable<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    //Admin
    public void removerCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        cliente.ifPresent(value -> clienteRepository.delete(value));
    }

    //Admin
    @Override
    public Cliente buscarClientePorPedido(Long pedidoNum) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoNum);
        Cliente clienteCerto = null;
        for (Cliente C: clienteRepository.findAll()) {
            if (C.getPedido().equals(pedido)) {
                clienteCerto = C;
            }
        }
        return clienteCerto;
    }

    public Prato procurarPrato(String nomePrato) {
        Optional<Prato> prato = pratoRepository.findById(nomePrato);
        return prato.get();
    }
}
