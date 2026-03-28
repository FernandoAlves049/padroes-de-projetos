package br.edu.ifgoiano.dao;

import br.edu.ifgoiano.model.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoMemoryDAO implements EmprestimoDAO {
    private static List<Emprestimo> dados = new ArrayList<>();

    @Override
    public void salvar(Emprestimo e) {
        e.setId(dados.size() + 1);
        dados.add(e);
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(dados);
    }

    @Override
    public Emprestimo buscarPorLivroId(final int idLivro) {
        return dados.stream()
                .filter(e -> e.getIdLivro() == idLivro)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void excluir(final int id) {
        dados.removeIf(e -> e.getId() == id);
    }
}
