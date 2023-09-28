package br.com.OthondeCarvalho.NotasBoletos.src.model.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import jakarta.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pcpedc")
public class StatusDoPedido {
    @Id
    private Long codcliente;
    private String cliente;
    private Long numped;
    private Date data;
    private Double valor;
    private String codcob;
    private String condicaopag;
    private String status;
}
