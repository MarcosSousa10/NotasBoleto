package br.com.OthondeCarvalho.NotasBoletos.src.Controller;

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

import br.com.OthondeCarvalho.NotasBoletos.src.model.app.StatusDoPedido;
import br.com.OthondeCarvalho.NotasBoletos.src.repository.app.RepositoryStatusDoPedido;
@RestController
@CrossOrigin("*")
public class ControllerRepositoryStatusDoPedido {
    @Autowired
    private RepositoryStatusDoPedido repositoryStatusDoPedido;

    @GetMapping("/StatusDoPedido")
    public ResponseEntity<Object> StatusDoPedido(@RequestParam(value = "pedido", defaultValue = "") String pedido) {
        Optional<StatusDoPedido> campanhaOptional = repositoryStatusDoPedido.QueryStatus(pedido); 
        
        if (campanhaOptional.isPresent()) {
            return ResponseEntity.ok(campanhaOptional.get());
        } else {
            String errorMessage = "Pedido Não Encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
