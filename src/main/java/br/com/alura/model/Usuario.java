package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.wildfly.security.password.interfaces.BCryptPassword;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

// Acesso a base de dados como Active Record
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@UserDefinition
public class Usuario extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String cpf;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;
    
    public static void adicionar ( Usuario usuario ){
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.role = validarUsername(usuario.username);
        usuario.persist();
    }
    
    private static String validarUsername( String username ){
        if ( "alura".equals(username) ){
            return "admin";
        } 
        return "user";
    }
}
