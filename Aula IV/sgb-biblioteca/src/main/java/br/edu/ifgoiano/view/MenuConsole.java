package br.edu.ifgoiano.view;

import br.edu.ifgoiano.controller.BibliotecaController;
import br.edu.ifgoiano.model.Livro;
import java.util.List;
import java.util.Scanner;

public class MenuConsole {
    private static BibliotecaController controller = new BibliotecaController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Sistema de Gestão de Biblioteca (SGB) ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros Disponíveis");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Todos os Livros");
            System.out.println("6. Excluir Livro (Desafio)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarLivro();
                        break;
                    case 2:
                        listarLivrosDisponiveis();
                        break;
                    case 3:
                        realizarEmprestimo();
                        break;
                    case 4:
                        devolverLivro();
                        break;
                    case 5:
                        listarTodosLivros();
                        break;
                    case 6:
                        excluirLivro();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                opcao = -1;
            }
        }
    }

    private static void cadastrarLivro() {
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do Livro: ");
        String autor = scanner.nextLine();

        String mensagem = controller.cadastrarLivro(titulo, autor);
        System.out.println(mensagem);
    }

    private static void listarLivrosDisponiveis() {
        List<Livro> livros = controller.listarLivrosDisponiveis();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível no momento.");
        } else {
            System.out.println("\n--- Livros Disponíveis ---");
            livros.forEach(System.out::println);
        }
    }

    private static void listarTodosLivros() {
        List<Livro> livros = controller.listarTodosLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\n--- Todos os Livros ---");
            livros.forEach(System.out::println);
        }
    }

    private static void realizarEmprestimo() {
        System.out.print("ID do Livro: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Leitor: ");
        String nomeLeitor = scanner.nextLine();

        String mensagem = controller.realizarEmprestimo(id, nomeLeitor);
        System.out.println(mensagem);
    }

    private static void devolverLivro() {
        System.out.print("ID do Livro para Devolver: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensagem = controller.devolverLivro(id);
        System.out.println(mensagem);
    }

    private static void excluirLivro() {
        System.out.print("ID do Livro para Excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensagem = controller.excluirLivro(id);
        System.out.println(mensagem);
    }
}
