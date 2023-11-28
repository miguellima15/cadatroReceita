package com.example.backreceita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backreceita.Model.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {

    
}
