package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

//		Método para buscar o cliente pelo nome. E caso não o encontre, devolve o código 404. 
		@GetMapping("/searchByName/{nome}")
		public ResponseEntity<Cliente>listarPorNome(@PathVariable String nome) {
			 Optional<Cliente> cliente = clienteRepository.findByNomeContaining(nome);			 
			 if(cliente.isPresent()) {
				 return ResponseEntity.ok(cliente.get());
			 }
			 return ResponseEntity.notFound().build();
		}
		
		
//		Método para buscar o cliente por ID. E caso não o encontre, devolve o código 404. 
		@GetMapping("/searchById/{clienteId}")
		public ResponseEntity<Cliente>buscar(@PathVariable Long clienteId){
			Optional<Cliente> cliente = clienteRepository.findById(clienteId);			
			if (cliente.isPresent()) {
				return ResponseEntity.ok(cliente.get());
			}			
			return ResponseEntity.notFound().build();
		}
		
//		Adiciona um cliente ao banco e retorna 		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Cliente adicionar(@Valid @RequestBody Cliente cliente){
			return clienteRepository.save(cliente);
		}

		
//		Atualizar um cliente pelo Id		
		@PutMapping("/{clienteId}")
		public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){			
			if(!clienteRepository.existsById(clienteId)) {
				return ResponseEntity.notFound().build();
			}
			else {
				cliente.setId(clienteId);
				cliente = clienteRepository.save(cliente);
				return ResponseEntity.ok(cliente);
			}
		}

//		Deleta um cliente pelo Id
		@DeleteMapping("/{clienteId}")
		public ResponseEntity<Void> remover(@PathVariable Long clienteId){					
			if(!clienteRepository.existsById(clienteId)) {
				return ResponseEntity.notFound().build();
			}
			else {
				clienteRepository.deleteById(clienteId);
				return ResponseEntity.noContent().build();
			}			
		}
		
}




















