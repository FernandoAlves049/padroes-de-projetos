package br.edu.ifgoiano.controller;

import br.edu.ifgoiano.bo.LivroBO;
import br.edu.ifgoiano.bo.EmprestimoBO;
import br.edu.ifgoiano.model.Livro;
import java.util.List;

public class BibliotecaController {
    private LivroBO livroBO;
    private EmprestimoBO emprestimoBO;

    public BibliotecaController() {
        this.livroBO = new LivroBO();
        this.emprestimoBO = new EmprestimoBO();
    }

    public String cadastrarLivro(String titulo, String autor) {
        try {
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livroBO.cadastrarLivro(livro);
            return "Livro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar livro: " + e.getMessage();
        }
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livroBO.listarDisponiveis();
    }

    public List<Livro> listarTodosLivros() {
        return livroBO.listarTodos();
    }

    public String realizarEmprestimo(int idLivro, String nomeLeitor) {
        try {
            emprestimoBO.realizarEmprestimo(idLivro, nomeLeitor);
            return "Empréstimo realizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao realizar empréstimo: " + e.getMessage();
        }
    }

    public String devolverLivro(int idLivro) {
        try {
            emprestimoBO.devolverLivro(idLivro);
            return "Livro devolvido com sucesso!";
        } catch (Exception e) {
            return "Erro ao devolver livro: " + e.getMessage();
        }
    }

    public String excluirLivro(int id) {
        try {
            livroBO.excluirLivro(id);
            return "Livro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir livro: " + e.getMessage();
        }
    }
}
