package _5_BufferCircular;

// Produtor-Consumidor: buffer circular(fila)
// Dois ints para armazenaro indice do começo e fim do buffer
// Produtor produz mensagens e armazena-as no buffer
// Consumidor lê do buffer e imprime apenas uma mensagem
// Funcional para multiplas mensagens, apesar do buffer encher
// SEMAFORO: Dois semaforos: um indica se o buffer está vazio
//           e o outro se está cheio (ambos liberando ou bloqueando)

public class Produtor_Consumidor {
    public static void main(String[] args) {

        String message = "Testando...";
        BoundedBuffer b = new BoundedBuffer(15);
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
