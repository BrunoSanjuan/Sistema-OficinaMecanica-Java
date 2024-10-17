public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String cep;
    private String cidade;
    private String telefone;
    private String veiculo;
    private String placa;
    private double orcamento;
    private String ordemServico;

    public Cliente(String nome, String cpf, String endereco, String cep, String cidade,
                   String telefone, String veiculo, String placa, double orcamento, String ordemServico) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.telefone = telefone;
        this.veiculo = veiculo;
        this.placa = placa;
        this.orcamento = orcamento;
        this.ordemServico = ordemServico;
    }

    // Getter para o campo 'nome'
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getOrdemServico() {
        return ordemServico;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Endereço: " + endereco + "\n" + "CEP: " + cep + "\n" + "Cidade: " + cidade + "\n" + "Telefone: " + telefone
                + "\n" + "Veículo: " + veiculo + "\n" + "Placa: " + placa + "\n" + "Orçamento R$" + orcamento + "\n" + "Ordem de serviço: " + ordemServico;
    }
}
