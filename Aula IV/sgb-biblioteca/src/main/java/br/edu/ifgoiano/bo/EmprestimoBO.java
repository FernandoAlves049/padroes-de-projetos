package br.edu.ifgoiano.bo;

import br.edu.ifgoiano.dao.EmprestimoDAO;
import br.edu.ifgoiano.dao.EmprestimoMemoryDAO;
import br.edu.ifgoiano.dao.LivroDAO;
import br.edu.ifgoiano.dao.LivroMemoryDAO;
import br.edu.ifgoiano.model.Emprestimo;
import br.edu.ifgoiano.model.Livro;
import java.util.List;

public class EmprestimoBO {
    private EmprestimoDAO emprestimoDAO;
    private LivroDAO livroDAO;

    public EmprestimoBO() {
        this.emprestimoDAO = new EmprestimoMemoryDAO();
        this.livroDAO = new LivroMemoryDAO();
    }

    public void realizarEmprestimo(int idLivro, String leitor) throws Exception {
        Livro livro = livroDAO.buscarPorId(idLivro);
        
        // REGRA 1: O livro existe?
        if (livro == null) {
            throw new Exception("Livro de ID " + idLivro + " não encontrado!");
        }
        
        // REGRA 2: O livro está disponível?
        if (!livro.isDisponivel()) {
            throw new Exception("Este livro já está emprestado!");
        }
        
        // REGRA 3: O leitor não é vazio?
        if (leitor == null || leitor.trim().isEmpty()) {
            throw new Exception("O nome do leitor não pode ser vazio!");
        }

        // Se passou pelas regras, prossegue:
        livro.setDisponivel(false); // Altera o estado do model
        livroDAO.atualizar(livro); // Persiste a mudança
        
        Emprestimo e = new Emprestimo(idLivro, leitor);
        emprestimoDAO.salvar(e); // Salva o empréstimo
    }

    public void devolverLivro(int idLivro) throws Exception {
        Livro livro = livroDAO.buscarPorId(idLivro);
        if (livro == null) {
            throw new Exception("Livro não encontrado!");
        }

        if (livro.isDisponivel()) {
            throw new Exception("Este livro já está disponível no estoque!");
        }

        // Buscar o empréstimo correspondente para "encerrar"
        Emprestimo e = emprestimoDAO.buscarPorLivroId(idLivro);
        if (e != null) {
            emprestimoDAO.excluir(e.getId());
        }

        livro.setDisponivel(true);
        livroDAO.atualizar(livro);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoDAO.listarTodos();
    }
}
