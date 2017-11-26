package _2_BufferSimples_MensagemUnica;

import java.util.concurrent.Semaphore;

public class SingleBuffer {

    //Implementacao com semaforos

    Semaphore s;
    String value;

    public SingleBuffer(){
        s = new Semaphore(0);
        value = null;
    }

    public void deposit(String v){
        value = v;
        System.out.println("Escrevendo: " + value);
        s.release();
    }

    public String fetch(){
        s.acquireUninterruptibly();
        System.out.println("Lendo: " + value);
        return value;
    }

    // Implementação com Monitores

    /* String value;
    boolean empty;

    public SingleBuffer(){
        this.value = null;
        this.empty = true;
    }

    public synchronized void deposit(String v){
        value = v;
        empty = false;
        System.out.println("Escrevendo: " + value);
        notify();
    }

    public synchronized String fetch(){
        while (empty)
            try {
                wait();
            }catch (Exception e){}
        System.out.println("Lendo: " + value);
        return value;
    } */

}
