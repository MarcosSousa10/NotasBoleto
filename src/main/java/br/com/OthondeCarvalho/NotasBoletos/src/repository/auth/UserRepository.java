package br.com.OthondeCarvalho.NotasBoletos.src.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.OthondeCarvalho.NotasBoletos.src.model.auth.user.User;




public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
