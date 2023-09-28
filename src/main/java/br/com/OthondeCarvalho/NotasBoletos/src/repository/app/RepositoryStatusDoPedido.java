package br.com.OthondeCarvalho.NotasBoletos.src.repository.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.StatusDoPedido;

public interface RepositoryStatusDoPedido extends JpaRepository<StatusDoPedido,Long>{
     @Query(value = "select t.codcli as CodCliente, t.cliente , c.numped , c.data , "+
     "c.vlatend as valor , c.codcob , p.descricao as CondicaoPag, "+
     "(case when (dtfat is not null ) and (dtinicialsep is null) and "+
     "(dtfinalsep is null) then 'Pedido Faturado' "+
     "when  (dtfat is not null ) and (dtinicialsep is not null) and "+
     "(dtfinalsep is null) then 'Pedido em Separação' "+
     "when  (dtfat is not null ) and (dtinicialsep  is not null) and "+
     "(dtfinalsep is not null) then 'Pedido Pronto' "+
     "when   (dtfat is null ) and (dtinicialsep is null) and (dtfinalsep is "+
     "null) then 'Pedido Emitido' "+
     "when   (c.posicao = 'P') or (c.posicao = 'B') then 'Pedido aguardando "+
     "liberação' "+
     "end ) Status "+
     "from pcpedc c , pcclient t, pcplpag p "+
     "where "+
     "p.codplpag = c.codplpag and "+
     "c.codcli = t.codcli and "+
     "c.numped = ?1 and "+
     "c.dtcancel is null and "+
     "c.posicao in ('P', 'B', 'L', 'M', 'F') ", nativeQuery = true)
  Optional<StatusDoPedido> QueryStatus(String cod);
}
