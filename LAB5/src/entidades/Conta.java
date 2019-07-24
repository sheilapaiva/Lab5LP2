package entidades;

import java.util.ArrayList;

/**
 * Representacao de uma Conta. Uma conta é  cliente é representado por cliente, um fornecedor
 * e uma lista de compras.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Conta {
	
	/**
	* Nome do cliente.
	*/
	private Cliente cliente;
	/**
	* Nome do fornecedor.
	*/
	private Fornecedor fornecedor;
	/**
	* Lista de comprar. 
	*/
	private ArrayList<Compra> compras;

	/**
	* Constroi uma conta, a partir do nome do cliente e nome do fornecedor.
	* 
	* @param cliente, o nome do cliente
	* @param fornecedor, o nome do fornecedor
	*/
	public Conta(Cliente cliente, Fornecedor fornecedor) {
		this.cliente = cliente;
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<>();
	}

	/**
	* Retorna uma String que representa o nome do cliente da conta.
	* 
	* @return a uma String que representa o nome do cliente
	* */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	* Retorna uma String que representa o fornecedor da conta.
	* 
	* @return a uma String que representa o fornecedor
	* */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	* Retorna a uma lista que representa a lista de compras.
	* 
	* @return a uma String que representa a lista de compras.
	* */
	public ArrayList<Compra> getCompras() {
		return compras;
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
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		return result;
	}
	

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Conta a ser 
	* criado com os outras Contas já existentes, um conta é igual a outra se as 
	* seus cliente e fornecedores são iguais.
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
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		return true;
	}
}
