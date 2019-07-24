package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Compra;

class TesteCompra {

	Compra c1;
	
	@BeforeEach
	void setUp() {
		c1 = new Compra("03/12/2013", "Coxao com batata", "Coxao com batata frita", 5.00);
	}
	
	@Test
	void testAluno() {
		assertEquals("03/12/2013", c1.getData());
		assertEquals("Coxao com batata", c1.getNomeProduto());
		assertEquals( "Coxao com batata frita", c1.getDescricaoProduto());
		assertEquals(5.0, c1.getPreco());
	}
	
	@Test
	void testToString() {
		assertEquals(c1.toString(), "Coxao com batata - 03-12-2013");
	}
}
