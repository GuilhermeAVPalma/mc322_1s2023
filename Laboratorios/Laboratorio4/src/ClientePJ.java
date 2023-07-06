import java.sql.Date;

/*Pessoa Juridica */
public class ClientePJ extends Cliente {
    private String CNPJ ;
    private Date dataFundacao ; 
    private int qtdeFuncionarios ;      

    // Construtor
    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
        super(nome, endereco);
        setCNPJ(CNPJ);
        this.dataFundacao = dataFundacao;
    }

    // Getters e setters
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        if (Validacao.validarCNPJ(CNPJ))
        {
            this.CNPJ = CNPJ;
        }
        else
        {
            System.out.println("CNPJ nao valido!");
        }
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
   

    @Override
	public String toString() {
		return super.getNome() + " CNPJ:" + this.CNPJ;
	} 

    @Override
    public double calculaScore() {
        double score = CalcSeguro.VALOR_BASE.getSeguro() * (1 + (qtdeFuncionarios / 100)) * calcularQuantidadeCarros();
        return score;
    }
}
