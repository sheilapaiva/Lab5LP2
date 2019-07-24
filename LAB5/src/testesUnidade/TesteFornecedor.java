package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Fornecedor;

class TesteFornecedor {
	
	Fornecedor f1;
	Fornecedor f2;
	Fornecedor f3;
	
	@BeforeEach
	void setUP() {
		f1 = new Fornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		f2 = new Fornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
		f3 = new Fornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
	}
	
	@Test
	void testGrupoEstudos() {
		assertEquals(f1.getNome(), "Marcos");
		assertEquals(f1.getEmail(), "marcos@gmail.com");
		assertEquals(f1.getTelefone(), "83 99151-3570");
	}

	@Test
	void testEquals1Object() {
		assertEquals(f1, f3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(f1, f2);
	}
	
	@Test
	void testToString() {
		assertEquals(f1.toString(), "Marcos - marcos@gmail.com - 83 99151-3570");
	}

}
