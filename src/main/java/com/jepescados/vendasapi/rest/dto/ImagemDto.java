package com.jepescados.vendasapi.rest.dto;

public class ImagemDto {

	private Integer id;
	private byte[] imagem;
	private Integer ordem;
	
	public ImagemDto(Integer id, byte[] imagem, Integer ordem) {
		this.id = id;
		this.imagem = imagem;
		this.ordem = ordem;
	}

	public Integer getId() {
		return id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public Integer getOrdem() {
		return ordem;
	}
	
	
	
	
}
