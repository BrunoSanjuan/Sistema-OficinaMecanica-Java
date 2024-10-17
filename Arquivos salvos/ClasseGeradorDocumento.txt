import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import java.io.FileNotFoundException;

public class GeradorDocumento {

    public static void gerarOrcamento(Cliente cliente, String logoPath) {
        String dest = "C:\\Users\\bruno\\Documentos\\orcamento_" + cliente.getNome() + ".pdf";

        try {
            // Criar um documento PDF
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Adicionar logo
            ImageData imageData = ImageDataFactory.create("C:\\Users\\bruno\\Documentos\\DIO\\ProjetoOficinaMecanica\\OficinaMecanica\\Arquivos salvos\\logoOficinaMecanica.jpg"); // Caminho do logo
            Image logo = new Image(imageData);
            document.add(logo);

            // Adicionar título
            document.add(new Paragraph("Orçamento e Prestação de Serviço").setBold().setFontSize(20));

            // Adicionar informações do cliente
            document.add(new Paragraph("Nome: " + cliente.getNome()));
            document.add(new Paragraph("CPF: " + cliente.getCpf()));
            document.add(new Paragraph("Endereço: " + cliente.getEndereco()));
            document.add(new Paragraph("CEP: " + cliente.getCep()));
            document.add(new Paragraph("Cidade: " + cliente.getCidade()));
            document.add(new Paragraph("Telefone: " + cliente.getTelefone()));
            document.add(new Paragraph("Veículo: " + cliente.getVeiculo()));
            document.add(new Paragraph("Placa: " + cliente.getPlaca()));
            document.add(new Paragraph("Orçamento: R$" + cliente.getOrcamento()));
            document.add(new Paragraph("Ordem de serviço: " + cliente.getOrdemServico()));

            // Fechar documento
            document.close();

            System.out.println("Orçamento gerado com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao gerar o PDF: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
