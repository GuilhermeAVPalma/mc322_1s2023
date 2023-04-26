import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Sinistro {
    private int id;
    private String data ;
    private String endereco ;
    private Seguradora seguradora ;
    private Veiculo veiculo ;
    private Cliente cliente ;

    /*Construtor */
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = geradorId(data, endereco);
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    /*Getters e setters*/
    public int getId() {
        return id;
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

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
	public String toString() {
		return "ID: " + getId();
	}  
}
