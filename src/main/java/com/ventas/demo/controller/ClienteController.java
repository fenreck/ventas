package com.ventas.demo.controller;

import com.ventas.demo.model.Cliente;
import com.ventas.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
            @Autowired
            private ClienteService clienteService;

            @GetMapping("/clientes")
            public ResponseEntity <List<Cliente>>  buscarTodosClientes() {
                return ResponseEntity.ok( clienteService.findAll() );
            }

            @GetMapping ("/clientes/{id}")
            public ResponseEntity<Cliente>  encontrarCliente( @PathVariable("id") Integer idCliente ){

                return clienteService.encontrarPorId(idCliente)
                        .map(ResponseEntity::ok)  // si el idCliente es correcto el response es OK
                        .orElseGet(() -> ResponseEntity.notFound().build() ) ;  // mandará error 404


            }

            @PostMapping ("/creaCliente")  // por que se van a insertar valores que puedan ser consumidas de otra API
            public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente ){  // RequestBody para que venga el contenido del objeto en el request

                return new ResponseEntity<>( clienteService.crear(cliente), HttpStatus.CREATED ) ; //https.Created para que retorne 201 de creado en la respuesta
            }

        @PutMapping ("/actualizaCliente")
         public ResponseEntity<Cliente> actualizaCliente(@RequestBody Cliente cliente ){  // RequestBody para que venga el contenido del objeto en el request

                return clienteService.encontrarPorId( cliente.getIdCliente() )
                        .map( c -> ResponseEntity.ok( clienteService.actualizar( cliente  ) ) )  // c es el cliente encontrado, si el idCliente es correcto el response es OK y se ejecuta metodo actualizar
                        .orElseGet(() -> ResponseEntity.notFound().build() ) ;  // mandará error 404 no encontro cliente a actualizar

         }

        @DeleteMapping ("/eliminaCliente/{id}")
        public ResponseEntity<Cliente> elimnarCliente( @PathVariable("id") Integer idCliente ){  // RequestBody para que venga el contenido del objeto en el request

        return clienteService.encontrarPorId( idCliente )
                .map( c -> {
                            clienteService.eliminar( idCliente  ) ; // se elimina cliente
                            return ResponseEntity.ok(c);            // se retorna response con el objeto Cliente que fue eliminado en el response
                            }  )  // c es el cliente encontrado, si el idCliente es correcto el response es OK y se ejecuta el metodo eliminar
                .orElseGet(() -> ResponseEntity.notFound().build() ) ;  // mandará error 404 no encontro cliente a eliminar

        }



}
