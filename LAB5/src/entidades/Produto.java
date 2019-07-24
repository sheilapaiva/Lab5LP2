package entidades;

import java.text.DecimalFormat;

/**
 * Representacao de um Produto. Um produto é representado por um nome, descricao e preco.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Produto {
	
	/**
	* Nome do produto.
	*/
	private String nome;
	/**
	* Descricao do produto.
	*/
	private String descricao;
	/**
	* Preco do produto.
	*/
	private double preco;
	/**
	* Tipo do produto.
	*/
	private String tipo;
	/**
	* Preco total do combo.
	*/
	private double precoTotal;
	
	/**
	* Constroi um produto, a partir do seu nome, descricao e preco e tipo.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param preco, o preco do produto
	* @param tipo, o tipo do produto
	*/
	public Produto(String nome, String descricao, double preco, String tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	/**
	* Constroi um produto, a partir do seu nome, descricao e preco.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param preco, o preco do produto
	* @param tipo, o tipo do produto
	* @param precoTotal, o preco total do combo
	*/
	public Produto(String nome, String descricao, double preco, String tipo, double precoTotal) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.precoTotal = precoTotal;
	}
	
	/**
	* Retorna uma String que representa o nome do produto.
	* 
	* @return a uma String que representa o nome.
	* */
	public String getNome() {
		return this.nome;
	}

	/**
	* Retorna uma String que representa a descricao do produto.
	* 
	* @return a uma String que representa a descricao.
	* */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	* Retorna um double que representa o preco do produto.
	* 
	* @return a um double que representa o preco.
	* */
	public double getPreco() {
		return this.preco;
	}

	/**
	* Seta um double que representa o preco do produto.
	* 
	* @param preco, o preco do produto
	* */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	* Retorna uma String que representa o tipo do produto.
	* 
	* @return uma String que representa o tipo.
	* */
	public String getTipo() {
		return this.tipo;
	}
	
	/**
	* Retorna um double que representa o preco total do combo.
	* 
	* @return a um double que representa o preco total.
	* */
	public double getPrecoTotal() {
		return this.precoTotal;
	}

	/**
	* Retorna a um inteiro referente uma representação númerica do objeto.
	* 
	* @return a um valor inteiro que representa o objeto.
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Produto a ser 
	* criado com os outros Produtos já existentes, um produto é igual ao outro se as 
	* seus nomes e descricoes são iguais.
	* 
	* @return a um boolean.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	* Retorna a String que representa um produto. 
	* A representação segue o formato “nome - descricao - R$#,##”.
	* 
	* @return a representação em String do nome, descricao e preco de um produto.
	*/
	@Override
	public String toString() {
		DecimalFormat p = new DecimalFormat("0.00");
		return this.nome + " - " + this.descricao + " - R$" + p.format(this.preco);
	}
}
