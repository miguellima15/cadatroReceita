package com.example.backreceita.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backreceita.Model.Receita;
import com.example.backreceita.Repository.ReceitaRepositorio;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepositorio repositorio;

    public List<Receita> listarReceitas() {
        return repositorio.findAll();
    }

    public Receita adicionarReceita(Receita receita) {
        return repositorio.save(receita);
    }

    public Receita alterarReceita(Receita receita) {
        if (receita.getId() > 0) {
            return repositorio.save(receita);
        }
        return null;
    }

    public String deletarReceita(Receita receita) {
        if (receita.getId() > 0) {
            repositorio.delete(receita);
            return "Receita removida com sucesso";
        }
        return "Receita não encontrada";
    }
}

