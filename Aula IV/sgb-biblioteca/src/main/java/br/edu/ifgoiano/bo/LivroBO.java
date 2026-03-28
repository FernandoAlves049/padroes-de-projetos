package br.edu.ifgoiano.bo;

import br.edu.ifgoiano.dao.LivroDAO;
import br.edu.ifgoiano.dao.LivroMemoryDAO;
import br.edu.ifgoiano.model.Livro;
import java.util.List;

public class LivroBO {
    private LivroDAO livroDAO;

    public LivroBO() {
        this.livroDAO = new LivroMemoryDAO();
    }

    public void cadastrarLivro(Livro livro) throws Exception {
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new Exception("O título do livro não pode ser vazio!");
        }
        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            throw new Exception("O autor do livro não pode ser vazio!");
        }
        livroDAO.salvar(livro);
    }

    public void excluirLivro(int id) throws Exception {
        Livro livro = livroDAO.buscarPorId(id);
        if (livro == null) {
            throw new Exception("Livro não encontrado!");
        }
        
        // REGRA DE DESAFIO: Não excui se estiver emprestado
        if (!livro.isDisponivel()) {
            throw new Exception("Não é possível excluir um livro que está emprestado!");
        }
        
        livroDAO.excluir(id);
    }

    public List<Livro> listarTodos() {
        return livroDAO.listarTodos();
    }

    public List<Livro> listarDisponiveis() {
        return livroDAO.listarDisponiveis();
    }
    
    public Livro buscarPorId(int id) {
        return livroDAO.buscarPorId(id);
    }
}
