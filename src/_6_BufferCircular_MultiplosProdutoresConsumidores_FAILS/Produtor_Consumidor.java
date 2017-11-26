package _6_BufferCircular_MultiplosProdutoresConsumidores_FAILS;

// Produtor-Consumidor: buffer circular(fila), multiplos prod. e cons.
// Dois ints para armazenaro indice do começo e fim do buffer
// Produtor produz mensagens e armazena-as no buffer
// Consumidor lê do buffer e imprime apenas uma mensagem
// FALHA: não garante exclusão mutua
// SEMAFORO: Dois semaforos: um indica se o buffer está vazio
//           e o outro se está cheio (ambos liberando ou bloqueando)

public class Produtor_Consumidor {
    public static void main(String[] args) {

        String message = "Testando...";
        BoundedBuffer b = new BoundedBuffer(15);
        Produtor[] p = new Produtor[3];
        Consumidor[] c = new Consumidor[3];
        Thread[] t1 = new Thread[3];
        Thread[] t2 = new Thread[3];
        for (int i = 0; i < 3; i++) {
            p[i] = new Produtor(b, message + "i=" + i);
            c[i] = new Consumidor(b);
            t1[i] = new Thread(p[i]);
            t2[i] = new Thread(c[i]);
            t1[i].start();
            //t2[i].start();
            //try { Thread.sleep(1000); }catch (Exception e){}
            //t1[i].start();
            t2[i].start();
        }

    }
}
