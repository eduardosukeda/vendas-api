package com.jepescados.vendasapi.rest.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jepescados.vendasapi.model.entity.Categoria;
import com.jepescados.vendasapi.model.entity.Funcionario;
import com.jepescados.vendasapi.model.entity.Imagem;
import com.jepescados.vendasapi.model.entity.Produto;
import com.jepescados.vendasapi.model.repository.CategoriaRepository;

public class ProdutoDto {

	private Integer id;
	private String nome;
	private String descricao;
	private Double peso;
	private Double preco;
	private Boolean promocao;
	private Boolean maisVendidos;
	private Double quantidadeMinimaVenda;
	private Double quantidadeEstoque;
	private Categoria categoria;
	private List<Imagem> imagens;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAlteracao;
	
	public ProdutoDto(Produto prod) {
		
		this.id = prod.getId();
		this.nome = prod.getNome();
		this.descricao = prod.getDescricao();
		this.peso = prod.getPeso();
		this.preco = prod.getPreco();
		this.promocao = prod.isPromocao();
		this.maisVendidos = prod.isMaisVendidos();
		this.quantidadeMinimaVenda = prod.getQuantidadeMinimaVenda();
		this.quantidadeEstoque = prod.getQuantidadeEstoque();
		this.categoria = prod.getCategoria();
		this.imagens = prod.getImagens();
		
		this.dataCriacao = prod.getDataCriacao();
		this.dataAlteracao = prod.getDataAlteracao();
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getPreco() {
		return preco;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public Boolean getMaisVendidos() {
		return maisVendidos;
	}

	public Double getQuantidadeMinimaVenda() {
		return quantidadeMinimaVenda;
	}

	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	
	public static ProdutoDto converter(Produto produto) {
		return new ProdutoDto(produto);
	}
}
