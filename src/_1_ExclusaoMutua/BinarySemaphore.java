package _1_ExclusaoMutua;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySemaphore {
    AtomicInteger value;            // Valor do semaforo
    ConcurrentLinkedQueue queue;    // Fila de processos

    public BinarySemaphore(){
        this.value = new AtomicInteger(1);
        this.queue = new ConcurrentLinkedQueue();
    }

    public void P(){    // Se o semaforo esta em 0,
                        // Suspende processo e troca o valor.
        if(!value.compareAndSet(1, 0))
            block();
    }

    public void V(){    // Se a fila não está vazia,
                        // Libera um processo aa fila
        if(!queue.isEmpty())
            unblock();
        else
            value.set(1);
    }

    private void block(){ // Adiciona o processo atual na fila e o suspende.
        Thread t = Thread.currentThread();
        queue.add(t);
        t.suspend(); // Depreciado, mas funciona.
    }

    private void unblock(){ // Acorda o primeiro processo na fila
        Thread t = (Thread) queue.poll();
        if(t != null)
            t.resume(); // Depreciado, mas funciona.
    }
}
