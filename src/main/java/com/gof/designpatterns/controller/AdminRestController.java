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
@RequestMapping("admin")
public class AdminRestController {
    @Autowired
    private ServiceImpl serviceImplB;

    @DeleteMapping("/{numPedido}")
    @Operation(summary = "Cancelar pedido de um cliente", method = "DELETE")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long numPedido) {
        serviceImplB.cancelarPedido(numPedido);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Operation(summary = "Adicionar novo prato ao cardápio", method = "PUT")
    public ResponseEntity<Void> adicionarPrato(@RequestBody Prato prato) {
        serviceImplB.adicionarPrato(prato);
        return ResponseEntity.ok().build();
    }
}
