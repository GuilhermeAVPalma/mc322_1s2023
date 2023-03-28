import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private String nome ;
    private String cpf ;
    private String dataNascimento ;
    private int idade ;
    private String endereco ;

    // Construtor
    public Cliente ( String nome , String cpf , String dataNascimento , int idade, String endereco ) {
        this.nome = nome ;
        this.cpf = cpf ;
        this.dataNascimento = dataNascimento ;
        this.idade = idade ;
        this.endereco = endereco ;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

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
                
}
