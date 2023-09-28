package br.com.OthondeCarvalho.NotasBoletos.src.model.app;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "pcnfsaid")
public class ChaveNfe {
    @Id
    private Long numnota;
    private Double valor;
    private java.sql.Date dtemissao;
    private BigDecimal chavenfe;
}
