package br.com.OthondeCarvalho.NotasBoletos.src.model.app;


import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pcclient")
public class SegundaViaBoleto {
    @Id
    private Long codcliente;
    private String cpf;
    private String nome;
    private Long numnota;
    private Date dtemissao;
    private Long duplicata;
    private Date vencimento;
    private Double valor;
    private BigDecimal codbarraspagamento;
}
