package com.example.backreceita.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backreceita.Model.Usuario;
import com.example.backreceita.Repository.UsuarioRepositorio;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repositorio;

    @GetMapping
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @PutMapping
    public Usuario alterar(@RequestBody Usuario usuario) {
        if (usuario.getId() > 0)
            return repositorio.save(usuario);
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody Usuario usuario) {
        if (usuario.getId() > 0) {
            repositorio.delete(usuario);
            return "Usuario removido com sucesso";

        }

        return "Usuario não encontrado";
    }

}

