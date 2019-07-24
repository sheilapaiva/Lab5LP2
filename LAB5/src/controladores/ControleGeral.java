package controladores;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import comparadores.CompraComparadorConta;
import entidades.Cliente;
import entidades.Compra;
import entidades.Conta;
import entidades.Fornecedor;

/**
 * Representação de um Controle Geral, responsável por adicionar, recuperar, editar ou remover clientes,
 * fornecedores. Bem como, adicionar, recuperar, editar ou remover produtos e combos dos fornecedores. 
 * E adicionar, recuperar e exibir o debido das contas dos clientes com os fornecedores.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class ControleGeral {
	
	/**
	* Objeto de CrudCliente.
	*/
	private CrudCliente cc;
	/**
	* Objeto de CrudFornecedor.
	*/
	private CrudFornecedor cf;
	/**
	* Mapa de contas.
	*/
	private HashMap<String, Conta> mapConta;
	
	/**
	* Crterio de ordenacao.
	*/
	private String criterio;
	/**
	* Comparador de compras.
	*/
	private Comparator<Compra> comparadorCompra;
	
	/**
	* Constroi um Controle Geral.
	*/
	public ControleGeral() {
		this.cc = new CrudCliente();
		this.cf = new CrudFornecedor();
		this.mapConta = new HashMap<>();
		this.criterio = "";
		this.comparadorCompra = new CompraComparadorConta();
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
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
		return cc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	* Retorna a uma String que representa um cliente com o cpf passado como parâmetro.
	* A representação segue o formato “nome - localizacao - email”.
	* 
	* @param cpf, o cpf do cliente
	* @return a representação em String do cliente
	*/
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}
	
	/**
	* Retorna a uma String que representa os cliente registrados.
	* A representação segue o formato: “nome - localizacao - email | ... | nome - localizacao - email”.
	* 
	* @return a representação em String dos clientes registrados.
	*/
	public String exibeClientes() {
		return cc.exibeClientes();
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
		cc.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	* Remove um cliente. A partir do cpf.
	* 
	* @param cpf, o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		cc.removeCliente(cpf);
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
		return cf.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	* Retorna a uma String que representa um fornecedor, com o nome passado como parâmetro.
	* A representação segue o formato: “nome - email - telefone”.
	* 
	* @param nome, o nome do fornecedor
	* @return a representação em String do fornecedor.
	*/
	public String exibeFornecedor(String nome) {
		return cf.exibeFornecedor(nome);
	}
	
	/**
	* Retorna a uma String que representa os fornecedores registrados.
	* A representação segue o formato: “nome - email - telefone | ... | nome - email - telefone”.
	* 
	* @return a representação em String dos fornecedores.
	*/
	public String exibeFornecedores() {
		return cf.exibeFornecedores();
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
		cf.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	* Remove um fornecedor. A partir do nome.
	* 
	* @param nome, o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		cf.removeFornecedor(nome);
	}
	
	/**
	* Adiciona um novo produto de um fornecedor. A partir do fornecedor, nome, descricao e preco.

	* @param fornecedor, o nome do fornecedor
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param preco, o preco do produto
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		cf.adicionaProduto(fornecedor, nome, descricao, preco);
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
		return cf.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Retorna a uma String que representa os produtos de um fornecedor, com o fornecedor passado como parâmetro.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @param fornecedor, o nome do fornecedor
	* @return a representação em String dos produtos.
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		return cf.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	* Retorna a uma String que representa os produtos de todos os fornecedores.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @return a representação em String dos produtos dos fornecedores.
	*/
	public String exibeProdutos() {
		return cf.exibeProdutos();
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
		cf.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	/**
	* Remove um produto de um fornecedor. A partir do nome, descricao e fornecedor.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		cf.removeProduto(nome, descricao, fornecedor);
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
		cf.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
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
		cf.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	/**
	* Adiciona uma nova compra de um cliente no mapa de contas com o fornecedor. A partir do cpf, fornecedor,
	* data, nome_prod, desc_prod.
	* Se esses campos estiverem preenchidos e não nulos. E se o cliente e fornecedor existirem no sistema.
	* Usa o cpf e fornecedor como chave para o mapa.
	* 
	* @param cpf, cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @param data, a data da compra
	* @param nome_prod, o nome do produto
	* @param desc_prod, a descricao do produto 
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, campo data vazio ou nulo
	* @throws IllegalArgumentException, campo nome_prod vazio ou nulo
	* @throws IllegalArgumentException, campo cpf invalido
	* @throws IllegalArgumentException, cliente nao existe
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, campo desc_prod vazio ou nulo
	* @throws IllegalArgumentException, data invalida
	* @throws IllegalArgumentException, produto nao existe
	*/
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}else if (data == null || "".equals(data.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}else if (nome_prod == null || "".equals(nome_prod.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}else if (!this.cc.getMapClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}else if (!this.cf.getMapFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}else if (desc_prod == null || "".equals(desc_prod.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		} String[] datas = data.split("/");
		if (datas[0].length() != 2 | datas[1].length() != 2 | datas[2].length() != 4) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}else if (!this.cf.getMapFornecedores().get(fornecedor).getMapProdutos().containsKey(nome_prod + " - " + desc_prod)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}else if (!this.mapConta.containsKey(cpf + fornecedor)) {
			Cliente cc = this.cc.getMapClientes().get(cpf);
			Fornecedor f = this.cf.getMapFornecedores().get(fornecedor);
			Conta c = new Conta(cc, f);
			this.mapConta.put(cpf + fornecedor, c);
		}
		Compra a = new Compra(data, nome_prod, desc_prod, this.cf.getMapFornecedores().get(fornecedor).getMapProdutos().get(nome_prod + " - " + desc_prod).getPreco());
		this.mapConta.get(cpf + fornecedor).getCompras().add(a);	
	}
	
	/**
	* Retorna a uma String que representa o debito de um cliente com um fornecedor passado como parâmetro.
	* Se esses campos estiverem preenchidos e não nulos. E se o cliente e fornecedor existirem no sistema.
	* A representação segue o formato: “#.##”.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, campo cpf invalido
	* @throws IllegalArgumentException, cliente nao existe
	* @throws IllegalArgumentException, fornecedor nao exite
	* @throws IllegalArgumentException, cliente nao tem debito com o fornecedor
	* @return a representação em String do debito do cliente com o fornecedor
	*/
	public String getDebito(String cpf, String fornecedor) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}else if (!this.cc.getMapClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}else if (!this.cf.getMapFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}else if (!this.mapConta.containsKey(cpf + fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		double debito = 0.00;
		for (Compra a : this.mapConta.get(cpf + fornecedor).getCompras()) {
			debito += a.getPreco();
		}
		return debito + "0";
	}
	
	/**
	* Retorna a uma String que representa as conta de um cliente com um fornecedor passado como parâmetro.
	* Se esses campos estiverem preenchidos e não nulos. E se o cliente e fornecedor existirem no sistema.
	* A representação segue o formato: 
	* “Cliente: nome_cliente | fornecedor | produto - data | ... | produto - data”.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o nome do fornecedor
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, campo cpf invalido
	* @throws IllegalArgumentException, cliente nao existe
	* @throws IllegalArgumentException, fornecedor nao exite
	* @throws IllegalArgumentException, cliente nao tem debito com o fornecedor
	* @return a representação em String das conta de um cliente com um fornecedor
	*/
	public String exibeContas(String cpf, String fornecedor) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}else if (!this.cc.getMapClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}else if (!this.cf.getMapFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}else if (!this.mapConta.containsKey(cpf + fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		String conta = "Cliente: " + this.cc.getMapClientes().get(cpf).getNome() + " | " + fornecedor;
		for (Compra a : this.mapConta.get(cpf + fornecedor).getCompras()) {
			conta += " | " + a.toString();
		}
		return conta;
	}
	
	/**
	* Retorna a uma String que representa as compras de um cliente passado como parâmetro.
	* Se esse campo estiver preenchido e não nulo. E se o cliente existir no sistema e possuir alguma compra.
	* A representação segue o formato: 
	* “Cliente: nome_cliente | fornecedor | produto - data | ... | produto - data | ... | fornecedor | produto - data | ... | produto - data”.
	* 
	* @param cpf, o cpf do cliente
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo cpf invalido
	* @throws IllegalArgumentException, cliente nao existe
	* @throws IllegalArgumentException, cliente nao tem nenhuma conta
	* @return a representação em String das contas de um cliente com os fornecedores
	*/
	public String exibeContasClientes(String cpf) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}else if (!this.cc.getMapClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		List<String> f = new ArrayList<>();
 		for (Conta c : this.mapConta.values()) {
			if (this.mapConta.containsKey(cpf + c.getFornecedor().getNome())){
				if (!f.contains(c.getFornecedor().getNome())) {
					f.add(c.getFornecedor().getNome());
				}
			}
		}
 		if (f.size() == 0) {
 			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
 		}
 		Collections.sort(f, Collator.getInstance());
 		String conta = "Cliente: " + this.cc.getMapClientes().get(cpf).getNome();
 		for (String fo : f) {
 			conta += " | " + fo;
 			for (Compra a : this.mapConta.get(cpf + fo).getCompras()) {
				conta += " | " + a.toString();
			}
 		}
		return conta;
	}
	
	/**
	* Realiza o pagamento do debito de um cliente com um fornecedor, passados como parâmetro.
	* Se esses campo estiverem preenchidos e não nulo. E se o cliente e o fornecedor existirem
	* no sistema e possuir algum debito com o fornecedor.
	* 
	* @param cpf, o cpf do cliente
	* @param fornecedor, o fornecedor
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, foornecedor vazio ou nulo
	* @throws IllegalArgumentException, campo cpf invalido
	* @throws IllegalArgumentException, cliente nao existe
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, cliente nao tem nenhum debito com o fornecedor
	*/
	public void realizaPagamento(String cpf, String fornecedor) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		}else if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf invalido.");
		}else if (!this.cc.getMapClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		}else if (!this.cf.getMapFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		}else if (!this.mapConta.containsKey(cpf + fornecedor)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
		this.mapConta.remove(cpf + fornecedor);
	}
	
	/**
	* Seta o criterio de ordenacao do sistema. Se o campo criterio não estiver nulo ou vazio e for valido.
	* 
	* @param criterio, o criterio de ordenacao.
	*/
	public void ordenaPor(String criterio) {
		if (criterio == null || criterio.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		}else if (!criterio.equals("Cliente") && !criterio.equals("Fornecedor") && !criterio.equals("Data")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
		this.setCriterio(criterio);
	}
	
	/**
	* Retorna a uma lista ordenada de de clientes de acordo com o nome.
	* 
	* @return a uma lista ordenada de clientes.
	*/
	public List<Cliente> ordenaClientes() {
		List<Cliente> clientesOrdenados = new ArrayList<>();
		for (Conta c : this.mapConta.values()) {
			clientesOrdenados.add(c.getCliente());
		}
		return clientesOrdenados = cc.ordenaCliente();
	}
	
	/**
	* Retorna a uma lista ordenada de Fornecedores de acordo com o nome.
	* 
	* @return a uma lista ordenada de Fornecedores.
	*/
	public List<Fornecedor> ordenaFornecedores() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>();
		for (Conta c : this.mapConta.values()) {
			fornecedoresOrdenados.add(c.getFornecedor());
		}
		return fornecedoresOrdenados = cf.ordenaFornecedor();
	}
	
	/**
	* Retorna a uma String que representa as compras registradas no sitema. Pode ser ordenada pelo cliente ou fornecedor.
	* A representação ordenada pelo cliente segue o formato: 
	* “nome_cliente, fornecedor, descricao do produto, data | ... | nome_cliente, fornecedor, descricao do produto, data”.
	* A representação ordenada pelo fornecedor segue o formato: 
	* “fornecedor, nome_cliente, descricao do produto, data | ... | fornecedor, nome_cliente, descricao do produto, data”.
	* 
	* @throws IllegalArgumentException, criterio nao definido ainda pelo sistema
	* @return a representação em String de todas as compras
	*/
	public String listarCompras(){
		if ("".equals(this.criterio.trim())) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}

		String listarCompras = "";
		List<Cliente> clientes = ordenaClientes();
		List<Fornecedor> fornecedores = ordenaFornecedores();
		
		if (this.criterio.equals("Cliente")) {
			int i = 0;
	 		for (Cliente c : clientes) {
	 			for (Fornecedor f : fornecedores) {
	 				if (this.mapConta.containsKey(c.getCpf() + f.getNome())) {
	 					Collection<Compra> valores = this.mapConta.get(c.getCpf() + f.getNome()).getCompras();
	 					List<Compra> lista = new ArrayList<Compra>();
	 					lista.addAll(valores);
	 					Collections.sort(lista, this.comparadorCompra);
	 					for (Compra a : lista) {
	 		 				if (i == 0) {
	 		 					listarCompras += c.getNome() + ", " + f.getNome() + ", " + a.getDescricaoProduto() + ", " + a.getData();
	 		 					i++;
	 		 				}else {
	 		 					listarCompras += " | " + c.getNome() + ", " + f.getNome() + ", " + a.getDescricaoProduto() + ", " + a.getData();
	 		 				}
	 					}
	 				}
	 			}
	 		}
	 	} else if (this.criterio.equals("Fornecedor")) {
	 		int i = 0;
	 		for (Fornecedor f : fornecedores) {
	 			for (Cliente c : clientes) {
	 				if (this.mapConta.containsKey(c.getCpf() + f.getNome())) {
	 					Collection<Compra> valores = this.mapConta.get(c.getCpf() + f.getNome()).getCompras();
	 					List<Compra> lista = new ArrayList<Compra>();
	 					lista.addAll(valores);
	 					Collections.sort(lista, this.comparadorCompra);
	 					for (Compra a : lista) {
	 		 				if (i == 0) {
	 		 					listarCompras += f.getNome() + ", " + c.getNome() + ", " + a.getDescricaoProduto() + ", " + a.getData();
	 		 					i++;
	 		 				}else {
	 		 					listarCompras += " | " + f.getNome() + ", " + c.getNome() + ", " + a.getDescricaoProduto() + ", " + a.getData();
	 		 				}
	 					}
	 				}
	 			}
	 		}
	 	}
		return listarCompras;
	}
}