package _7_BufferCircular_MultiplosProdutoresConsumidores_WORKS;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {

    // Implementacao com semaforos

    /*Semaphore empty, full, mutex;
    int size, in_buf, out_buf;
    String[] buffer;

    public BoundedBuffer(int n){
        size = n;
        empty = new Semaphore(size);
        full = new Semaphore(0);
        mutex = new Semaphore(1);
        in_buf = 0;
        out_buf = 0;
        buffer = new String[size];
        for(int i = 0; i < size; i++){
            buffer[i] = null;
        }
    }

    public void deposit(String v){
        empty.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        buffer[in_buf] = v;
        System.out.println("Escrevendo do buffer[" + in_buf + "]" + v);
        in_buf = (in_buf + 1) % size;
        mutex.release();
        full.release();
    }

    public String fetch(){
        String v;
        full.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        v = buffer[out_buf];
        System.out.println("Lendo do buffer[" + out_buf + "]" + v + "\n");
        out_buf = (out_buf + 1) % size;
        mutex.release();
        empty.release();
        return v;
    }*/

    // Implementacao com monitores

    int size, in_buf, out_buf, count;
    String[] buffer;
    public BoundedBuffer(int n){
        size = n;
        in_buf = 0;
        out_buf = 0;
        buffer = new String[size];
        for(int i = 0; i < size; i++){
            buffer[i] = null;
        }
    }

    public synchronized void deposit(String v){
        while (count == size)
            try { wait(); } catch (InterruptedException e) {}
        buffer[in_buf] = v;
        System.out.println("Escrevendo do buffer[" + in_buf + "]" + v);
        in_buf = (in_buf + 1) % size;
        count++;
        if(count == 1)
            notifyAll();
    }

    public synchronized String fetch(){
        while (count == 0)
            try { wait(); } catch (InterruptedException e) {}
        String v = buffer[out_buf];
        System.out.println("Lendo do buffer[" + out_buf + "]" + v + "\n");
        out_buf=(out_buf + 1) % size;
        count--;
        if(count == size-1)
            notifyAll();
        return v;
    }
}
