package com.jepescados.vendasapi.exception;

public class DepartamentoCadastradoException extends RuntimeException {

	public DepartamentoCadastradoException(String nome) {
		super("Departamento " + nome + " já existe");
	}
}
