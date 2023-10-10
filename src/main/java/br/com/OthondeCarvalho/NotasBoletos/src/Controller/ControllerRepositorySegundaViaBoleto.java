package br.com.OthondeCarvalho.NotasBoletos.src.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.ChaveNfe;
import br.com.OthondeCarvalho.NotasBoletos.src.model.app.SegundaViaBoleto;
import br.com.OthondeCarvalho.NotasBoletos.src.repository.app.RepositorySegundaViaBoleto;
@RestController
@CrossOrigin("*")
public class ControllerRepositorySegundaViaBoleto {
    @Autowired
    private RepositorySegundaViaBoleto repositorySegundaViaBoleto;

    // @GetMapping("/SegundaViaBoleto")
    // public ResponseEntity<Object> StatusDoPedido(@RequestParam(value = "cnpj", defaultValue = "") String cnpj) {
    //     Optional<SegundaViaBoleto> Optional = repositorySegundaViaBoleto.QuerySegundaViaBoleto(cnpj); 
        
    //     if (Optional.isPresent()) {
    //         return ResponseEntity.ok(Optional.get());
    //     } else {
    //         String errorMessage = "CPF OU CNPJ NÃO ENCONTRADO";
    //         return ResponseEntity.status(HttpStatus.OK).body(errorMessage);
    //     }
    // }
           @GetMapping("/SegundaViaBoleto")
    public ResponseEntity<?> StatusDoPedido(@RequestParam(value = "cnpj", defaultValue = "") String cnpj) {
         List<SegundaViaBoleto> Optional = repositorySegundaViaBoleto.QuerySegundaViaBoleto(cnpj); 
        
        if (!Optional.isEmpty()) {
            return ResponseEntity.ok(Optional);
        } else {
            String errorMessage = "BOLETO NÃO ENCONTRADO";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
     }  
}
