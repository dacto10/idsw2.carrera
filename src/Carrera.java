public class Carrera {
    public static void main(String[] args) throws Exception {
        inicializarCarrera();
    }

    public static void inicializarCarrera() throws InterruptedException {
        Pista pista = new Pista(5, 10);

        while(pista.carreraNoTerminada()) {
            pista.imprimirPistas();
            Thread.sleep(1000);
            pista.advance();
        } 
        pista.imprimirPistas();
        pista.getGanador();
    }
}
