package com.ventas.demo.repository;

import com.ventas.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {



}
