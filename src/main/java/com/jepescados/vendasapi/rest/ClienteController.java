package com.jepescados.vendasapi.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jepescados.vendasapi.model.entity.Cliente;
import com.jepescados.vendasapi.model.repository.ClienteRepository;
import com.jepescados.vendasapi.rest.dto.ClienteDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

	
	@Autowired
	ClienteRepository repository;
	
	@GetMapping
	public List<ClienteDto> listar() {
		List<Cliente> clientes = repository.findAll();
		return ClienteDto.converter(clientes);
	}
	
	@GetMapping("{id}")
	public Cliente listarPorId(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("{id}/usuario")
	public Cliente listarClientePorUsuarioId(@PathVariable Integer id) {
		return repository.findByUsuarioId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(String clienteJson) {
		
		ObjectMapper mapper = new ObjectMapper();
		Cliente cliente = new Cliente();		
		
		try{
			cliente = mapper.readValue(clienteJson, Cliente.class);
        }catch (IOException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }		 		
		return repository.save(cliente);
	}
	
	
	/*	
	@PutMapping("{id}/foto")
	public byte[] adicionarFoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo) {
		 Optional<Funcionario> funcionario = repository.findById(id);
		return funcionario.map( c -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setFoto(bytes);
                repository.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElse(null);
	}
	*/
	
	
}
