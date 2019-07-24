package comparadores;

import java.util.Comparator;

import entidades.Cliente;

/**
 * Compara dois objetos Cliente, usando o Comparator.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class NomeComparadorCliente implements Comparator<Cliente>{

	/**
	* Compara dois objetos Cliente, retorna a diferença entre as Strings nome 
	* definindo a sua ordem alfabética. 
	* 
	* @return a um inteiro
	*/
	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
