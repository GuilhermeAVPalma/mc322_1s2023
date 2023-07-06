import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class Validacao {
    
    // Função auxiliar para verificar se uma string contém somente letras
    public static boolean verificarSomenteLetras(String nomeCliente) {
        return nomeCliente.matches("[a-zA-Z]+");
    }

    public static String dateToString (java.util.Date dataNascimento){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = dateFormat.format(dataNascimento);
        return dataFormatada;
    }
    
    /*Metodo que valida cnpj */
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
}