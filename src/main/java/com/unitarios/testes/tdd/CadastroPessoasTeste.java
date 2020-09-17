package com.unitarios.testes.tdd;
import org.assertj.core.api.Assertions;

import org.junit.Test;

public class CadastroPessoasTeste {

    @Test
    public void deveCriarOCadastrodepessoas(){
        //cenario e execucao
        CadastroPessoas cadastro = new CadastroPessoas();


        //verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();//isEmpty espera que nao volte vazio

    }
    @Test
    public void addUmaPessoa(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Djenifer");

        cadastro.adicionar(pessoa);

        // quero garantir que a pessoa  vai ta add la dentro
        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty() // nao esta vazio
                .hasSize(1)// só contem uma pesssoa
                .contains(pessoa);// contem algo


    }
    @Test(expected = PessoasemNomeException.class)
    public void naoDeveAddPessoaComNomeVazio(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastro.adicionar(pessoa);
    }
    @Test
    public void removerUmaPessoa(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Djenifer");

        cadastro.adicionar(pessoa);

        cadastro.remover(pessoa);

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }
    @Test(expected = CadastroVazioException.class)
    public void naoDeveRetornarPessoaInesistente(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastro.remover(pessoa);


    }

}
