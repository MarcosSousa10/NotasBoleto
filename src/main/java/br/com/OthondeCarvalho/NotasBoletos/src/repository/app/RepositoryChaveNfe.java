package br.com.OthondeCarvalho.NotasBoletos.src.repository.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.ChaveNfe;

public interface RepositoryChaveNfe extends JpaRepository<ChaveNfe,Long> {
    @Query(value = "select numnota, vltotal as Valor, dtsaida as DtEmissao ,chavenfe "+
    "from pcnfsaid where codcli in (select codcli from pcclient c where "+
    "REPLACE(REPLACE(REPLACE(REPLACE(c.cgcent,' ',''),'.',''),'-',''),'/','') "+
    "= REPLACE(REPLACE(REPLACE(REPLACE(?1,' ',''),'.',''),'-',''),'/','')) "+
    "and dtcancel is null and dtsaida > sysdate -365 order by dtsaida", nativeQuery = true)
  List<ChaveNfe> ChaveNfeNotasemitidasamenosde1ano(String cnpj);
}
