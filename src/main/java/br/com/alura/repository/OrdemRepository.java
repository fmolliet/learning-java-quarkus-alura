package br.com.alura.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
// Formato de acesso da base de dados como repository
@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}
