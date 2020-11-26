package com.jepescados.vendasapi.rest.form;

import java.time.LocalDateTime;
import java.util.List;

import com.jepescados.vendasapi.model.entity.Categoria;
import com.jepescados.vendasapi.model.entity.Imagem;
import com.jepescados.vendasapi.model.entity.Produto;
import com.jepescados.vendasapi.model.repository.CategoriaRepository;

public class ProdutoForm {

	private String nome;
	private String descricao;
	private Boolean maisVendidos;
	private Double peso;
	private Double preco;
	private Boolean promocao;
	private Double quantidadeMinimaVenda;
	private Double quantidadeEstoque;
	private Integer idCategoria;
	private Imagem imagemPrincipal;
	private List<Imagem> maisImagens;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAlteracao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Boolean getMaisVendidos() {
		return maisVendidos;
	}
	
	public void setMaisVendidos(Boolean maisVendidos) {
		this.maisVendidos = maisVendidos;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Boolean getPromocao() {
		return promocao;
	}
	
	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}
	
	public Double getQuantidadeMinimaVenda() {
		return quantidadeMinimaVenda;
	}
	
	public void setQuantidadeMinimaVenda(Double quantidadeMinimaVenda) {
		this.quantidadeMinimaVenda = quantidadeMinimaVenda;
	}
	
	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(Double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Imagem getImagemPrincipal() {
		return imagemPrincipal;
	}
	
	public void setImagemPrincipal(Imagem imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}
	
	public List<Imagem> getMaisImagens() {
		return maisImagens;
	}
	
	public void setMaisImagens(List<Imagem> maisImagens) {
		this.maisImagens = maisImagens;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Produto converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		return new Produto(
				nome,
				descricao,
				peso,
				preco,
				promocao,
				maisVendidos,
				quantidadeMinimaVenda,
				quantidadeEstoque,
				categoria,
				dataCriacao,
				dataAlteracao);
	}
	
}
