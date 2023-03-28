
public class Main {
    public static void main(String[] args) 
    {
        Sinistro.geradorId("28.03.2023", "Rua Luis");
        Sinistro.geradorId("29.03.2023", "Rua Luis");
        boolean a = Cliente.validarCPF("05387129884");
        System.out.println("a = "+ a);

    }
}
