package entidades;

import java.util.HashMap;

/**
 * Representacao de um Fornecedor. Um Fornecedor é representado por um, nome, email e telefone.
 * Um fornecedor possui um mapa de produtos.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class Fornecedor {

	/**
	* Nome do fornecedor.
	*/
	private String nome;
	/**
	* Email do fornecedor.
	*/
	private String email;
	/**
	* Telefone do fornecedor.
	*/
	private String telefone;
	/**
	* Mapa de produtos do fornecedor.
	*/
	private HashMap<String, Produto> mapProdutos;
	
	/**
	* Constroi um fornecedor, a partir do seu, nome, email e telefone.
	* 
	* @param nome, o nome do fornecedor
	* @param email, o email do fornecedor
	* @param telefone, o telefone do fornecedor
	*/
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mapProdutos = new HashMap<>();
	}

	/**
	* Retorna uma String que representa o nome do fornecedor.
	* 
	* @return a uma String que representa o nome.
	* */
	public String getNome() {
		return nome;
	}
	
	/**
	* Retorna uma String que representa o email do fornecedor.
	* 
	* @return a uma String que representa o email.
	* */
	public String getEmail() {
		return email;
	}
	
	/**
	* Seta uma String que representa o email do fornecedor.
	* 
	* @param email, o email do fornecedor.
	* */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	* Retorna uma String que representa o telefone do fornecedor.
	* 
	* @return a uma String que representa o telefone.
	* */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	* Seta uma String que representa o telefone do fornecedor.
	* 
	* @param telefone, o telefone do fornecedor.
	* */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	* Retorna um mapa que representa o mapa de produtos do fornecedor.
	* 
	* @return a uma String que representa o mapa de produtos.
	* */
	public HashMap<String, Produto> getMapProdutos() {
		return mapProdutos;
	}

	/**
	* Seta uma String que representa o mapa de produtos do fornecedor.
	* 
	* @param mapProdutos, o mapa de produtos do fornecedor.
	* */
	public void setMapProdutos(HashMap<String, Produto> mapProdutos) {
		this.mapProdutos = mapProdutos;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Fornecedor a ser 
	* criado com os outros Fornecedores já existentes, um fornecedor é igual ao outro se as 
	* seus nomes são iguais.
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	* Retorna a String que representa um Fornecedor. 
	* A representação segue o formato “nome - email - telefone”.
	* 
	* @return a representação em String do nome, email e telefone de um fornecedor.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
}
