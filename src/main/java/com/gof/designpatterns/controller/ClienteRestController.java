package com.gof.designpatterns.controller;

import com.gof.designpatterns.model.Cliente;
import com.gof.designpatterns.model.Pedido;
import com.gof.designpatterns.model.Prato;
import com.gof.designpatterns.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {
    @Autowired
    private ServiceImpl serviceImpl;

    @GetMapping
    @Operation(summary = "Conferir todos os pedidos", method = "GET")
    public ResponseEntity<Iterable<Pedido>> conferirPedidos() {
        return ResponseEntity.ok(serviceImpl.conferirPedidos());
    }

    @GetMapping("/{numPedido}")
    @Operation(summary = "Conferir pedidos feitos", method = "GET")
    public ResponseEntity<Pedido> conferirPedido(@PathVariable Long numPedido) {
        return ResponseEntity.ok(serviceImpl.conferirPedidoPeloId(numPedido));
    }

    @GetMapping("/")
    @Operation(summary = "Conferir o cardápio com todos os pratos", method = "GET")
    public ResponseEntity<Iterable<Prato>> conferirPratos() {
        return ResponseEntity.ok(serviceImpl.conferirPratos());
    }

    @PostMapping
    @Operation(summary = "Realizar o seu pedido", method = "PUT")
    public ResponseEntity<Void> fazerPedido(String nome, String nomePedido) {
        serviceImpl.fazerPedido(nome, nomePedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{numPedido}")
    @Operation(summary = "Realizar pagamento do seu pedido", method = "DELETE")
    public ResponseEntity<Void> pagarPedido(Long numPedido) {
        serviceImpl.pagarPedido(numPedido);
        return ResponseEntity.ok().build();
    }
}
