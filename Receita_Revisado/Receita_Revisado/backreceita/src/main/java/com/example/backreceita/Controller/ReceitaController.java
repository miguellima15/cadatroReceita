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

import com.example.backreceita.Model.Receita;
import com.example.backreceita.Repository.ReceitaRepositorio;

@RestController
@RequestMapping("api/receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepositorio repositorio;

    @GetMapping
    public List<Receita> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Receita adicionar(@RequestBody Receita receita) {
        return repositorio.save(receita);
    }

    @PutMapping
    public Receita alterar(@RequestBody Receita receita) {
        if (receita.getId() > 0)
            return repositorio.save(receita);
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody Receita receita) {
        if (receita.getId() > 0) {
            repositorio.delete(receita);
            return "Receita removido com sucesso";

        }

        return "Receita não encontrado";
    }

}
