package comparadores;

import java.util.Comparator;

import entidades.Produto;

/**
 * Compara dois objetos Produto, usando o Comparator.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class NomeComparadorProduto implements Comparator<Produto>{
	
	/**
	* Compara dois objetos Produto, retorna a diferença entre as Strings nome 
	* definindo a sua ordem alfabética. 
	* 
	* @return a um inteiro 
	*/
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
