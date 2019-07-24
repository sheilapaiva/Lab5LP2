package comparadores;

import java.util.Comparator;

import entidades.Fornecedor;

/**
 * Compara dois objetos Fornecedor, usando o Comparator.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class NomeComparadorFornecedor implements Comparator<Fornecedor> {
	
	/**
	* Compara dois objetos Fornecedor, retorna a diferença entre as Strings nome 
	* definindo a sua ordem alfabética. 
	* 
	* @return a um inteiro
	*/
	@Override
	public int compare(Fornecedor o1, Fornecedor o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
