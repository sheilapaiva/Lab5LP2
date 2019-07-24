package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Cliente;
import entidades.Conta;
import entidades.Fornecedor;

class TesteConta {

	Cliente cc1;
	Cliente cc2;
	Conta c1;
	Conta c2;
	Conta c3;
	Fornecedor f1;
	Fornecedor f2;
	
	@BeforeEach
	void setUp() {
		cc1 = new Cliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		cc2 = new Cliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded");
		f1 = new Fornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		f2 = new Fornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
		c1 = new Conta(cc1, f1);
		c2 = new Conta(cc2, f2);
		c3 = new Conta(cc1, f1);
	}
	
	@Test
	void testConta() {
		assertEquals(cc1, c1.getCliente());
		assertEquals(f1, c1.getFornecedor());
	}

	@Test
	void testEquals1Object() {
		assertEquals(c1, c3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(c1, c2);
	}

}
