package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;
import io.quarkus.security.ForbiddenException;

@ApplicationScoped
public class OrdemService {

    @Inject OrdemRepository repository;
    
    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new ForbiddenException("O usuário é diferente do enviado!");
        }
        
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        repository.persist(ordem);
    }

    public List<Ordem> listar() {
        return repository.listAll();
    }

}
