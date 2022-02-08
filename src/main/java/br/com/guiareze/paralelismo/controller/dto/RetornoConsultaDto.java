package br.com.guiareze.paralelismo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetornoConsultaDto {

    private String nome;
    private Integer idade;
    private BigDecimal altura;
    private BigDecimal peso;
    private String endereco;
    private String complemento;

}
