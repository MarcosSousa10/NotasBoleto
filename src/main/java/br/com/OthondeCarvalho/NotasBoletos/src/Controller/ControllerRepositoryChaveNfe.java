package br.com.OthondeCarvalho.NotasBoletos.src.Controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.ChaveNfe;
import br.com.OthondeCarvalho.NotasBoletos.src.repository.app.RepositoryChaveNfe;
@RestController
@CrossOrigin("*")
public class ControllerRepositoryChaveNfe {
    @Autowired
    private RepositoryChaveNfe ChaveNfe;

    @GetMapping("/ChaveNfe")
    public ResponseEntity<Object> StatusDoPedido(@RequestParam(value = "cnpj", defaultValue = "") String cnpj) {
        Optional<ChaveNfe> Optional = ChaveNfe.ChaveNfeNotasemitidasamenosde1ano(cnpj); 
        
        if (Optional.isPresent()) {
            return ResponseEntity.ok(Optional.get());
        } else {
            String errorMessage = "CPF OU CNPJ NÃO ENCONTRADO";
            return ResponseEntity.status(HttpStatus.OK).body(errorMessage);
        }
    }
}
