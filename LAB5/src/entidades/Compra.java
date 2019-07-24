package entidades;

/**
 * Representacao de uma compra. Um comprae é representada por uma data, nome e descricao do produto e preco.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class Compra {
	
	/**
	* Data da compra.
	*/
	private String data;
	/**
	* Nome do produto.
	*/
	private String nomeProduto;
	/**
	* Descricao do produto.
	*/
	private String descricaoProduto;
	/**
	* Preco da compra.
	*/
	private double preco;
	
	/**
	* Constroi uma compra, a partir da data, idProduto e preco.
	* 
	* @param data, a data da compra
	* @param idProduto, a identificacao da compra
	* @param preco, preco da compra
	*/
	public Compra(String data, String nomeProduto, String descricaoProduto, double preco) {
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.preco = preco;
	}

	/**
	* Retorna uma String que representa a data da compra.
	* 
	* @return a uma String que representa a data.
	* */
	public String getData() {
		return data;
	}

	/**
	* Retorna uma String que representa o nome do produto da compra.
	* 
	* @return a uma String que representa a identificacao.
	* */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	* Retorna uma String que representa a descricao do produto da compra.
	* 
	* @return a uma String que representa a identificacao.
	* */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	
	/**
	* Retorna uma double que representa o preco da compra.
	* 
	* @return a uma double que representa o preco.
	* */
	public double getPreco() {
		return preco;
	}

	/**
	* Retorna a String que representa uma compra.
	* A representação segue o formato “idProduto - data”.
	* 
	* @return a representação em String da identificacao da compra e a data.
	*/
	@Override
	public String toString() {
		String[] datas = this.data.split("/");
		return this.nomeProduto + " - " + datas[0] + "-" + datas[1] + "-" + datas[2];
	}
}
