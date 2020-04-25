package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes") //Faz com que tudo nesse controlador responda para '/clientes'
public class ClienteController {
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@GetMapping
		public List<Cliente> listar() {
			return clienteRepository.findAll();
		}
		
//		@GetMapping("/clientes/{listarPorNome}")
//		public List<Cliente> listarPorNome(@PathVariable String nome ) {
//			return clienteRepository.findByNomeContaining("");
//		}
		
		
//		Método para buscar o cliente por ID. E caso não o encontre, devolve o código 404. 
		@GetMapping("/{clienteId}")
		public ResponseEntity<Cliente>buscar(@PathVariable Long clienteId){
			Optional<Cliente> cliente = clienteRepository.findById(clienteId);
			
			if (cliente.isPresent()) {
				return ResponseEntity.ok(cliente.get());
			}
			
			return ResponseEntity.notFound().build();
		}
	
}
