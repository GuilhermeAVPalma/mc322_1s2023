import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
public class Main {

    public static void main(String[] args) {
    
    	Veiculo carro1 = new Veiculo("Ford", "KA", "Azul", "ABC123", 2020, new ArrayList<Peca>(),
                new ArrayList<Imposto>(), new ArrayList<TrocaOleo>(), new ArrayList<Combustivel>(), new ArrayList<Pneu>(),
                0, 167901.29);

        Veiculo carro2 = new Veiculo("POO", "X", "Preto", "POO999", 2023, new ArrayList<Peca>(), new ArrayList<Imposto>(),
                new ArrayList<TrocaOleo>(), new ArrayList<Combustivel>(), new ArrayList<Pneu>(), 0, 19301.87);

        Frota frota = new Frota("POO Veiculos");

        LocalDate dia = LocalDate.of(2023, Month.JANUARY, 1);
        LocalDate dia10 = LocalDate.of(2023, Month.JANUARY, 10);
        LocalDate dia31 = LocalDate.of(2023, Month.JANUARY, 31);
        System.out.println(dia);

        carro1.adicionarImposto(new IPVA(309.1, dia));
        carro1.adicionarImposto(new ICMS(329.2, dia));
        carro2.adicionarImposto(new IPVA(387.35, dia));
        carro2.adicionarImposto(new ICMS(983.8, dia));

        carro1.adicionarPeca(new Peca(49.99, "FPX", "Vela", "NNT Pecas", dia10));
        carro2.adicionarPeca(new Peca(4999.99, "VM", "Motor", "Ford", dia10));

        carro1.adicionarRegistroCombustivel(new Combustivel(0, 219, "Aditivado" , 21.0));
        
        System.out.println(carro1 + "\n");
        
        System.out.println(carro1.rendimentoCombustivel());

        frota.cadastrarVeiculo(carro1);
        frota.cadastrarVeiculo(carro2);

        frota.cadastrarManutencao(new Revisao(dia10, dia10, false));

        Conserto conserto = new Conserto(dia31, dia31);
        conserto.adicionarPeca(new Peca(4999.99, "VM", "Motor", "Ford", dia10));
        conserto.adicionarPeca(new Peca(49.99, "FPX", "Vela", "NNT Pecas", dia10));
        frota.cadastrarManutencao(conserto);

        System.out.println(frota.gastoTotalFrota() + "\n");
        System.out.println(frota + "\n");
        frota.listarVeiculos();
    }
    
}
