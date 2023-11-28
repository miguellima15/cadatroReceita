package com.example.backreceita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backreceita.Model.Receita;

public interface ReceitaRepositorio extends JpaRepository <Receita, Long> {
    
    
} 
