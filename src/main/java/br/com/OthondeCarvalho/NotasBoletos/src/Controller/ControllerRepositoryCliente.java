package br.com.OthondeCarvalho.NotasBoletos.src.Controller;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.SegundaViaBoleto;
import br.com.OthondeCarvalho.NotasBoletos.src.model.app.pccliente;
import br.com.OthondeCarvalho.NotasBoletos.src.repository.app.RepositoryCliente;
import br.com.OthondeCarvalho.NotasBoletos.src.repository.app.RepositorySegundaViaBoleto;

@RestController
@CrossOrigin("*")
public class ControllerRepositoryCliente {

    @Autowired
    private RepositoryCliente repositoryCliente;
     @GetMapping("/Cliente")
     public ResponseEntity<Object> StatusDoPedido(@RequestParam(value = "cnpj", defaultValue = "") String cnpj) {
         Optional<pccliente> Optional = repositoryCliente.SelectCliente(cnpj); 
        
         if (Optional.isPresent()) {
            return ResponseEntity.ok(Optional.get());
       } else {
             String errorMessage = "CPF OU CNPJ NÃO ENCONTRADO";
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
         }
     }



}
