import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
    	Veiculo carro1 = new Veiculo("Ford", "KA", "Azul", "ABC123", 2020, new ArrayList<Peca>(), new ArrayList<Imposto>(),
    			new ArrayList<TrocaOleo>(), new ArrayList<Combustivel>(), new ArrayList<Pneu>(), 0);

        
        System.out.println(carro1 + "\n");
        
        carro1.adicionarRegistroCombustivel(new Combustivel(0, 12321, "Aditivado" , 21.0));
        
        System.out.println(carro1 + "\n");
        
        System.out.println(carro1.rendimentoCombustivel());
    }
    
}
