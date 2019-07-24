package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Produto;

class TesteProduto {

	Produto p1;
	Produto p2;
	Produto p3;
	
	@BeforeEach
	void setUp() {
		p1 = new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 5.00, "simples");
		p2 = new Produto("X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50, "simples");
		p3 = new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 5.00, "simples");
	}
	
	@Test
	void testAluno() {
		assertEquals("X-frango", p1.getNome());
		assertEquals("Hamburguer de frango com queijo e calabresa", p1.getDescricao());
		assertEquals(5.00, p1.getPreco());
	}

	@Test
	void testEquals1Object() {
		assertEquals(p1, p3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(p1, p2);
	}
	
	@Test
	void testToString() {
		assertEquals(p1.toString(), "X-frango - Hamburguer de frango com queijo e calabresa - R$5,00");
	}

}
