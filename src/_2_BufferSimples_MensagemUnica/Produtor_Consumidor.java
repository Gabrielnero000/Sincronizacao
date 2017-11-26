package _2_BufferSimples_MensagemUnica;

// Produtor-Consumidor: buffer simples, apenas uma mensagem
// Produtor produz mensagem e armazena mensagem no buffer
// Consumidor lê do buffer e imprime a mensagem
// Funciona mesmo quando o consumidor é iniciado primeiro
// SEMAFORO: semaforo gerencia o buffer

public class Produtor_Consumidor {
    public static void main(String[] args) {

        String message = "Testando...";
        SingleBuffer b = new SingleBuffer();
        Produtor p = new Produtor(b, message);
        Consumidor c = new Consumidor(b);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        //t2.start();
        //try { Thread.sleep(1000); }catch (Exception e){}
        //t1.start();
        t2.start();

    }
}
