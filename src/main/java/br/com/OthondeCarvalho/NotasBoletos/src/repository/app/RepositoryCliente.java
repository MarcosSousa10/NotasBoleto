package br.com.OthondeCarvalho.NotasBoletos.src.repository.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.ChaveNfe;
import br.com.OthondeCarvalho.NotasBoletos.src.model.app.SegundaViaBoleto;
import br.com.OthondeCarvalho.NotasBoletos.src.model.app.pccliente;

public interface RepositoryCliente extends JpaRepository<pccliente,Long>{
     @Query(value = "select codcli from pcclient where REPLACE(REPLACE(REPLACE(REPLACE(cgcent,' ',''),'.',''),'-',''),'/','') = "+
      " REPLACE(REPLACE(REPLACE(REPLACE(?1,' ',''),'.',''),'-',''),'/','') ", nativeQuery = true)
  Optional<pccliente> SelectCliente(String cnpj);
}
