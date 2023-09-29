package br.com.OthondeCarvalho.NotasBoletos.src.repository.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.SegundaViaBoleto;

public interface RepositorySegundaViaBoleto extends JpaRepository<SegundaViaBoleto,Long>{
         @Query(value = "select  C.CGCENT AS CPF, t.codcli as CodCliente, c.cliente as "+ 
         "Nome, d.numnota as Numnota, d.dtsaida as DtEmissao ,t.duplic as "+
         "Duplicata, t.dtvenc as Vencimento,  t.valor as Valor, t.codbarra "+
         "AS CodBarrasPagamento "+
         "from pcclient c, pcprest t, pcnfsaid d "+
         "where "+
         "d.numtransvenda = t.numtransvenda and "+
         "c.codcli = t.codcli and "+
         "REPLACE(REPLACE(REPLACE(REPLACE(c.cgcent,' ',''),'.',''),'-',''),'/','') "+
         "= REPLACE(REPLACE(REPLACE(REPLACE(?1,' ',''),'.',''),'-',''),'/','') and "+
         "t.dtpag is null and "+
         "t.dtcancel is null AND "+
         "d.dtcancel is null and "+
         "t.codcob in ('BRAS', 'BK', 'BBCS') "+
         "order by t.dtvenc", nativeQuery = true)
  List<SegundaViaBoleto> QuerySegundaViaBoleto(String cnpj);
}
