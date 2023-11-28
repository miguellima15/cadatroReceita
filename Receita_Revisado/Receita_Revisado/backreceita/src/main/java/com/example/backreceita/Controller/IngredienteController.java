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

import com.example.backreceita.Model.Ingrediente;
import com.example.backreceita.Repository.IngredienteRepositorio;

@RestController
@RequestMapping("api/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteRepositorio repositorio;

    @GetMapping
    public List<Ingrediente> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Ingrediente cadastrar(@RequestBody Ingrediente ingrediente) {
        return repositorio.save(ingrediente);
    }

    @PutMapping
    public Ingrediente alterar(@RequestBody Ingrediente ingrediente) {
        if (ingrediente.getId() > 0)
        return repositorio.save(ingrediente);
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody Ingrediente ingrediente) {
        if (ingrediente.getId() > 0) {
        repositorio.delete(ingrediente);
        return "Ingrediente removido com sucesso";

    }

    return "Não localizado";

}

}

