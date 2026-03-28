package br.edu.ifgoiano.dao;

import java.util.List;
import br.edu.ifgoiano.model.Livro;

public interface LivroDAO {
    void salvar(Livro livro);
    void atualizar(Livro livro);
    void excluir(int id);
    Livro buscarPorId(int id);
    List<Livro> listarTodos();
    List<Livro> listarDisponiveis();
}
