package com.curso.mudi.controller;

import com.curso.mudi.dto.RequisicaoPedido;
import com.curso.mudi.model.Pedido;
import com.curso.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido (@Valid RequisicaoPedido requisicaoPedido, BindingResult result){

        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicaoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/formulario";
    }


}
