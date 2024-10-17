import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import javax.swing.JTextArea;


public class OficinaMecanicaUI {

    public void criarTela() {
        JFrame frame = new JFrame("Sistema de Oficina Mecânica");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Carregar a imagem da logo
        ImageIcon logo = new ImageIcon("C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos\\logoOficinaMecanica.jpg");

        // Criar um JLabel com a imagem da logo
        JLabel logoLabel = new JLabel(logo);

        // Adicionar o JLabel com a logo ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(logoLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);

        // Campos de texto
        JTextField nomeField = new JTextField(20);
        JTextField cpfField = new JTextField(20);
        JTextField enderecoField = new JTextField(20);
        JTextField cepField = new JTextField(20);
        JTextField cidadeField = new JTextField(20);
        JTextField telefoneField = new JTextField(20);
        JTextField veiculoField = new JTextField(20);
        JTextField placaField = new JTextField(20);
        JTextField orcamentoField = new JTextField(20);
        JTextArea ordemServicoArea = new JTextArea(6, 30);  // 3 linhas, 30 colunas

        // Botão de salvar
        JButton salvarButton = new JButton("Salvar");

        // Definindo o alinhamento à esquerda para o texto descriçao dos boxes
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Nome do cliente:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("CPF/CNPJ do cliente:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Endereço:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(enderecoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("CEP:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cepField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Cidade:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(cidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Modelo do veículo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(veiculoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Placa:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(placaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Valor do orçamento R$:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(orcamentoField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(salvarButton, gbc);

        JButton buscarButton = new JButton("Buscar Cliente");
        gbc.gridx = 1;
        gbc.gridy = 11;
        panel.add(buscarButton, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Configuração do campo Ordem de Serviço
        gbc.gridx = 2;  // Colocando na terceira coluna
        gbc.gridy = 1;  // Na primeira linha (ajuste conforme necessário)
        gbc.gridwidth = 2;  // Ocupar duas colunas
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Para expandir horizontalmente
        panel.add(new JLabel("Ordem de Serviço:"), gbc);

        // Adicionar o JTextArea ao painel
        gbc.gridx = 2;
        gbc.gridy = 2;  // Próxima linha
        gbc.gridheight = 6;  // Ocupar três linhas
        gbc.fill = GridBagConstraints.BOTH;  // Expansão em ambas direções
        panel.add(new JScrollPane(ordemServicoArea), gbc);  // Adiciona JTextArea com barra de rolagem

        // Ação do botão salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String endereco = enderecoField.getText();
                String cep = cepField.getText();
                String cidade = cidadeField.getText();
                String telefone = telefoneField.getText();
                String veiculo = veiculoField.getText();
                String placa = placaField.getText();
                double orcamento = Double.parseDouble(orcamentoField.getText());
                String ordemServico = ordemServicoArea.getText();

                // Criar o cliente com as informações do formulário
                Cliente cliente = new Cliente(nome, cpf, endereco, cep, cidade, telefone, veiculo, placa, orcamento, ordemServico);
                GerenciadorArquivo.salvarCliente(cliente);
            }
        });

        // Ação do botão buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busca = JOptionPane.showInputDialog("Digite o nome ou CPF do cliente:");
                if (busca != null && !busca.trim().isEmpty()) {
                    String resultado = GerenciadorArquivo.buscarCliente(busca);
                    if (resultado != null) {
                        mostrarClienteParaImpressao(resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um nome ou CPF válido.");
                }
            }
        });
    }

    // Método para mostrar as informações do cliente em uma nova janela e permitir a impressão
    public void mostrarClienteParaImpressao(String dadosCliente) {
        JFrame frame = new JFrame("Detalhes do Cliente");
        frame.setSize(400, 300);

        // Exibir os dados do cliente
        JTextArea textArea = new JTextArea(dadosCliente);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Botão para imprimir
        JButton imprimirButton = new JButton("Imprimir");

        // Painel para o botão e a área de texto
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(scrollPane);
        panel.add(imprimirButton);

        frame.add(panel);
        frame.setVisible(true);



        // Ação do botão imprimir
        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirCliente(dadosCliente);
            }
        });
    }

    // Método para imprimir as informações do cliente
    public void imprimirCliente(String dadosCliente) {
        // Aqui você pode chamar o método responsável por gerar o PDF ou documento com o logo
        // Exemplo:
        try {
            GerenciadorArquivo.imprimirCliente(dadosCliente);  // Você precisará adaptar este método para gerar o documento PDF
            JOptionPane.showMessageDialog(null, "Impressão realizada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a impressão: " + e.getMessage());
        }
    }
}