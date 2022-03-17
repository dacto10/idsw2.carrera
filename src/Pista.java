import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pista {
    private List<List<String>> pistas;
    private List<Caballo> caballos;

    public Pista(int cantidadPistas, int tamañoPistas) {
        this.pistas = new ArrayList<List<String>>();
        this.caballos = new ArrayList<Caballo>();
        IntStream.range(0, cantidadPistas).forEach(index -> {
            pistas.add(IntStream.range(0, tamañoPistas).mapToObj(idx -> "[0]").collect(Collectors.toList()));
            caballos.add(new Caballo("["+ index +"]"));
        });
    }

    public void imprimirPistas() {
        pistas.stream().forEach(el -> {
            printPista(el);
            System.out.println();
        });
        IntStream.range(0, this.pistas.get(0).size()).forEach(el -> System.out.print("---"));
        System.out.println();
    }

    private static void printPista(List<String> pista) {
        pista.forEach(el -> System.out.print(el));
    }

    public void advance() {
        IntStream.range(0, this.pistas.size()).forEach(index -> {
            Caballo caballo = this.caballos.get(index);
            if(caballo.tryAdvance()) this.pistas.get(index).set(caballo.getPosition(), caballo.getAvatar());
        });
    }

    public boolean carreraNoTerminada() {
        return this.caballos.stream().map(el -> el.getPosition() < this.pistas.get(0).size()-1).reduce(true, (current, acc) -> current && acc);
    }

    public void getGanador() {
        IntStream.range(0, this.caballos.size()).forEach(index -> {
            if(this.caballos.get(index).getPosition() == this.pistas.get(0).size() - 1) System.out.println("Ha ganado el caballo en la pista " + index);
        });
    }
}