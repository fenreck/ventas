package com.ventas.demo.service;

import com.ventas.demo.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

   List<Cliente> findAll(); //recibe lista

    Optional<Cliente> encontrarPorId (Integer id);

    Cliente crear(Cliente cliente); // recibe objeto cliente

    Cliente actualizar(Cliente cliente);

      void eliminar(Integer id);

}
