package br.com.guiareze.paralelismo.core.service;

import br.com.guiareze.paralelismo.controller.dto.RetornoConsultaDto;
import br.com.guiareze.paralelismo.core.model.RetornoInfoCorporais;
import br.com.guiareze.paralelismo.core.model.RetornoInfoEndereco;
import br.com.guiareze.paralelismo.core.model.RetornoInfoPessoais;
import br.com.guiareze.paralelismo.core.ports.controller.PesquisaDados;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PesquisaDadosImpl implements PesquisaDados {

    @Override
    public RetornoConsultaDto buscarDados() {

        System.out.println("============================================");

        final CompletableFuture<RetornoInfoPessoais> retornoInfoPessoaisFuture =
                CompletableFuture.supplyAsync(this::retornaInfoPessoais);
        final CompletableFuture<RetornoInfoCorporais> retornoInfoCorporaisFuture =
                CompletableFuture.supplyAsync(this::retornoInfoCorporais);
        final CompletableFuture<RetornoInfoEndereco> retornoInfoEnderecoFuture =
                CompletableFuture.supplyAsync(this::retornoInfoEndereco);

        try {

            final RetornoInfoPessoais retornoInfoPessoais =
                    retornoInfoPessoaisFuture.get();
            final RetornoInfoCorporais retornoInfoCorporais =
                    retornoInfoCorporaisFuture.get();
            final RetornoInfoEndereco retornoInfoEndereco =
                    retornoInfoEnderecoFuture.get();

            System.out.println("============================================");

            return new RetornoConsultaDto(retornoInfoPessoais.getNome(),
                    retornoInfoPessoais.getIdade(),
                    retornoInfoCorporais.getAltura(),
                    retornoInfoCorporais.getPeso(),
                    retornoInfoEndereco.getEndereco(),
                    retornoInfoEndereco.getComplemento());

        } catch (InterruptedException | ExecutionException e){
            System.out.println("findResume process error" + e);
            throw new RuntimeException();
        }

    }

    private RetornoInfoPessoais retornaInfoPessoais(){
        System.out.println("Inicio processamento info pessoais..");
        return new RetornoInfoPessoais("TESTE GUI",26);
    }

    private RetornoInfoCorporais retornoInfoCorporais(){
        System.out.println("Inicio processamento info corporais..");
        return new RetornoInfoCorporais(new BigDecimal("1.86"), new BigDecimal("113.6"));
    }

    private RetornoInfoEndereco retornoInfoEndereco(){
        System.out.println("Inicio processamento info enderecos..");
        return new RetornoInfoEndereco("Rua Teste", "bloco x apto w");
    }

}
