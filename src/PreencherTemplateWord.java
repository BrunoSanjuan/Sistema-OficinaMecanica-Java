import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PreencherTemplateWord {

    public static void preencherTemplate(String caminhoTemplate, String caminhoSaida, Cliente cliente) throws IOException {
        // Abrir o template Word
        FileInputStream fis = new FileInputStream(caminhoTemplate);
        XWPFDocument document = new XWPFDocument(fis);

        // Percorrer parágrafos e substituir placeholders pelos dados do cliente
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            StringBuilder fullText = new StringBuilder();

            // Concatenar todos os runs de um parágrafo
            for (XWPFRun run : paragraph.getRuns()) {
                fullText.append(run.getText(0));
            }

            String updatedText = fullText.toString();

            // Substituir os placeholders
            updatedText = updatedText.replace("{nome}", cliente.getNome())
                    .replace("{cpf}", cliente.getCpf())
                    .replace("{endereco}", cliente.getEndereco())
                    .replace("{cep}", cliente.getCep())
                    .replace("{cidade}", cliente.getCidade())
                    .replace("{telefone}", cliente.getTelefone())
                    .replace("{veiculo}", cliente.getVeiculo())
                    .replace("{placa}", cliente.getPlaca())
                    .replace("{orcamento}", String.valueOf(cliente.getOrcamento()))
                    .replace("{ordemServico}", cliente.getOrdemServico());

            // Apagar os runs existentes
            for (int i = paragraph.getRuns().size() - 1; i >= 0; i--) {
                paragraph.removeRun(i);
            }

            // Inserir o texto atualizado de volta no parágrafo
            XWPFRun newRun = paragraph.createRun();
            newRun.setText(updatedText);
        }

        // Salvar o arquivo preenchido
        FileOutputStream fos = new FileOutputStream(caminhoSaida);
        document.write(fos);
        fos.close();
        document.close();
    }
}