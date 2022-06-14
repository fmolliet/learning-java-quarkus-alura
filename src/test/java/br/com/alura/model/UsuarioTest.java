package br.com.alura.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {
    
    @Test
    public void testIfFindByIdOptionalReturnUser(){
        PanacheMock.mock(Usuario.class);
        
        Usuario user = new Usuario();
        
        Optional<PanacheEntityBase> usuario = Optional.of(user);
        
        Mockito.when(Usuario.findByIdOptional(40)).thenReturn(usuario);
        
        Assertions.assertSame(user, Usuario.findByIdOptional(40).get());
    }
}
