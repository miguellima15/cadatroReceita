package com.example.backreceita.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backreceita.Model.Receita;
import com.example.backreceita.Repository.ReceitaRepositorio;
import com.example.backreceita.Service.ReceitaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<Receita> listar() {
        return receitaService.listarReceitas();
    }

    @PostMapping
    public Receita adicionar(@RequestBody Receita receita) {
        return receitaService.adicionarReceita(receita);
    }

    @PutMapping
    public Receita alterar(@RequestBody Receita receita) {
        return receitaService.alterarReceita(receita);
    }

    @DeleteMapping
    public String deletar(@RequestBody Receita receita) {
        return receitaService.deletarReceita(receita);
    }
}

