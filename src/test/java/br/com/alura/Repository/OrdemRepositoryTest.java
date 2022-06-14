package br.com.alura.Repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OrdemRepositoryTest {
    
    @InjectMock OrdemRepository repository;
    
    @Test
    public void testIfListAllReturnOrders(){
        Ordem order1 = new Ordem();
        Ordem order2 = new Ordem();
        Ordem order3 = new Ordem();
        
        List<Ordem> orders = new ArrayList<Ordem>();
        
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        
        Mockito.when(repository.listAll()).thenReturn(orders);
        
        Assertions.assertSame(order2, repository.listAll().get(1));
    }
}
