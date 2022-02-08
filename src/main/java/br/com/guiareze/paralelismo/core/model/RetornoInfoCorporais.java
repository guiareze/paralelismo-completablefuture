package br.com.guiareze.paralelismo.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetornoInfoCorporais {

    private BigDecimal altura;
    private BigDecimal peso;

}
