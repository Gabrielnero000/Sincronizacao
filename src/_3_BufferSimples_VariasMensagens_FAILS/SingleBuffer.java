package _3_BufferSimples_VariasMensagens_FAILS;

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
        System.out.println("Lendo: " + value + "\n");
        return value;
    }


}
