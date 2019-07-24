package controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import comparadores.NomeComparadorFornecedor;
import comparadores.NomeComparadorProduto;
import entidades.Fornecedor;
import entidades.Produto;

/**
 * Representação de um Crud de Fornecedor, responsável por adicionar, recuperar, editar ou remover fornecedores.
 * Bem como, adicionar, recuperar, editar ou remover produtos dos fornecedores.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class CrudFornecedor {

	/**
	* Mapa de fornecedores.
	*/
	private HashMap<String, Fornecedor> mapFornecedores;
	/**
	* Comparador de fornecedor.
	*/
	private Comparator<Fornecedor> comparadorFornecedor;
	/**
	* Comparador de produto.
	*/
	private Comparator<Produto> comparadorProduto;
	
	/**
	* Constrói um Crud de fornecedores.
	*/
	public CrudFornecedor() {
		this.mapFornecedores = new HashMap<>();
		this.comparadorFornecedor = new NomeComparadorFornecedor();
		this.comparadorProduto = new NomeComparadorProduto();
	}

	/**
	* Retorna um mapa de fornecedores.
	* 
	* @return a ummapa de fornecedores
	* */
	public HashMap<String, Fornecedor> getMapFornecedores() {
		return mapFornecedores;
	}

	/**
	* Adiciona um novo fornecedor no mapa de fornecedores. A partir do nome, email e telefone.
	* Se esses campos estiverem preenchidos e não nulos. E se o fornecedor ainda não tiver sido adicionado.
	* Usa o nome como chave para o mapa.
	* 
	* @param nome, o nome do fornecedor
	* @param email, o email do fornecedor
	* @param telefone, o telefone do fornecedor
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo email vazio ou nulo
	* @throws IllegalArgumentException, campo telefone vazio ou nulo
	* @throws IllegalArgumentException, cliente ja existe
	* @return nome do fornecedor
	*/
	public String adicionaFornecedor(String nome, String email, String telefone){
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}else if (email == null || "".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}else if (telefone == null || "".equals(telefone.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}else if (this.mapFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		this.mapFornecedores.put(nome, novoFornecedor);
		return nome;
	}
	
	/**
	* Retorna a uma String que representa um fornecedor registrado no mapa de fornecedores com o nome passado
	* como parâmetro.
	* A representação segue o formato: “nome - email - telefone”.
	* 
	* @param nome, o nome do fornecedor
	* @throws IllegalArgumentException, fornecedor nao existe
	* @return a representação em String do fornecedor com o nome passado no parâmetro.
	*/
	public String exibeFornecedor(String nome) {
		if (!this.mapFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return this.mapFornecedores.get(nome).toString();
	}
	
	/**
	* Retorna a uma lista ordenada de Fornecedores de acordo com o nome.
	* 
	* @return a uma lista ordenada de Fornecedores.
	*/
	public List<Fornecedor> ordenaFornecedor() {
		Collection<Fornecedor> valores = this.mapFornecedores.values();
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		listaFornecedores.addAll(valores);
		Collections.sort(listaFornecedores, this.comparadorFornecedor);
		return listaFornecedores;
	}
	
	/**
	* Retorna a uma String que representa os fornecedores registrados no mapa de fornecedores em ordem alfabetica.
	* A representação segue o formato: “nome - email - telefone | ... | nome - email - telefone”.
	* 
	* @return a representação em String dos fornecedores registrados no mapa de fornecedores.
	*/
	public String exibeFornecedores() {
		String fornecedores = "";
		int i = 0;
		List<Fornecedor> listaFornecedores = ordenaFornecedor();
		for (Fornecedor f : listaFornecedores) {
			if (i == 0) {
				fornecedores += f.toString();
				i++;
			}else {
				fornecedores += " | " +  f.toString();
			}
		}
		return fornecedores;
	}
	
	/**
	* Edita um fornecedor no mapa de fornecedores. A partir do nome, do atributo que deseja editar e o novo valor
	* que tera o atributo editado. Se esses campos estiverem preenchidos e não nulos. E se o fornecedor estiver
	* no mapa de fornecedores.
	* 
	* @param nome, o nome do fornecedor
	* @param atributo, o atributo do fornecedor a ser editado
	* @param novoValor, o valor que tera o atributo editado
	* @throws IllegalArgumentException, campo atributo igual a nome
	* @throws IllegalArgumentException, campo atributo vazio ou nulo
	* @throws IllegalArgumentException, campo atributo nao existe
	* @throws IllegalArgumentException, campo novoValor vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");	
		}if (atributo == null || "".equals(atributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");	
		}else if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}else if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: cpf nao pode ser editado.");
		}else if (!atributo.equals("email") && !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}else if (novoValor == null || "".equals(novoValor.trim())) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");	
		}else if (!this.mapFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}else {
			if (atributo.equals("email")) {
				this.mapFornecedores.get(nome).setEmail(novoValor);
			}else if (atributo.equals("telefone")) {
				this.mapFornecedores.get(nome).setTelefone(novoValor);
			}	
		}
	}
	
	/**
	* Remove um fornecedor no mapa de fornecedores. A partir do nome, se esse campo estiver preenchido e o fornecedor estiver
	* no mapa de fornecedores.
	* 
	* @param nome, o nome do fornecedor
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	*/
	public void removeFornecedor(String nome) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}else if (!this.mapFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		this.mapFornecedores.remove(nome);
	}
	
	/**
	* Adiciona um novo produto no mapa de produtos do fornecedor. A partir do fornecedor, nome, descricao e preco.
	* Se esses campos estiverem preenchidos e não nulos. E se o produto ainda não tiver sido adicionado.
	* Usa o nome e descricao como chave para o mapa.
	* 
	* @param fornecedor, o nome do fornecedor
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param preco, o preco do produto
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, preco invalido
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, produto ja existe
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}else if (this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		Produto p = new Produto(nome, descricao, preco, "simples");
		this.mapFornecedores.get(fornecedor).getMapProdutos().put(nome + " - " + descricao, p);
	}
	
	/**
	* Retorna a uma String que representa um produto de um fornecedor, com o nome, descricao e fornecedor
	* passado como parâmetro.
	* A representação segue o formato: “nome - descricao - R$#,##”.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	* @throws IllegalArgumentException, produto nao existe
	* @return a representação em String do produto com o nome, descricao e fornecedor passado no parâmetro.
	*/
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}else if (!this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		return this.mapFornecedores.get(fornecedor).getMapProdutos().get(nome + " - " + descricao).toString();
	}
	
	/**
	* Retorna a uma lista ordenada de de produtos de um fornecedor.
	* 
	* @param fornecedor, o fornecedor dos produtos
	* @return a uma lista ordenada de Fornecedores.
	*/
	public List<Produto> ordenaProduto(String fornecedor) {
		Collection<Produto> valores = this.mapFornecedores.get(fornecedor).getMapProdutos().values();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.addAll(valores);
		Collections.sort(listaProdutos, this.comparadorProduto);
		return listaProdutos;
	}
	
	/**
	* Retorna a uma String que representa os produtos de um fornecedor em ordem alfabetica, 
	* com o fornecedor passado como parâmetro.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @param fornecedor, o nome do fornecedor
	* @throws IllegalArgumentException, fornecedor nao existe
	* @return a representação em String dos produtos do fornecedor passado no parâmetro.
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		String produtos = "";
		int i = 0;
		List<Produto> listaProdutos = ordenaProduto(fornecedor);
		for (Produto p : listaProdutos) {
			if (i == 0) {
				produtos += fornecedor + " - " + p.toString();
				i++;
			}else {
				produtos += " | " + fornecedor + " - " + p.toString();
			}
		}
		return produtos;
	}
	
	/**
	* Retorna a uma String que representa os produtos de todos os fornecedores registrados no mapa de fornecedores
	* em oredem alfabetica de fornecedor e produto.
	* A representação segue o formato: “nome - descricao - R$#,## | ... | nome - descricao - R$#,##”.
	* 
	* @return a representação em String dos produtos dos fornecedores.
	*/
	public String exibeProdutos() {
		String produtos = "";
		int i = 0;
		List<Fornecedor> listaFornecedores = ordenaFornecedor();
		for (Fornecedor f : listaFornecedores) {
			Collection<Produto> valores = this.mapFornecedores.get(f.getNome()).getMapProdutos().values();
			List<Produto> listaProdutos = new ArrayList<Produto>();
			listaProdutos.addAll(valores);
			Collections.sort(listaProdutos, this.comparadorProduto);
			if (listaProdutos.size() == 0) {
				produtos += " | " + f.getNome() + " -";
			}
			for (Produto p : listaProdutos) {
				if (i == 0) {
					produtos += f.getNome() + " - " + p.toString();
					i++;
				}else {
					produtos += " | " + f.getNome() + " - " + p.toString();
				}
			}
		}
		return produtos;
	}
	
	/**
	* Edita o preco de um produto de um fornecedor. A partir do nome, descricao, fornecedor e o novo preco.
	* Se esses campos estiverem preenchidos e não nulos. E se o fornecedor estiver no mapa de fornecedores.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	* @param novoPreco, o valor do novo preco
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, preco invalido
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	*/
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}else if (novoPreco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}else if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}else if (!this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		this.mapFornecedores.get(fornecedor).getMapProdutos().get(nome + " - " + descricao).setPreco(novoPreco);
	}
	
	/**
	* Remove um produto de um fornecedor. A partir do nome, descricao e fornecedor. Se esses campos estiverem preenchidos
	* e o fornecedor e produto estiverem cadastrados.
	* 
	* @param nome, o nome do produto
	* @param descricao, a descricao do produto
	* @param fornecedor, o nome do fornecedor
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	* @throws IllegalArgumentException, campo fornecedor4 vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, produto nao existe
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}else if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}else if (!this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		this.mapFornecedores.get(fornecedor).getMapProdutos().remove(nome + " - " + descricao);
	}
	
	/**
	* Adiciona um combo de produtos de um fornecedor. A partir do fornecedor, nome, descricao e fator e produtos. 
	* Se esses campos estiverem preenchidos, o fornecedor e os produtos estiverem cadastrados.
	* 
	* @param fornecedor, o nome do fornecedor
	* @param nome, o nome do combo
	* @param descricao, a descricao do combo
	* @param fator, o fotor promocional do combo
	* @param produtos, os produtos do combo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	* @throws IllegalArgumentException, campo fator invalido
	* @throws IllegalArgumentException, campo produtos vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, combo ja existe
	* @throws IllegalArgumentException, produto nao existe
	* @throws IllegalArgumentException, combo nao pode possuir combo
	*/
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}else if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}else if (fator <= 0 || fator >=1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}else if (produtos == null || "".equals(produtos.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}else if (this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		} String[] produto = produtos.split(", ");
		if (!this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(produto[0]) || !this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(produto[1])) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}else if (this.mapFornecedores.get(fornecedor).getMapProdutos().get(produto[0]).getTipo().equals("combo") || 
			this.mapFornecedores.get(fornecedor).getMapProdutos().get(produto[1]).getTipo().equals("combo")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		}
		double precoTotal = (this.mapFornecedores.get(fornecedor).getMapProdutos().get(produto[0]).getPreco() + this.mapFornecedores.get(fornecedor).getMapProdutos().get(produto[1]).getPreco());
		double preco = precoTotal - (precoTotal * fator);
		Produto p = new Produto(nome, descricao, preco, "combo", precoTotal);
		this.mapFornecedores.get(fornecedor).getMapProdutos().put(nome + " - " + descricao, p);
	}
	
	/**
	* Edita um combo de produtos de um fornecedor. A partir do nome, descricao, fornecedor e novo fator. 
	* Se esses campos estiverem preenchidos, o fornecedor e o combo estiverem cadastrados.
	* 
	* @param nome, o nome do combo
	* @param descricao, a descricao do combo
	* @param fornecedor, o nome do fornecedor
	* @param novoFator, o novo fotor promocional do combo
	* @throws IllegalArgumentException, campo fornecedor vazio ou nulo
	* @throws IllegalArgumentException, fornecedor nao existe
	* @throws IllegalArgumentException, campo novoFator invalido
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo descricao vazio ou nulo
	* @throws IllegalArgumentException, produto nao existe
	*/
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		if (fornecedor == null || "".equals(fornecedor.trim())) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		}else if (!this.mapFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}else if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}else if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}else if (descricao == null || "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}else if (!this.mapFornecedores.get(fornecedor).getMapProdutos().containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		double novoPreco = this.mapFornecedores.get(fornecedor).getMapProdutos().get(nome + " - " + descricao).getPrecoTotal();
		novoPreco -= novoPreco * novoFator;
		this.mapFornecedores.get(fornecedor).getMapProdutos().get(nome + " - " + descricao).setPreco(novoPreco);	
	}
}
