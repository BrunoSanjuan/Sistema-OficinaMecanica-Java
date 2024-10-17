import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GerenciadorArquivo {

    // Método para salvar cliente
    public static void salvarCliente(Cliente cliente) {
        String nomeArquivo = cliente.getNome();  // Pegue o nome do cliente
        String filePath = "C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos\\" + nomeArquivo + ".txt";

        // Cria o diretório caso ele não exista
        File directory = new File("C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos");
        if (!directory.exists()) {
            directory.mkdirs();  // Cria os diretórios necessários
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(cliente.toString());  // Escreve as informações do cliente
            writer.newLine();
            writer.flush();
            System.out.println("Cliente salvo com sucesso!");
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente.");
            e.printStackTrace();
        }
    }

    // Método para buscar cliente por nome ou CPF
    public static String buscarCliente(String busca) {
        File directory = new File("C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos");
        File[] arquivos = directory.listFiles();  // Lista todos os arquivos no diretório

        if (arquivos != null) {
            boolean encontrado = false;

            // Percorre todos os arquivos
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        StringBuilder conteudoCliente = new StringBuilder();

                        // Percorre cada linha do arquivo para verificar se contém o nome ou CPF buscado
                        while ((linha = reader.readLine()) != null) {
                            conteudoCliente.append(linha).append("\n");  // Concatena as informações do cliente

                            if (linha.contains(busca)) {
                                JOptionPane.showMessageDialog(null, "Cliente encontrado: " + linha);
                                System.out.println("Cliente encontrado: " + linha);
                                encontrado = true;
                                return conteudoCliente.toString();  // Retorna todas as informações do cliente encontrado
                            }
                        }

                    } catch (IOException e) {
                        System.out.println("Erro ao buscar cliente: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                System.out.println("Cliente não encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o diretório.");
            System.out.println("Erro ao acessar o diretório.");
        }
        return null;  // Retorna null se o cliente não for encontrado
    }

    // Método para imprimir as informações do cliente
    public static void imprimirCliente(String dadosCliente) {
        if (dadosCliente == null || dadosCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma informação de cliente disponível para impressão.");
            return;
        }

        String filePath = "C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos\\Impressao_Cliente.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(dadosCliente);  // Escreve os dados do cliente em um arquivo para impressão
            writer.flush();
            JOptionPane.showMessageDialog(null, "Informações do cliente prontas para impressão no arquivo: " + filePath);
            System.out.println("Impressão realizada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao imprimir cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao imprimir cliente.");
            e.printStackTrace();
        }
    }
}
