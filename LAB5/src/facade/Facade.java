package facade;

import controladores.ControleGeral;
import easyaccept.EasyAccept;

/**
 * Representa uma fachada que oferece métodos simples e de uso geral do usuário. 
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class Facade {
	
	/**
	* Objeto ControleGeral.
	*/
	private ControleGeral c;
	
	/**
	* Constrói uma facade.
	*/
	public Facade() {
		this.c = new  ControleGeral();
	}
	
	/**
	* Adiciona um novo cliente. A partir do cpf, nome, email e localizacao.
	* 
	* @param cpf, o cpf do cliente
	* @param nome, o nome do cliente
	* @param email, o email do cliente
	* @param localizacao, a localizacao do cliente
	* @return cpf
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return c.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	* Retorna a uma String que representa um cliente com o cpf passado como parâmetro.
	* A representação segue o formato “nome - localizacao - email”.
	* 
	* @param cpf, o cpf do cliente
	* @return a representação em String do cliente
	*/
	public String exibeCliente(String cpf) {
		return c.exibeCliente(cpf);
	}
	
	/**
	* Retorna a uma String que representa os cliente registrados.
	* A representação segue o formato: “nome - localizacao - email | ... | nome - localizacao - email”.
	* 
	* @return a representação em String dos clientes registrados.
	*/
	public String exibeClientes() {
		return c.exibeClientes();
	}
	
	/**
	* Edita um cliente. A partir do cpf, do atributo que deseja editar e o novo valor que tera
	* o atributo editado.
	* 
	* @param cpf, o cpf do cliente
	* @param atributo, o atributo do cliente a ser editado
	* @param novoValor, o valor que tera o atributo editado
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		c.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	* Remove um cliente. A partir do cpf.
	* 
	* @param cpf, o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		c.removeCliente(cpf);
	}
	
	/**
	* Adiciona um novo fornecedor. A partir do nome, email e telefone.
	* 
	* @param nome, o nome do fornecedor
	* @param email, o email do fornecedor
	* @param telefone, o telefone do fornecedor
	* @return nome
	*/
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return c.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	* Retorna a uma String que representa um fornecedor, com o nome passado como parâmetro.
	* A representação segue o formato: “nome - email - telefone”.
	* 
	* @param nome, o nome do fornecedor
	* @return a representação em String do fornecedor.
	*/
	public String exibeFornecedor(String nome) {
		return c.exibeFornecedor(nome);
	}
	
	/**
	* Retorna a uma String que representa os fornecedores registrados.
	* A representação segue o formato: “nome - email - telefone | ... | nome - email - telefone”.
	* 
	* @return a representação em String dos fornecedores.
	*/
	public String exibeFornecedores() {
		return c.exibeFornecedores();
	}
	
	/**
	* Edita um fornecedor. A partir do nome, do atributo que deseja editar e o novo valor
	* que tera o atributo editado.
	* 
	* @param nome, o nome do fornecedor
	* @param atributo, o atributo do fornecedor a ser editado
	* @param novoValor, o valor que tera o atributo editado
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		c.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	* Remove um fornecedor. A partir do nome.
	* 
	* @param nome, o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		c.removeFornecedor(nome);
	}
	
	/**
	* Adiciona um novo produto de um fornecedor. A partir do fornecedor, nome, descricao e preco.

	* @param fornecedor, o nome do fornecedor
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param preco, o preco do produto
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		c.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	* Retorna a uma String que representa um produto de um fornecedor, com o nome, descricao e fornecedor
	* passado como parâmetro.
	* A representação segue o formato: “nome - descricao - R$#,##”.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	* @return a representação em String do produto
	*/
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return c.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Retorna a uma String que representa os produtos de um fornecedor, com o fornecedor passado como parâmetro.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @param fornecedor, o nome do fornecedor
	* @return a representação em String dos produtos.
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		return c.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	* Retorna a uma String que representa os produtos de todos os fornecedores.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @return a representação em String dos produtos dos fornecedores.
	*/
	public String exibeProdutos() {
		return c.exibeProdutos();
	}
	
	/**
	* Edita o preco de um produto de um fornecedor. A partir do nome, descricao, fornecedor e o novo preco.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	* @param novoPreco, o valor do novo preco
	*/
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		c.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	/**
	* Remove um produto de um fornecedor. A partir do nome, descricao e fornecedor.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		c.removeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Adiciona um combo de produtos a um fornecedor. A partir do fornecdeor, nome, descricao, fator e produtos.
	* 
	* @param fornecedor, o nome do fornecedor
	* @param nome, o nome do combo
	* @param descricao, a descricao do combo
	* @param fator, o fator do combo
	* @param produtos, os produtos do combo
	*/
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		c.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	/**
	* Adiciona um combo de produtos a um fornecedor. A partir do fornecdeor, nome, descricao, fator e produtos.
	* 
	* @param nome, o nome do combo
	* @param descricao, a descricao do combo
	* @param fornecedor, o nome do fornecedor
	* @param novoFator, o novo fator do combo
	*/
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		c.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	/**
	* Adiciona uma nova compra de um cliente com um fornecedor em sua conta. A partir do cpf, fornecedor,
	* data, nome_prod, desc_prod.
	* 
	* @param cpf, cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @param data, a data da compra
	* @param nome_prod, o nome do produto
	* @param desc_prod, a descricao do produto 
	*/
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		c.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod);
	}
	
	/**
	* Retorna a uma String que representa o debito de um cliente com um fornecedor passado como parâmetro.
	* A representação segue o formato: “#.##”.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @return a representação em String do debito do cliente com o fornecedor
	*/
	public String getDebito(String cpf, String fornecedor) {
		return c.getDebito(cpf, fornecedor);
	}
	
	/**
	* Retorna a uma String que representa as conta de um cliente com um fornecedor passado como parâmetro.
	* A representação segue o formato: 
	* “Cliente: nome_cliente | fornecedor | produto - data | ... | produto - data”.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @return a representação em String das conta de um cliente com um fornecedor
	*/
	public String exibeContas(String cpf, String fornecedor) {
		return c.exibeContas(cpf, fornecedor);
	}
	
	/**
	* Retorna a uma String que representa as compras de um cliente passado como parâmetro.
	* A representação segue o formato: 
	* “Cliente: nome_cliente | fornecedor | produto - data | ... | produto - data | ... | fornecedor | produto - data | ... | produto - data”.
	* 
	* @param cpf, o cpf do cliente
	* @return a representação em String das contas de um cliente com os fornecedores
	*/
	public String exibeContasClientes(String cpf) {
		return c.exibeContasClientes(cpf);
	}
	
	/**
	* Realiza o pagamento do debito de um cliente com um fornecedor, passados como parâmetro.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o fornecedor
	*/
	public void realizaPagamento(String cpf, String fornecedor) {
		c.realizaPagamento(cpf, fornecedor);
	}
	
	/**
	* Seta o criterio de ordenacao do sistema. Se o campo criterio não estiver nulo ou vazio e for valido.
	* 
	* @param criterio, o criterio de ordenacao.
	*/
	public void ordenaPor(String criterio) {
		c.ordenaPor(criterio);
	}
	
	/**
	* Retorna a uma String que representa as compras registradas no sitema. Pode ser ordenada pelo cliente ou fornecedor.
	* A representação ordenada pelo cliente segue o formato: 
	* “nome_cliente, fornecedor, descricao do produto, data | ... | nome_cliente, fornecedor, descricao do produto, data”.
	* A representação ordenada pelo fornecedor segue o formato: 
	* “fornecedor, nome_cliente, descricao do produto, data | ... | fornecedor, nome_cliente, descricao do produto, data”.
	* 
	* @return a representação em String de todas as compras
	*/
	public String listarCompras() {
		return c.listarCompras();
	}
	
	public static void main(String[] args) {
		args = new String[] {"facade.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt", "acceptance_test/use_case_6.txt", "acceptance_test/use_case_7.txt", "acceptance_test/use_case_8.txt"};
		EasyAccept.main(args);

	}
}