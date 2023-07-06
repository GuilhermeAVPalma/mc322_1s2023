import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/*Pessoa Fisica */
public class ClientePF extends Cliente{
    private String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


    /*Construtor */
    public ClientePF(String nome, String endereco, String cpf, String genero,
            Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco);
        setCpf(cpf);
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    /*Getters e setters*/
    public String getCpf() {
        return cpf;
    }    

    public void setCpf(String cpf) {
        if (Validacao.validarCPF(cpf))
        {
            this.cpf = cpf;
        }
        else
        {
            System.out.println("CPF nao valido!");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }   

    @Override
	public String toString() {
		return super.getNome() + " CPF:" + this.cpf;
	}  
    
    private static int calcularIdade(Date dataNascimento) {
        LocalDate nascimento = LocalDate.parse(dataNascimento.toString());
        LocalDate dataAtual = LocalDate.now();
        /*Calcula a diferenca entre hoje e a data de nascimento */
        Period periodo = Period.between(nascimento, dataAtual);
        
        return periodo.getYears();
    }

    private double calculaFator(int idade){
        if (idade < 18)
        {
            System.out.println("O cliente nao pode ter menos que 18 anos!");
            return 0;
        }
        else if (idade >= 18 && idade < 30)
        {           
            return CalcSeguro.FATOR_18_30.getSeguro();
        }
        else if (idade >= 30 && idade < 60)
        {
            return CalcSeguro.FATOR_18_30.getSeguro();
        }
        else if (idade >= 60 && idade < 90)
        {
            return CalcSeguro.FATOR_18_30.getSeguro();
        }
        else
        {
            System.out.println("O cliente nao pode ter mais de 90 anos!");
            return 0;
        }
    }

    @Override
    public double calculaScore() {
        int idade = calcularIdade(dataNascimento);
        double fator = calculaFator(idade);
        double score = CalcSeguro.VALOR_BASE.getSeguro() * fator * calcularQuantidadeCarros();
        return score;
    }
}