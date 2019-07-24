package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.CrudCliente;

class TesteCrudCliente {
	
	CrudCliente cc;
	
	@BeforeEach
	void setUP() {
		cc = new CrudCliente();
		cc.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		cc.adicionaCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded");
	}
	
	@Test
	void testarAdicionaClienteCpfNulo() {
		try {
			cc.adicionaCliente(null, "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException cn) {
			assertEquals(cn.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfVazio() {
		try {
			cc.adicionaCliente("", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteNomeNulo() {
		try {
			cc.adicionaCliente("19418510068", null, "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteNomeVazio() {
		try {
			cc.adicionaCliente("19418510068", " ", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteEmailNulo() {
		try {
			cc.adicionaCliente("19418510068", "Amigao Fernandes", null, "LSD");
		}catch(IllegalArgumentException en) {
			assertEquals(en.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteEmailVazio() {
		try {
			cc.adicionaCliente("19418510068", "Amigao Fernandes", "", "LSD");
		}catch(IllegalArgumentException ev) {
			assertEquals(ev.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteLocalizacaoNulo() {
		try {
			cc.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", null);
		}catch(IllegalArgumentException ln) {
			assertEquals(ln.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaClienteLocalizacaoVazio() {
		try {
			cc.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "");
		}catch(IllegalArgumentException lv) {
			assertEquals(lv.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaClienteJaCadastrado() {
		try {
			cc.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ca) {
			assertEquals(ca.getMessage(), "Erro no cadastro do cliente: cliente ja existe.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfInvalido1() {
		try {
			cc.adicionaCliente("19418510068999990", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro no cadastro do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfInvalido2() {
		try {
			cc.adicionaCliente("1941851", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro no cadastro do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testAdicionaClienteValido() {
		assertEquals(cc.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc"), "19418510068");
	}
	
	@Test
	void testarExibeClienteNaoCadastrado() {
		try {
			cc.exibeCliente("19418510060");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarExibeClienteCadastrado() {
		assertEquals(cc.exibeCliente("00023827490"), "Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarExibeClientesCadastrados() {
		assertEquals(cc.exibeClientes(), "Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br | Wilson Andre - Embedded - wilson_andre@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteCpfNulo() {
		try {
			cc.editaCliente(null, "nome", "Victor");
		}catch(IllegalArgumentException cn) {
			assertEquals(cn.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteCpfVazio() {
		try {
			cc.editaCliente("", "nome", "Victor");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNulo() {
		try {
			cc.editaCliente("00023827490", null, "Victor");
		}catch(IllegalArgumentException an) {
			assertEquals(an.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoVazio() {
		try {
			cc.editaCliente("00023827490", "", "Victor");
		}catch(IllegalArgumentException av) {
			assertEquals(av.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNaoExiste() {
		try {
			cc.editaCliente("00023827490", "sobrenome", "Victor");
		}catch(IllegalArgumentException an) {
			assertEquals(an.getMessage(), "Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	@Test
	void testarEditaClienteNovoValorNulo() {
		try {
			cc.editaCliente("00023827490", "nome", null);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteNovoValorVazio() {
		try {
			cc.editaCliente("00023827490", "nome", "");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteNaoCadastrado() {
		try {
			cc.editaCliente("00023827488", "nome", "Victor");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNome() {
		cc.editaCliente("00023827490", "nome", "Victor Araujo");
		assertEquals(cc.exibeCliente("00023827490"), "Victor Araujo - Labarc - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteAtributoEmail() {
		cc.editaCliente("00023827490", "email", "vitu@ccc.ufcg.edu.br");
		assertEquals(cc.exibeCliente("00023827490"), "Victor Emanuel - Labarc - vitu@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteAtributoLocalizacao() {
		cc.editaCliente("00023827490", "localizacao", "SPLab");
		assertEquals(cc.exibeCliente("00023827490"), "Victor Emanuel - SPLab - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarRemoveClienteCpfVazio() {
		try {
			cc.removeCliente("   ");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na remocao do cliente: cpf do cliente nao pode ser vazio.");
		}
	}
	
	@Test
	void testarRemoveClienteCpfNaoCadastrado() {
		try {
			cc.removeCliente("11112345678");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarRemoveClienteCpfValido() {
		cc.removeCliente("00023827490");
		try {
			cc.exibeCliente("00023827490");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}
}
