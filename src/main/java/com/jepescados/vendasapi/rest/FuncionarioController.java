package com.jepescados.vendasapi.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jepescados.vendasapi.model.entity.Departamento;
import com.jepescados.vendasapi.model.entity.Funcionario;
import com.jepescados.vendasapi.model.repository.FuncionarioRepository;
import com.jepescados.vendasapi.rest.dto.FuncionarioDto;
import com.jepescados.vendasapi.rest.form.ProdutoForm;
import com.jepescados.vendasapi.service.FuncionarioService;
import com.jepescados.vendasapi.service.UsuarioService;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
	
	@Autowired
	FuncionarioRepository repository;
	
	@GetMapping
	public List<FuncionarioDto> listar() {
		List<Funcionario> funcionarios = repository.findAll();
		return FuncionarioDto.converter(funcionarios);
	}
	
	@GetMapping("{id}")
	public Funcionario listarPorId(@PathVariable Integer id) {
		return service.listarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario salvar(String funcionarioJson, MultipartFile foto) {
		// FuncionarioDto test = funcionarioDto;
		return this.service.salvar(funcionarioJson, foto);
	}
	
	@PutMapping("{id}/foto")
	public byte[] adicionarFoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo) {
		return this.service.adicionarFoto(id, arquivo);
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
