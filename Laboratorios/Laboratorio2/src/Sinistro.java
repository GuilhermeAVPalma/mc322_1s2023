import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Sinistro {
    private int id;
    private String data ;
    private String endereco ;

    // Construtor    
    public Sinistro(int id, String data, String endereco) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static int geradorId(String data, String endereco) {
        /*Gera um id unico a partir da data e do endereco */
        String entrada = data.toString() + endereco;
        int id = 0;
        try 
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(entrada.getBytes(StandardCharsets.UTF_8));
            /*Converte o Hash hexadecimal em inteiro*/
            BigInteger bigInt = new BigInteger(1, hash);
            id = bigInt.intValue();
        }
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return id;
    }
}
