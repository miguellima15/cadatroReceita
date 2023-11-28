package com.example.backreceita.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "receita")
@Getter
@Setter
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tidareceita;

    private String modepreparo;

    private boolean vegana;

    @ManyToOne
    private Usuario usuario;

    public Receita() {
    }

    
    // Construtores, getters, setters...
}
