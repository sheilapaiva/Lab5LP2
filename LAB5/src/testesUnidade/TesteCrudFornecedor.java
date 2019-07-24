package testesUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.CrudFornecedor;

class TesteCrudFornecedor {

	CrudFornecedor cf;
	
	@BeforeEach
	void setUP() {
		cf = new CrudFornecedor();
		cf.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		cf.adicionaFornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
		cf.adicionaProduto("Marcos", "X-frango", "Hamburguer de frango com queijo e calabresa", 5.00);
		cf.adicionaProduto("Marcos", "Suco", "Suco de laranja", 2.00);
		cf.adicionaProduto("Marcos", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		cf.adicionaProduto("Helhao", "Rubacao", "Feijao com arroz e queijo coalho", 14.00);
		cf.adicionaCombo("Marcos", "X-burguer + Suco", "Hamburguer de carne com queijo e calabresa e suco de laranja", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de laranja");
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
	
}
