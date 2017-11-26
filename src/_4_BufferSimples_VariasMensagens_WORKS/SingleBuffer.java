package _4_BufferSimples_VariasMensagens_WORKS;

import java.util.concurrent.Semaphore;

public class SingleBuffer {

    //Implementacao com semaforo

    Semaphore s1, s2;
    String value;

    public SingleBuffer(){
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        value = null;
    }

    public void deposit(String v){
        s1.acquireUninterruptibly();
        value = v;
        System.out.println("Escrevendo: " + value);
        s2.release();
    }

    public String fetch(){
        String v;
        s2.acquireUninterruptibly();
        v = value;
        System.out.println("Lendo: " + v + "\n");
        s1.release();
        return v;
    }

    // Implementacao com monitor

    /*String value;
    Boolean empty;

    public SingleBuffer() {
        empty = true;
        value = null;
    }

    public synchronized void deposit(String v) {
        while (empty)
            try {
                wait();
            } catch (Exception e) {}
        value = v;
        System.out.println("Escrevendo: " + value);
        empty = true;
        notifyAll();
    }

    public synchronized String fetch() {
        while (!empty)
            try {
                wait();
            } catch (Exception e) {
            }
        System.out.println("Lendo: " + value + "\n");
        empty = false;
        notifyAll();
        return value;
    }*/
}
