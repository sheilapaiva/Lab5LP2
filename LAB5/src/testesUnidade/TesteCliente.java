package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Cliente;
class TesteCliente {

	Cliente c1;
	Cliente c2;
	Cliente c3;
	
	@BeforeEach
	void setUp() {
		c1 = new Cliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		c2 = new Cliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded");
		c3 = new Cliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
	}
	
	@Test
	void testAluno() {
		assertEquals("00023827490", c1.getCpf());
		assertEquals("Victor Emanuel", c1.getNome());
		assertEquals("vitao@ccc.ufcg.edu.br", c1.getEmail());
		assertEquals("Labarc", c1.getLocalizacao());
	}

	@Test
	void testEquals1Object() {
		assertEquals(c1, c3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(c1, c2);
	}
	
	@Test
	void testToString() {
		assertEquals(c1.toString(), "Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br");
	}
}
