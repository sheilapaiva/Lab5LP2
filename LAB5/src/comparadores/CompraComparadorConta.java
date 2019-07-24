package comparadores;

import java.util.Comparator;

import entidades.Compra;

public class CompraComparadorConta implements Comparator<Compra>  {
	
	/**
	* Compara dois objetos Compra de acordo com a descricao do produto, retorna a diferença entre as Strings nome 
	* definindo a sua ordem alfabética. 
	* 
	* @return a um inteiro.
	*/
	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getDescricaoProduto().compareTo(o2.getDescricaoProduto());
	}
}
