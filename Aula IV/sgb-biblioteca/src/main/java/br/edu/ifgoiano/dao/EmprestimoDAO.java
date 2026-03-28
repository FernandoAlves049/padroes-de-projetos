package br.edu.ifgoiano.dao;

import java.util.List;
import br.edu.ifgoiano.model.Emprestimo;

public interface EmprestimoDAO {
    void salvar(Emprestimo emprestimo);
    List<Emprestimo> listarTodos();
    Emprestimo buscarPorLivroId(int idLivro);
    void excluir(int id);
}
