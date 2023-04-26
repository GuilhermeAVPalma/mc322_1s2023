import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Pessoa Juridica */
public class ClientePJ extends Cliente {
    private String CNPJ ;
    private Date dataFundacao ;       

    // Construtor
    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String CNPJ, Date dataFundacao) {
        super(nome, endereco, listaVeiculos);
        setCNPJ(CNPJ);
        this.dataFundacao = dataFundacao;
    }
    // Sobrecarga
    public ClientePJ(String nome, String endereco, Veiculo veiculo, String CNPJ, Date dataFundacao) {
        super(nome, endereco, veiculo);
        setCNPJ(CNPJ);;
        this.dataFundacao = dataFundacao;
    }

    // Getters e setters
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        if (validarCNPJ(CNPJ))
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

    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos do CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
    
        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }
    
        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Integer.parseInt(cnpj.substring(i, i + 1));
            soma += digito * peso;
            peso = peso == 9 ? 2 : peso + 1;
        }
        int resto = soma % 11;
        int dv1 = resto < 2 ? 0 : 11 - resto;
    
        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Integer.parseInt(cnpj.substring(i, i + 1));
            soma += digito * peso;
            peso = peso == 9 ? 2 : peso + 1;
        }
        resto = soma % 11;
        int dv2 = resto < 2 ? 0 : 11 - resto;
    
        // Verifica se os dígitos verificadores estão corretos
        return Integer.parseInt(cnpj.substring(12, 13)) == dv1 && Integer.parseInt(cnpj.substring(13, 14)) == dv2;
    } 

    @Override
	public String toString() {
		return super.getNome() + " CNPJ:" + this.CNPJ;
	} 
}
