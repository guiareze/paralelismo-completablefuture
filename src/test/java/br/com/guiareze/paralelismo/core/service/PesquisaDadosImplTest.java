package br.com.guiareze.paralelismo.core.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class PesquisaDadosImplTest {

    @InjectMocks
    private PesquisaDadosImpl pesquisaDados;

    @Test
    void validarMetodoComParalelismo(){

        var retorno = pesquisaDados.buscarDados();

        // não há o que mockar..
        assertThat(retorno).isNotNull();

    }

}