import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Pessoa Fisica */
public class ClientePF extends Cliente {
    private String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


    /*Construtor */
    public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, String cpf, String genero,
            Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
        setCpf(cpf);
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }
    /*Sobrecarga */
    public ClientePF(String nome, String endereco, Veiculo veiculo, String cpf, String genero,
            Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, veiculo);
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
        if (validarCPF(cpf))
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

    /*Metodo que valida cpf */
    public static boolean validarCPF (String cpf){
        /*O regex \D corresponde a qualquer caractere que não seja um digito */
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11)
        {
            return false;
        }
        else
        {
            /*Verifica se contem somente numeros iguais */
            Set<Character> digitos = new HashSet<>();
            for (char c : cpf.toCharArray()) 
            {
                digitos.add(c);
            }

            if (digitos.size() == 1)
            {                
                return false;
            }
            else
            {
                /*Calculo dos digitos verificadores */
                int soma = 0;
                int peso = 10;
                String cpfCalculado = cpf.substring(0, 9);
                for (int i = 0; i < 9; i++) {
                    soma += Integer.parseInt(String.valueOf(cpfCalculado.charAt(i))) * peso;
                    peso--;
                }

                int resto = (soma % 11);
                int digito1 = 11 - (soma % 11);

                if (resto <= 1) {
                    digito1 = 0;
                }

                cpfCalculado += digito1; // Adicionar primeiro dígito verificador

                soma = 0;
                peso = 10;
                for (int i = 1; i < 10; i++) {
                    soma += Integer.parseInt(String.valueOf(cpfCalculado.charAt(i))) * peso;
                    peso--;
                }

                resto = (soma % 11);
                int digito2 = 11 - (soma % 11);

                if (resto <= 1) {
                    digito2 = 0;
                }

                cpfCalculado += digito2; // Adicionar segundo dígito verificador
                if (cpf.equals(cpfCalculado))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    @Override
	public String toString() {
		return super.getNome() + " CPF:" + this.cpf;
	}   
}