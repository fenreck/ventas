package com.ventas.demo.service;

import com.ventas.demo.model.Cliente;
import com.ventas.demo.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Optional<Cliente> encontrarPorId(Integer id) {

        return clienteRepo.findById(id);
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepo.deleteById(id);
    }
}
