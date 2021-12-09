package br.com.improving.carrinho;
/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {
	
	 /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
	
	private Long codigo;
    private String descricao;
	
	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	 
	public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}