package controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import comparadores.NomeComparadorCliente;
import entidades.Cliente;

/**
 * Representação de um Crud de Cliente, responsável por adicionar, recuperar, editar ou remover clientes.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class CrudCliente {
	
	/**
	* Mapa de clientes.
	*/
	private HashMap<String, Cliente> mapClientes;
	
	/**
	* Comparador de cliente.
	*/
	private Comparator<Cliente> comparador;

	/**
	* Constrói um Crud de clientes.
	*/
	public CrudCliente() {
		this.mapClientes = new HashMap<>();
		this.comparador =  new NomeComparadorCliente();
	}

	/**
	* Retorna um mapa de clientes.
	* 
	* @return a um mapa de clientes
	* */
	public HashMap<String, Cliente> getMapClientes() {
		return mapClientes;
	}

	/**
	* Adiciona um novo cliente no mapa de clientes. A partir do cpf, nome, email e localizacao.
	* Se esses campos estiverem preenchidos e não nulos. E se o cliente ainda não tiver sido adicionado.
	* Usa o cpf como chave para o mapa.
	* 
	* @param cpf, o cpf do cliente
	* @param nome, o nome do cliente
	* @param email, o email do cliente
	* @param localizacao, a localizacao do cliente
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo nome vazio ou nulo
	* @throws IllegalArgumentException, campo email vazio ou nulo
	* @throws IllegalArgumentException, campo localizacao vazio ou nulo
	* @throws IllegalArgumentException, cliente ja existe
	* @throws IllegalArgumentException, campo cpf invalido
	* @return cpf do cliente
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao){
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}else if (nome == null || "".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}else if (email == null || "".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}else if (localizacao == null || "".equals(localizacao.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}else if (this.mapClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}else if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		Cliente novoCliente = new Cliente(cpf, nome, email, localizacao);
		this.mapClientes.put(cpf, novoCliente);
		return cpf;
	}
	
	/**
	* Retorna a uma String que representa um cliente registrado no mapa de cliente com o cpf passado
	* como parâmetro.
	* A representação segue o formato “nome - localizacao - email”.
	* 
	* @param cpf, o cpf do cliente
	* @throws IllegalArgumentException, cliente nao existe
	* @return a representação em String do cliente com o cpf passado no parâmetro.
	*/
	public String exibeCliente(String cpf) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}else if (!this.mapClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.mapClientes.get(cpf).toString();
	}
	
	/**
	* Retorna a uma lista ordenada de de clientes de acordo com o nome.
	* 
	* @return a uma lista ordenada de clientes.
	*/
	public List<Cliente> ordenaCliente() {
		Collection<Cliente> valores = this.mapClientes.values();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista.addAll(valores);
		Collections.sort(lista, this.comparador);
		return lista;
	}
	
	/**
	* Retorna a uma String que representa os cliente registrado no mapa de cliente em ordem alfabetica.
	* A representação segue o formato: “nome - localizacao - email | ... | nome - localizacao - email”.
	* 
	* @return a representação em String dos clientes registrados no mapa de clientes.
	*/
	public String exibeClientes() {
		String clientes = "";
		int i = 0;
		List<Cliente> listaClientes = ordenaCliente();
		for (Cliente c : listaClientes) {
			if (i == 0) {
				clientes += c.toString();
				i++;
			}else {
				clientes += " | " +  c.toString();
			}
		}
		return clientes;
	}
	
	/**
	* Edita um cliente no mapa de clientes. A partir do cpf, do atributo que deseja editar e o novo valor
	* que tera o atributo editado. Se esses campos estiverem preenchidos e não nulos. E se o cliente estiver
	* no mapa de clientes.
	* 
	* @param cpf, o cpf do cliente
	* @param atributo, o atributo do cliente a ser editado
	* @param novoValor, o valor que tera o atributo editado
	* @throws IllegalArgumentException, campo cpf vazio ou nulo
	* @throws IllegalArgumentException, campo atributo vazio ou nulo
	* @throws IllegalArgumentException, campo atributo nao existe
	* @throws IllegalArgumentException, campo novoValor vazio ou nulo
	* @throws IllegalArgumentException, cliente nao existe
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");	
		}else if (atributo == null || "".equals(atributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");	
		}else if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");	
		}else if (!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}else if (novoValor == null || "".equals(novoValor.trim())) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");	
		}else if (!this.mapClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}else {
			if (atributo.equals("nome")) {
				this.mapClientes.get(cpf).setNome(novoValor);
			}else if (atributo.equals("email")) {
				this.mapClientes.get(cpf).setEmail(novoValor);
			}else if (atributo.equals("localizacao")) {
				this.mapClientes.get(cpf).setLocalizacao(novoValor);
			}	
		}
	}
	
	/**
	* Remove um cliente no mapa de clientes. A partir do cpf, se esse campo estiver preenchido e o cliente estiver
	* no mapa de clientes.
	* 
	* @param cpf, o cpf do cliente
	* @throws IllegalArgumentException, campo cpf vazio
	* @throws IllegalArgumentException, cliente nao existe
	*/
	public void removeCliente(String cpf) {
		if (cpf == null || "".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}else if (!this.mapClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		this.mapClientes.remove(cpf);
	}
}

