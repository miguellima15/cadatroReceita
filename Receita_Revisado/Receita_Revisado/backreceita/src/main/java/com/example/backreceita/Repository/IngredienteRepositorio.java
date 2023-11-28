package com.example.backreceita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backreceita.Model.Ingrediente;

public interface IngredienteRepositorio extends JpaRepository <Ingrediente, Long> {
    
}