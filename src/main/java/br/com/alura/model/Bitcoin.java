package br.com.alura.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Bitcoin {
    private Long id;
    private Double preco;
    private String tipo;
    private LocalDate data;
}
