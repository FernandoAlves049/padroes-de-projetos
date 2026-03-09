import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class GUIApp {

    static final String SEP = "\n" + "=".repeat(60) + "\n";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Demonstração Princípios SOLID - Execução Individual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 650);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setBackground(new Color(30, 30, 30));
        textArea.setForeground(new Color(200, 200, 200));
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        redirectSystemOut(textArea);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(40, 40, 40));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnSRP = createButton("SRP", new Color(33, 150, 243));
        JButton btnOCP = createButton("OCP", new Color(156, 39, 176));
        JButton btnLSP = createButton("LSP", new Color(255, 152, 0));
        JButton btnISP = createButton("ISP", new Color(0, 188, 212));
        JButton btnDIP = createButton("DIP", new Color(233, 30, 99));
        JButton btnAll = createButton("TODOS", new Color(76, 175, 80));
        JButton btnExplain = createButton("Explicar Princípios", new Color(255, 87, 34));
        JButton btnClear = createButton("Limpar Terminal", new Color(244, 67, 54));

        topPanel.add(new JLabel("<html><font color='white'>Executar:</font></html>"));
        topPanel.add(btnSRP);
        topPanel.add(btnOCP);
        topPanel.add(btnLSP);
        topPanel.add(btnISP);
        topPanel.add(btnDIP);
        topPanel.add(new JLabel(" | "));
        topPanel.add(btnAll);
        topPanel.add(btnExplain);
        topPanel.add(btnClear);

        frame.add(topPanel, BorderLayout.NORTH);

        btnClear.addActionListener(e -> textArea.setText(""));

        addAction(btnSRP, textArea, () -> {
            System.out.println(SEP);
            System.out.println("   SOLID — Single Responsibility Principle (SRP)");
            System.out.println(SEP);
            srp.incorreto.SRPIncorreto.main(new String[] {});
            System.out.println(SEP);
            srp.correto.SRPCorreto.main(new String[] {});
        });

        addAction(btnOCP, textArea, () -> {
            System.out.println(SEP);
            System.out.println("   SOLID — Open/Closed Principle (OCP)");
            System.out.println(SEP);
            ocp.incorreto.OCPIncorreto.main(new String[] {});
            System.out.println(SEP);
            ocp.correto.OCPCorreto.main(new String[] {});
        });

        addAction(btnLSP, textArea, () -> {
            System.out.println(SEP);
            System.out.println("   SOLID — Liskov Substitution Principle (LSP)");
            System.out.println(SEP);
            lsp.incorreto.LSPIncorreto.main(new String[] {});
            System.out.println(SEP);
            lsp.correto.LSPCorreto.main(new String[] {});
        });

        addAction(btnISP, textArea, () -> {
            System.out.println(SEP);
            System.out.println("   SOLID — Interface Segregation Principle (ISP)");
            System.out.println(SEP);
            isp.incorreto.ISPIncorreto.main(new String[] {});
            System.out.println(SEP);
            isp.correto.ISPCorreto.main(new String[] {});
        });

        addAction(btnDIP, textArea, () -> {
            System.out.println(SEP);
            System.out.println("   SOLID — Dependency Inversion Principle (DIP)");
            System.out.println(SEP);
            dip.incorreto.DIPIncorreto.main(new String[] {});
            System.out.println(SEP);
            dip.correto.DIPCorreto.main(new String[] {});
        });

        addAction(btnAll, textArea, () -> {
            App.main(new String[] {});
        });

        addAction(btnExplain, textArea, () -> {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║                SOLID — O QUE SÃO OS PRINCÍPIOS?                 ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");

            System.out.println("\n[S]SRP - Single Responsibility Principle (Princípio da Responsabilidade Única)");
            System.out.println("   ▶ Uma classe deve ter um, e somente um, motivo para mudar.");
            System.out.println("     Exemplo: Uma classe que calcula salário não deve salvar no banco de dados.");

            System.out.println("\n[O]OCP - Open/Closed Principle (Princípio Aberto/Fechado)");
            System.out.println(
                    "   ▶ Entidades de software devem ser abertas para extensão, mas fechadas para modificação.");
            System.out.println(
                    "     Exemplo: Adicionar um novo tipo de desconto criando uma nova classe, sem mexer nas existentes.");

            System.out.println("\n[L]LSP - Liskov Substitution Principle (Princípio da Substituição de Liskov)");
            System.out.println("   ▶ Classes derivadas devem poder substituir suas bases sem quebrar o programa.");
            System.out
                    .println("     Exemplo: Se Quadrado herda de Retângulo, usar um Quadrado no lugar de um Retângulo");
            System.out.println("     não deve causar comportamentos inesperados no cálculo de área.");

            System.out.println("\n[I]ISP - Interface Segregation Principle (Princípio da Segregação da Interface)");
            System.out.println("   ▶ Muitas interfaces específicas são melhores do que uma interface geral.");
            System.out.println("     Exemplo: Não forçar uma classe `Estagiario` a implementar métodos de gerência");
            System.out.println("     que ela nunca vai usar.");

            System.out.println("\n[D]DIP - Dependency Inversion Principle (Princípio da Inversão de Dependência)");
            System.out.println("   ▶ Dependa de abstrações e não de implementações concretas.");
            System.out.println("     Exemplo: Uma classe `Pedido` deve depender de uma interface `BancoDeDados`,");
            System.out.println("     e não de uma classe específica `MySQL` diretamente.");

            System.out.println("\n╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("║            SOBRE ESTE PROJETO DEMONSTRATIVO (CÓDIGO)            ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("\n   ▶ ESTRUTURA DOS ARQUIVOS:");
            System.out.println("      O código-fonte está dividido em 5 pastas: srp/, ocp/, lsp/, isp/ e dip/.");
            System.out.println("      Dentro de cada pasta, há o exemplo `incorreto/` (que viola o princípio)");
            System.out.println("      e o exemplo `correto/` (que aplica as melhores práticas do SOLID).\n");

            System.out.println("   ▶ COMO O CÓDIGO FUNCIONA:");
            System.out.println(
                    "      ✅ SRP: Quebra a 'Super Classe' Funcionario em classes menores (Calculadora, Relatorio, Repositorio).");
            System.out.println(
                    "      ✅ OCP: Troca 'if/else' de descontos por uma interface 'Desconto' que é implementada por cada tipo (VIP, Ouro, etc).");
            System.out.println(
                    "      ✅ LSP: Impede o 'Quadrado' de quebrar o 'Retângulo', criando uma interface geral 'Forma'.");
            System.out.println(
                    "      ✅ ISP: Segrega a interface 'Trabalhador'. Um 'Estagiário' assina apenas o que precisa, não 'Gerenciar'.");
            System.out.println(
                    "      ✅ DIP: O sistema de envio de Pedidos agora recebe 'interfaces' (BancoDeDados, Notificacao), em vez de classes fixas (MySQL).");
            System.out.println("\n" + SEP);
        });

        frame.setVisible(true);
    }

    private static JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private static void addAction(JButton btn, JTextArea textArea, Runnable action) {
        btn.addActionListener(e -> {
            btn.setEnabled(false);
            textArea.setText("");
            System.out.println("Executando: " + btn.getText() + "...\n");

            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        action.run();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void done() {
                    btn.setEnabled(true);
                }
            }.execute();
        });
    }

    private static void redirectSystemOut(JTextArea textArea) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) {
                updateTextArea(new String(b, off, len));
            }

            private void updateTextArea(final String text) {
                SwingUtilities.invokeLater(() -> {
                    textArea.append(text);
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                });
            }
        };

        try {
            System.setOut(new PrintStream(out, true, "UTF-8"));
            System.setErr(new PrintStream(out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.setOut(new PrintStream(out, true));
            System.setErr(new PrintStream(out, true));
        }
    }
}
