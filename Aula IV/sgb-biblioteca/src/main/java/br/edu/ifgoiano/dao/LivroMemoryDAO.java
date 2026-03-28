package br.edu.ifgoiano.dao;

import br.edu.ifgoiano.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroMemoryDAO implements LivroDAO {
    private static List<Livro> dados = new ArrayList<>();

    @Override
    public void salvar(Livro l) {
        l.setId(dados.size() + 1);
        dados.add(l);
    }

    @Override
    public void atualizar(Livro l) {
        Livro existente = buscarPorId(l.getId());
        if (existente != null) {
            existente.setTitulo(l.getTitulo());
            existente.setAutor(l.getAutor());
            existente.setDisponivel(l.isDisponivel());
        }
    }

    @Override
    public void excluir(final int id) {
        dados.removeIf(l -> l.getId() == id);
    }

    @Override
    public Livro buscarPorId(final int id) {
        return dados.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(dados);
    }

    @Override
    public List<Livro> listarDisponiveis() {
        return dados.stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }
}
