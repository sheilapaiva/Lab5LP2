package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControleGeral;

class TesteControleGeral {

	ControleGeral cf;
	
	@BeforeEach
	void setUP() {
		cf = new ControleGeral();
		
		cf.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		cf.adicionaCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded");
		
		cf.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		cf.adicionaFornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
		cf.adicionaProduto("Marcos", "X-frango", "Hamburguer de frango com queijo e calabresa", 5.00);
		cf.adicionaProduto("Marcos", "Suco", "Suco de laranja", 2.00);
		cf.adicionaProduto("Marcos", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		cf.adicionaProduto("Helhao", "Rubacao", "Feijao com arroz e queijo coalho", 14.00);
		cf.adicionaCombo("Marcos", "X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de laranja");
	
		cf.adicionaCompra("00023827490", "Marcos", "22/01/2019", "Suco", "Suco de laranja");
		cf.adicionaCompra("00023827490", "Marcos", "24/01/2019", "X-burguer", "Hamburguer de carne com queijo e calabresa");
		cf.adicionaCompra("00023827490", "Helhao", "24/01/2019", "Rubacao", "Feijao com arroz e queijo coalho");

	}
	
	@Test
	void testarAdicionaClienteCpfNulo() {
		try {
			cf.adicionaCliente(null, "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException cn) {
			assertEquals(cn.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfVazio() {
		try {
			cf.adicionaCliente("", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteNomeNulo() {
		try {
			cf.adicionaCliente("19418510068", null, "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteNomeVazio() {
		try {
			cf.adicionaCliente("19418510068", " ", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteEmailNulo() {
		try {
			cf.adicionaCliente("19418510068", "Amigao Fernandes", null, "LSD");
		}catch(IllegalArgumentException en) {
			assertEquals(en.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteEmailVazio() {
		try {
			cf.adicionaCliente("19418510068", "Amigao Fernandes", "", "LSD");
		}catch(IllegalArgumentException ev) {
			assertEquals(ev.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaClienteLocalizacaoNulo() {
		try {
			cf.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", null);
		}catch(IllegalArgumentException ln) {
			assertEquals(ln.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaClienteLocalizacaoVazio() {
		try {
			cf.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "");
		}catch(IllegalArgumentException lv) {
			assertEquals(lv.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaClienteJaCadastrado() {
		try {
			cf.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ca) {
			assertEquals(ca.getMessage(), "Erro no cadastro do cliente: cliente ja existe.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfInvalido1() {
		try {
			cf.adicionaCliente("19418510068999990", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro no cadastro do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testarAdicionaClienteCpfInvalido2() {
		try {
			cf.adicionaCliente("1941851", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro no cadastro do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testAdicionaClienteValido() {
		assertEquals(cf.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "Labarc"), "19418510068");
	}
	
	@Test
	void testarExibeClienteNaoCadastrado() {
		try {
			cf.exibeCliente("19418510060");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarExibeClienteCadastrado() {
		assertEquals(cf.exibeCliente("00023827490"), "Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarExibeClientesCadastrados() {
		assertEquals(cf.exibeClientes(), "Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br | Wilson Andre - Embedded - wilson_andre@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteCpfNulo() {
		try {
			cf.editaCliente(null, "nome", "Victor");
		}catch(IllegalArgumentException cn) {
			assertEquals(cn.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteCpfVazio() {
		try {
			cf.editaCliente("", "nome", "Victor");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNulo() {
		try {
			cf.editaCliente("00023827490", null, "Victor");
		}catch(IllegalArgumentException an) {
			assertEquals(an.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoVazio() {
		try {
			cf.editaCliente("00023827490", "", "Victor");
		}catch(IllegalArgumentException av) {
			assertEquals(av.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNaoExiste() {
		try {
			cf.editaCliente("00023827490", "sobrenome", "Victor");
		}catch(IllegalArgumentException an) {
			assertEquals(an.getMessage(), "Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	@Test
	void testarEditaClienteNovoValorNulo() {
		try {
			cf.editaCliente("00023827490", "nome", null);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteNovoValorVazio() {
		try {
			cf.editaCliente("00023827490", "nome", "");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaClienteNaoCadastrado() {
		try {
			cf.editaCliente("00023827488", "nome", "Victor");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarEditaClienteAtributoNome() {
		cf.editaCliente("00023827490", "nome", "Victor Araujo");
		assertEquals(cf.exibeCliente("00023827490"), "Victor Araujo - Labarc - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteAtributoEmail() {
		cf.editaCliente("00023827490", "email", "vitu@ccc.ufcg.edu.br");
		assertEquals(cf.exibeCliente("00023827490"), "Victor Emanuel - Labarc - vitu@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarEditaClienteAtributoLocalizacao() {
		cf.editaCliente("00023827490", "localizacao", "SPLab");
		assertEquals(cf.exibeCliente("00023827490"), "Victor Emanuel - SPLab - vitao@ccc.ufcg.edu.br");
	}
	
	@Test
	void testarRemoveClienteCpfVazio() {
		try {
			cf.removeCliente("   ");
		}catch(IllegalArgumentException cv) {			assertEquals(cv.getMessage(), "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");

		}
	}
	
	@Test
	void testarRemoveClienteCpfNaoCadastrado() {
		try {
			cf.removeCliente("11112345678");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarRemoveClienteCpfValido() {
		cf.removeCliente("00023827490");
		try {
			cf.exibeCliente("00023827490");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorNomeNulo() {
		try {
			cf.adicionaFornecedor(null, "alba@gmail.com", "83 99945-1294");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorNomeVazio() {
		try {
			cf.adicionaFornecedor("", "alba@gmail.com", "83 99945-1294");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorEmailNulo() {
		try {
			cf.adicionaFornecedor("Dona Alba", null, "83 99945-1294");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorEmailVazio() {
		try {
			cf.adicionaFornecedor("Dona Alba", "  ","83 99945-1294");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorTelefoneNulo() {
		try {
			cf.adicionaFornecedor("Dona Alba", "alba@gmail.com", null);
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorTelefoneVazio() {
		try {
			cf.adicionaFornecedor("Dona Alba", "alba@gmail.com", "");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorJaCadastrado() {
		try {
			cf.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	
	@Test
	void testarAdicionaFornecedorValido() {
		assertEquals(cf.adicionaFornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294"), "Dona Alba");
	}
	
	@Test
	void testarExibeFornecedorNaoCadastrado() {
		try {
			cf.exibeFornecedor("Dona Alba");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarExibeFornecedorCadastrado() {
		assertEquals(cf.exibeFornecedor("Marcos"), "Marcos - marcos@gmail.com - 83 99151-3570");
	}
	
	@Test
	void testarExibeFornecedoresCadastrados() {
		assertEquals(cf.exibeFornecedores(), "Helhao - quiosque@gmail.com - 83 98736-5050 | Marcos - marcos@gmail.com - 83 99151-3570");
	}
	
	@Test
	void testarEditaFornecedorAtributoNome() {
		try {
			cf.editaFornecedor("Marcos", "nome", "Marcos Lanches");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
	}
	
	@Test
	void testarEditaFornecedorAtributoNulo() {
		try {
			cf.editaFornecedor("Marcos", null, "Marcos Lanches");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaFornecedorAtributoVazio() {
		try {
			cf.editaFornecedor("Marcos", "", "Marcos Lanches");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaFornecedorAtributoNaoExiste() {
		try {
			cf.editaFornecedor("Marcos", "sobrenome", "Lanches");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	@Test
	void testarEditaFornecedorNovoValorNulo() {
		try {
			cf.editaFornecedor("Marcos", "email", null);
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaFornecedorNovoValorVazio() {
		try {
			cf.editaFornecedor("Marcos", "email", "");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaFornecedorNaoExiste() {
		try {
			cf.editaFornecedor("Dona Alba", "telefone", "83 99945-1294");
		}catch(IllegalArgumentException aa) {
			assertEquals(aa.getMessage(), "Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarEditaFornecedorAtributoEmail() {
		cf.editaFornecedor("Marcos", "email", "marcoslanches@gmail.com");
		assertEquals(cf.exibeFornecedor("Marcos"), "Marcos - marcoslanches@gmail.com - 83 99151-3570");
	}
	
	@Test
	void testarEditaFornecedorAtributoTelefone() {
		cf.editaFornecedor("Marcos", "telefone", "83 99151-9999");
		assertEquals(cf.exibeFornecedor("Marcos"), "Marcos - marcos@gmail.com - 83 99151-9999");
	}
	
	@Test
	void testarRemoveFornecedorNomeVazio() {
		try {
			cf.removeFornecedor("   ");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
	}
	
	@Test
	void testarRemoveFornecedorNaoCadastrado() {
		try {
			cf.removeFornecedor("Manoel");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarRemoveFornecedorNomeValido() {
		cf.removeFornecedor("Marcos");
		try {
			cf.exibeFornecedor("Marcos");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarAdicionaProdutoNomeNulo() {
		try {
			cf.adicionaProduto("Marcos", null, "Coxao de frango com presunto e queijo", 2.50);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaProdutoNomeVazio() {
		try {
			cf.adicionaProduto("Marcos", "", "Coxao de frango com presunto e queijo", 2.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaProdutoDescricaoNulo() {
		try {
			cf.adicionaProduto("Marcos", "Coxao de frango", null, 2.50);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaProdutoDescricaoVazia() {
		try {
			cf.adicionaProduto("Marcos", "Coxao de frango", " ", 2.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaProdutoFornecedorNulo() {
		try {
			cf.adicionaProduto(null, "Coxao de frango", "Coxao de frango com presunto e queijo", 2.50);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaProdutoFornecedorVazio() {
		try {
			cf.adicionaProduto("", "Coxao de frango", "Coxao de frango com presunto e queijo", 2.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaProdutoPrecoInvalido() {
		try {
			cf.adicionaProduto("Marcos", "Coxao de frango", "Coxao de frango com presunto e queijo", -2.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: preco invalido.");
		}
	}
	
	@Test
	void testarAdicionaProdutoFornecedorNaoExiste() {
		try {
			cf.adicionaProduto("Alfredo", "Coxao de frango", "Coxao de frango com presunto e queijo", 2.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarAdicionaProdutoJaCadastrado() {
		try {
			cf.adicionaProduto("Marcos", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de produto: produto ja existe.");
		}
	}
	
	@Test
	void testarAdicionaProdutoValido() {
		cf.adicionaProduto("Marcos", "Coxao de frango", "Coxao de frango com presunto e queijo", 2.50);
		assertEquals(cf.exibeProduto("Coxao de frango", "Coxao de frango com presunto e queijo", "Marcos"), "Coxao de frango - Coxao de frango com presunto e queijo - R$2,50");
	}
	
	@Test
	void testarExibeProdutoNomeNulo() {
		try {
			cf.exibeProduto(null, "Hamburguer de frango com queijo e calabresa", "Marcos");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeProdutoNomeVazio() {
		try {
			cf.exibeProduto("", "Hamburguer de frango com queijo e calabresa", "Marcos");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeProdutoDescricaoNula() {
		try {
			cf.exibeProduto("X-frango", null, "Marcos");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarExibeProdutoDescricaoVazia() {
		try {
			cf.exibeProduto("X-frango", " ", "Marcos");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarExibeProdutoFornecedorNulo() {
		try {
			cf.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", null);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeProdutoFornecedorVazio() {
		try {
			cf.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", "");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeProdutoFornecedorNaoCadastrado() {
		try {
			cf.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", "Alberto Lanches");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarExibeProdutoNaoCadastrado() {
		try {
			cf.exibeProduto("X-EGG", "Hamburguer com queijo e ovo", "Marcos");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}
	
	@Test
	void testarExibeProdutoCadastrado() {
		assertEquals(cf.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", "Marcos"), "X-frango - Hamburguer de frango com queijo e calabresa - R$5,00"); 
	}
	
	@Test
	void testarExibeProdutosFornecedorNaoCadastrado() {
		try {
			cf.exibeProdutosFornecedor("Alfredo");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarExibeProdutosFornecedorCadastrado() {
		assertEquals(cf.exibeProdutosFornecedor("Marcos"), "Marcos - Suco - Suco de laranja - R$2,00 | Marcos - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Marcos - X-burguer + Suco - Hamburguer de carne com queijo e calabresa e suco de laranja - R$5,20 | Marcos - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00");
	}
	
	@Test
	void testarExibeProdutosFornecedores() {
		assertEquals(cf.exibeProdutos(), "Helhao - Rubacao - Feijao com arroz e queijo coalho - R$14,00 | Marcos - Suco - Suco de laranja - R$2,00 | Marcos - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Marcos - X-burguer + Suco - Hamburguer de carne com queijo e calabresa e suco de laranja - R$5,20 | Marcos - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00");
	}
	
	@Test
	void testarEditaProdutoFornecedorNulo() {
		try {
			cf.editaProduto("Rubacao", "Feijao com arroz e queijo coalho", null, 12.00);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaProdutoFornecedorVazio() {
		try {
			cf.editaProduto("Rubacao", "Feijao com arroz e queijo coalho", "", 12.00);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaProdutoFornecedorNaoCadastrado() {
		try {
			cf.editaProduto("Rubacao", "Feijao com arroz e queijo coalho", "Alfredo", 12.00);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao de produto: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarEditaProdutoPrecoInvalido() {
		try {
			cf.editaProduto("Rubacao", "Feijao com arroz e queijo coalho", "Helhao", -12.00);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao de produto: preco invalido.");
		}
	}
	
	@Test
	void testarEditaProdutoNomeNulo() {
		try {
			cf.editaProduto(null, "Feijao com arroz e queijo coalho", "Helhao", 12.00);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaProdutoNomeVazio() {
		try {
			cf.editaProduto("", "Feijao com arroz e queijo coalho", "Helhao", 12.00);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaProdutoDescricaoNula() {
		try {
			cf.editaProduto("Rubacao", null, "Helhao", 12.00);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarEditaProdutoDescricaoVazia() {
		try {
			cf.editaProduto("Rubacao", "", "Helhao", 12.00);
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarEditaProduto() {
		cf.editaProduto("Rubacao", "Feijao com arroz e queijo coalho", "Helhao", 12.00);
		assertEquals(cf.exibeProduto("Rubacao", "Feijao com arroz e queijo coalho", "Helhao"), "Rubacao - Feijao com arroz e queijo coalho - R$12,00");
	}
	
	@Test
	void testarRemoveProdutoNomeNulo() {
		try {
			cf.removeProduto(null, "Feijao com arroz e queijo coalho", "Helhao");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarRemoveProdutoNomeVazio() {
		try {
			cf.removeProduto("", "Feijao com arroz e queijo coalho", "Helhao");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarRemoveProdutoDescricaoNula() {
		try {
			cf.removeProduto("Rubacao", null, "Helhao");
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarRemoveProdutoDescricaoVazia() {
		try {
			cf.removeProduto("Rubacao", "", "Helhao");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarRemoveProdutoFornecedorNulo() {
		try {
			cf.removeProduto("Rubacao", "Feijao com arroz e queijo coalho", null);
		}catch(IllegalArgumentException nn) {
			assertEquals(nn.getMessage(), "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarRemoveProdutoFornecedorVazio() {
		try {
			cf.removeProduto("Rubacao", "Feijao com arroz e queijo coalho", "");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarRemoveProdutoFornecedorNaoCadastrado() {
		try {
			cf.removeProduto("Rubacao", "Feijao com arroz e queijo coalho", "Alfredo");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na remocao de produto: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarRemoveProdutoNaoCadastrado() {
		try {
			cf.removeProduto("Feijão", "Feijao", "Helhao");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro na remocao de produto: produto nao existe.");
		}
	}
	
	@Test
	void testarRemoveProdutoValido() {
		cf.removeProduto("Rubacao", "Feijao com arroz e queijo coalho", "Helhao");
		try {
			cf.exibeProduto("Rubacao", "Feijao com arroz e queijo coalho", "Helhao");
		}catch(IllegalArgumentException ci) {
			assertEquals(ci.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}
	
	@Test
	void testarAdicionaComboFornecedorNulo() {
		try {
			cf.adicionaCombo(null, "Arroz com feijao", "Arroz branco com feijao", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaComboFornecedorVazio() {
		try {
			cf.adicionaCombo(" ", "Arroz com feijao", "Arroz branco com feijao", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaComboNomeNulo() {
		try {
			cf.adicionaCombo("Francisco", null, "Arroz branco com feijao", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaComboNomeVazio() {
		try {
			cf.adicionaCombo("Francisco", " ", "Arroz branco com feijao", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionaComboDescricaoNulo() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", null, 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaComboDescricaoVazio() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", " ", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionaComboFatorInvalido1() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", "Arroz branco com feijao", 1, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: fator invalido.");
		}
	}
	
	@Test
	void testarAdicionaComboFatorInvalido2() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", "Arroz branco com feijao", -0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: fator invalido.");
		}
	}
	
	@Test
	void testarAdicionaComboProdutosNulo() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", "Arroz branco com feijao", 0.30, null);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: combo deve ter produtos.");
		}
	}
	
	@Test
	void testarAdicionaComboProdutosVazio() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", "Arroz branco com feijao", 0.30, "");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: combo deve ter produtos.");
		}
	}
	
	@Test
	void testarAdicionaComboFornecedorNaoExiste() {
		try {
			cf.adicionaCombo("Francisco", "Arroz com feijao", "Arroz branco com feijao", 0.30, "Arroz - Arroz branco, Feijao - Feijao carioca");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarAdicionaComboJaExiste() {
		try {
			cf.adicionaCombo("Marcos", "X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de laranja");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: combo ja existe.");
		}
	}
	
	@Test
	void testarAdicionaComboProdutoNaoExiste1() {
		try {
			cf.adicionaCombo("Marcos", "X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de manga", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de manga");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: produto nao existe.");
		}
	}
	
	@Test
	void testarAdicionaComboProdutoNaoExiste2() {
		try {
			cf.adicionaCombo("Marcos", "Hamburguer + Suco", "Hamburguer com queijo e suco de laranja", 0.20, "Hamburguer - Hamburguer com queijo, Suco - Suco de laranja");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: produto nao existe.");
		}
	}
	
	@Test
	void testarAdicionaComboComCombo() {
		try {
			cf.adicionaCombo("Marcos", "X-frango e X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja + Hamburguer de frango com queijo e calabresa", 0.20, "X-burguer + Suco - Hamburguer de carne com queijo e calabresa e suco de laranja, X-frango - Hamburguer de frango com queijo e calabresa");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		}
	}
	
	@Test
	void testarAdicionaCombo() {
		cf.adicionaCombo("Marcos", "X-frango e X-burguer", "Hamburguer de carne com queijo e calabresa + Hamburguer de frango com queijo e calabresa", 0.50, "X-burguer - Hamburguer de carne com queijo e calabresa, X-frango - Hamburguer de frango com queijo e calabresa");
		assertEquals(cf.exibeProduto("X-frango e X-burguer", "Hamburguer de carne com queijo e calabresa + Hamburguer de frango com queijo e calabresa", "Marcos"), "X-frango e X-burguer - Hamburguer de carne com queijo e calabresa + Hamburguer de frango com queijo e calabresa - R$4,75");
	}
	
	@Test
	void testarEditaComboFornecedorNulo() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", null, 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaComboFornecedorVazio() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", "", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaComboFornecedorNaoExiste() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", "Francisco", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarEditaComboFatorInvalido1() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", "Marcos", -0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: fator invalido.");
		}
	}
	
	@Test
	void testarEditaComboFatorInvalido2() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", "Marcos", 2);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: fator invalido.");
		}
	}
	
	@Test
	void testarEditaComboNomeNulo() {
		try {
			cf.editaCombo(null, "Arroz branco com feijao", "Marcos", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaComboNomeVazio() {
		try {
			cf.editaCombo("  ", "Arroz branco com feijao", "Marcos", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarEditaComboDescricaoNulo() {
		try {
			cf.editaCombo("Arroz com feijao", null, "Marcos", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarEditaComboDescricaoVazio() {
		try {
			cf.editaCombo("Arroz com feijao", " ", "Marcos", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarEditaComboProdutoNaoExiste() {
		try {
			cf.editaCombo("Arroz com feijao", "Arroz branco com feijao", "Marcos", 0.30);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro na edicao de combo: produto nao existe.");
		}
	}
	
	@Test
	void testarEditaCombo() {
		cf.editaCombo("X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja", "Marcos", 0.30);
		assertEquals(cf.exibeProduto("X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja", "Marcos"), "X-burguer + Suco - Hamburguer de carne com queijo e calabresa e suco de laranja - R$4,55");
	}
	
	@Test
	void testarAdicionarCompraCpfNulo() {
		try {
			cf.adicionaCompra(null, "Francisco", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionarCompraCpfVazio() {
		try {
			cf.adicionaCompra("", "Francisco", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionarCompraFornecedorNulo() {
		try {
			cf.adicionaCompra("09876543234", null, "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionarCompraFornecedorVazio() {
		try {
			cf.adicionaCompra("09876543234", " ", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testarAdicionarCompraDataNulo() {
		try {
			cf.adicionaCompra("09876543234", "Francisco", null, "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionarCompraDataVazio() {
		try {
			cf.adicionaCompra("09876543234", "Francisco", "", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionarCompraNomeProdutoNulo() {
		try {
			cf.adicionaCompra("09876543234", "Francisco", "27/05/2019", null, "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionarCompraNomeProdutoVazio() {
		try {
			cf.adicionaCompra("09876543234", "Francisco", "27/05/2019", " ", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarAdicionarCompraCpfInvalido() {
		try {
			cf.adicionaCompra("09876543", "Francisco", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: cpf invalido.");
		}
	}
	
	@Test
	void testarAdicionarCompraClienteNaoExiste() {
		try {
			cf.adicionaCompra("09876543234", "Francisco", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: cliente nao existe.");
		}
	}
	
	@Test
	void testarAdicionarCompraFornecedorNaoExiste() {
		try {
			cf.adicionaCompra("00023827490", "Francisco", "27/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarAdicionarCompraDescricaoProdutoNulo() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "27/05/2019", "Arroz com feijao", null);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionarCompraDescricaoProdutoVazio() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "27/05/2019", "Arroz com feijao", "");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testarAdicionarCompraDataInvalida1() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "7/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: data invalida.");
		}
	}
	
	@Test
	void testarAdicionarCompraDataInvalida2() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "07/5/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: data invalida.");
		}
	}
	
	@Test
	void testarAdicionarCompraDataInvalida3() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "07/05/19", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: data invalida.");
		}
	}
	
	@Test
	void testarAdicionarCompraProdutoNaoExiste() {
		try {
			cf.adicionaCompra("00023827490", "Marcos", "07/05/2019", "Arroz com feijao", "Arroz branco com feijao");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao cadastrar compra: produto nao existe.");
		}
	}
	
	@Test
	void testarAdicionarCompra() {
		cf.adicionaCompra("94412783134", "Marcos", "07/05/2019", "X-frango", "Hamburguer de frango com queijo e calabresa");
		assertEquals(cf.exibeContas("94412783134", "Marcos"), "Cliente: Wilson Andre | Marcos | X-frango - 07-05-2019");
	}
	
	@Test
	void testarGetDebitoCpfNulo() {
		try {
			cf.getDebito(null, "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarGetDebitoCpfVazio() {
		try {
			cf.getDebito("", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarGetDebitoFornecedorNulo() {
		try {
			cf.getDebito("00023827490", null);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarGetDebitoFornecedorVazio() {
		try {
			cf.getDebito("00023827490", "");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarGetDebitoCpfInvalido() {
		try {
			cf.getDebito("00023827", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: cpf invalido.");
		}
	}
	
	@Test
	void testarGetDebitoClienteNaoExiste() {
		try {
			cf.getDebito("00023827898", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: cliente nao existe.");
		}
	}
	
	@Test
	void testarGetDebitoFornecedorNaoExiste() {
		try {
			cf.getDebito("00023827490", "Marcio");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarGetDebitoClienteNaoPossuiConta() {
		try {
			cf.getDebito("94412783134", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
	}
	
	@Test
	void testarGetDebito() {
		assertEquals(cf.getDebito("00023827490", "Marcos"), "6.50");
	}
	
	@Test
	void testarExibeContasCpfNulo() {
		try {
			cf.exibeContas(null, "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasCpfVazio() {
		try {
			cf.exibeContas("", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasFornecedorNulo() {
		try {
			cf.exibeContas("00023827490", null);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasFornecedorVazio() {
		try {
			cf.exibeContas("00023827490", "");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasCpfInvalido() {
		try {
			cf.exibeContas("00023827", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testarExibeContasClienteNaoExiste() {
		try {
			cf.exibeContas("00023827898", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarExibeContasFornecedorNaoExiste() {
		try {
			cf.exibeContas("00023827490", "Marcio");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
	}
	
	@Test
	void testarExibeContasClienteNaoPossuiConta() {
		try {
			cf.exibeContas("94412783134", "Marcos");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	@Test
	void testarExibeContas() {
		assertEquals(cf.exibeContas("00023827490", "Marcos"), "Cliente: Victor Emanuel | Marcos | Suco - 22-01-2019 | X-burguer - 24-01-2019");
	}
	
	@Test
	void testarExibeContasClientesCpfNulo() {
		try {
			cf.exibeContasClientes(null);
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasClientesCpfVazio() {
		try {
			cf.exibeContasClientes("");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testarExibeContasClientesCpfInvalido() {
		try {
			cf.exibeContasClientes("00023827");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir contas do cliente: cpf invalido.");
		}
	}
	
	@Test
	void testarExibeContasClientesClienteNaoExiste() {
		try {
			cf.exibeContasClientes("00023827333");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir contas do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testarExibeContasClientesClienteNaoPossuiConta() {
		try {
			cf.exibeContasClientes("94412783134");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
	}
	
	@Test
	void testarExibeContasClientes() {
		assertEquals(cf.exibeContasClientes("00023827490"), "Cliente: Victor Emanuel | Helhao | Rubacao - 24-01-2019 | Marcos | Suco - 22-01-2019 | X-burguer - 24-01-2019");
	}
}
