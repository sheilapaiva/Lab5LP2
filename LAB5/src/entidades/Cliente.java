package entidades;

/**
 * Representacao de um Cliente. Um cliente é representado por um cpf, nome, email e localizacao.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class Cliente{
	
	/**
	* Cpf do cliente.
	*/
	private String cpf;
	/**
	* Nome do cliente.
	*/
	private String nome;
	/**
	* Email do cliente.
	*/
	private String email;
	/**
	* Localizacao do cliente.
	*/
	private String localizacao;
	
	/**
	* Constroi um cliente, a partir do seu cpf, nome, email e localizacao.
	* 
	* @param cpf, o cpf do cliente
	* @param nome, o nome do cliente
	* @param email, o email do cliente
	* @param localizacao, a localizacao do cliente
	*/
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	/**
	* Retorna uma String que representa o cpf do cliente.
	* 
	* @return a uma String que representa o cpf.
	* */
	public String getCpf() {
		return cpf;
	}

	/**
	* Retorna uma String que representa o nome do cliente.
	* 
	* @return a uma String que representa o nome.
	* */
	public String getNome() {
		return nome;
	}

	/**
	* Seta uma String que representa o nome do cliente.
	* 
	* @param nome, o nome do cliente.
	* */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	* Retorna uma String que representa o email do cliente.
	* 
	* @return a uma String que representa o email.
	* */
	public String getEmail() {
		return email;
	}

	/**
	* Seta uma String que representa o email do cliente.
	* 
	* @param email, o email do cliente.
	* */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Retorna uma String que representa a localizacao do cliente.
	* 
	* @return a uma String que representa a localizacao.
	* */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	* Seta uma String que representa a localizacao do cliente.
	* 
	* @param localizacao, a localizacao do cliente.
	* */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Cliente a ser 
	* criado com os outros Clientes já existentes, um cliente é igual ao outro se as 
	* seus cpfs são iguais.
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	* Retorna a String que representa um cliente. 
	* A representação segue o formato “nome - localizacao - email”.
	* 
	* @return a representação em String do nome, localizacao e email de um cliente.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}
	
}
