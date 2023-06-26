import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
public class Main {

    public static void main(String[] args) {

        // Veiculo usado como referencia
    	Veiculo carro1 = new Veiculo("Ford", "KA", "Azul", "ABC123", 2020, new ArrayList<Peca>(),
                new ArrayList<Imposto>(), new ArrayList<TrocaOleo>(), new ArrayList<Combustivel>(), new ArrayList<Pneu>(),
                0, 167901.29);
        // Veiculo usado como referencia
        Veiculo carro2 = new Veiculo("POO", "X", "Preto", "POO999", 2023, new ArrayList<Peca>(), new ArrayList<Imposto>(),
                new ArrayList<TrocaOleo>(), new ArrayList<Combustivel>(), new ArrayList<Pneu>(), 0, 19301.87);


        // Instanciando a frota de veiculos
        Frota frota = new Frota("POO Veiculos");

        // Datas de referencia
        LocalDate dia = LocalDate.of(2023, Month.JANUARY, 1);
        LocalDate dia10 = LocalDate.of(2023, Month.JANUARY, 10);
        LocalDate dia31 = LocalDate.of(2023, Month.JANUARY, 31);

        // Adicionando os impostos que foram pagos para cada veiculo
        carro1.adicionarImposto(new IPVA(309.1, dia));
        carro1.adicionarImposto(new ICMS(329.2, dia));
        carro2.adicionarImposto(new IPVA(387.35, dia));
        carro2.adicionarImposto(new ICMS(983.8, dia));

        // Adicionando pecas que foram trocadas em cada carro
        carro1.adicionarPeca(new Peca(49.99, "FPX", "Vela", "NNT Pecas", dia10));
        carro2.adicionarPeca(new Peca(4999.99, "VM", "Motor", "Ford", dia10));

        // Adicionando combustivel no carro1
        carro1.adicionarRegistroCombustivel(new Combustivel(0, 219, "Aditivado" , 21.0));

        // Adicionando os Pneus que cada carro possui inicialmente
        Pneu pneu1 = new Pneu(199.99, "GG", "Pneu Sedan", "Michellin", dia, 50000, "VP", 1);
        Pneu pneu2 = new Pneu(199.99, "GG", "Pneu Sedan", "Michellin", dia, 50000, "VP", 2);
        Pneu pneu3 = new Pneu(199.99, "GG", "Pneu Sedan", "Michellin", dia, 50000, "VP", 3);
        Pneu pneu4 = new Pneu(199.99, "GG", "Pneu Sedan", "Michellin", dia, 50000, "VP", 4);
        carro1.adicionarPneu(pneu1);
        carro1.adicionarPneu(pneu2);
        carro1.adicionarPneu(pneu3);
        carro1.adicionarPneu(pneu4);
        carro2.adicionarPneu(pneu1);
        carro2.adicionarPneu(pneu2);
        carro2.adicionarPneu(pneu3);
        carro2.adicionarPneu(pneu4);

        // Realizando a troca de Pneus nos 2 carros por modelos premium
        Pneu novoPneu1 = new Pneu(999.99, "Premium GG", "Pneu Sedan", "Michellin", dia31, 100000, "VP", 1);
        Pneu novoPneu2 = new Pneu(999.99, "Premium GG", "Pneu Sedan", "Michellin", dia31, 100000, "VP", 2);
        Pneu novoPneu3 = new Pneu(999.99, "Premium GG", "Pneu Sedan", "Michellin", dia31, 100000, "VP", 3);
        Pneu novoPneu4 = new Pneu(999.99, "Premium GG", "Pneu Sedan", "Michellin", dia31, 100000, "VP", 4);

        carro1.cadastrarTrocaPneu(novoPneu1);
        carro1.cadastrarTrocaPneu(novoPneu2);
        carro1.cadastrarTrocaPneu(novoPneu3);
        carro1.cadastrarTrocaPneu(novoPneu4);
        carro2.cadastrarTrocaPneu(novoPneu1);
        carro2.cadastrarTrocaPneu(novoPneu2);
        carro2.cadastrarTrocaPneu(novoPneu3);
        carro2.cadastrarTrocaPneu(novoPneu4);


        // Imprimindo o carro1 e o seu rendimento

        System.out.println("Carro 1:" + carro1);
        System.out.println("Rendimento do carro 1: " + carro1.rendimentoCombustivel());

        // Imprimindo o Carro2
        System.out.println("Carro 2: " + carro2 + "\n");

        // Cadastrando os veiculos na frota
        frota.cadastrarVeiculo(carro1);
        frota.cadastrarVeiculo(carro2);

        // Cadastrando uma revisao que foi realisada nos carros.
        frota.cadastrarManutencao(new Revisao(dia10, dia10, false));

        // Cadastrando um conserto que foi realizado e as pecas que foram trocadas.
        Conserto conserto = new Conserto(dia31, dia31);
        conserto.adicionarPeca(new Peca(4999.99, "VM", "Motor", "Ford", dia10));
        conserto.adicionarPeca(new Peca(49.99, "FPX", "Vela", "NNT Pecas", dia10));
        frota.cadastrarManutencao(conserto);


        // Imprimindo a frota e o gasto total da frota
        // O gasto inclui as pecas trocadas, impostos, combustivel e as manutencoes realizadas.
        System.out.println("Gasto total da frota: " + frota.gastoTotalFrota());
        System.out.println("Frota completa:\n" + frota);
        frota.listarVeiculos();

    }
    
}
