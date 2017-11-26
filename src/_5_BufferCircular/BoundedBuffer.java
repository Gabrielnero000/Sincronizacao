package _5_BufferCircular;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {

    //Implementacao com semaforo

    Semaphore empty, full;
    int size, in_buf, out_buf;
    String[] buffer;

    public BoundedBuffer(int n){
        size = n;
        empty = new Semaphore(size);
        full = new Semaphore(0);
        in_buf = 0;
        out_buf = 0;
        buffer = new String[size];
        for(int i = 0; i < size; i++){
            buffer[i] = null;
        }
    }

    public void deposit(String v){
        empty.acquireUninterruptibly();
        buffer[in_buf] = v;
        System.out.println("Escrevendo do buffer[" + in_buf + "]" + v);
        in_buf = (in_buf + 1) % size;
        full.release();
    }

    public String fetch(){
        String v;
        full.acquireUninterruptibly();
        v = buffer[out_buf];
        System.out.println("Lendo do buffer[" + out_buf + "]" + v + "\n");
        out_buf = (out_buf + 1) % size;
        empty.release();
        return v;
    }

    //Implementacao com monitores

    /*int size, in_buf, out_buf, count;
    String[] buffer;

    public BoundedBuffer(int n){
        size = n;
        count = 0;
        in_buf = 0;
        out_buf = 0;
        buffer = new String[size];
        for (int i = 0; i <  size; i++)
            buffer[i] = null;
    }

    public synchronized void deposit(String v){
        while (count == size){
            try { wait(); } catch (Exception e) {}
        }
        buffer[in_buf] = v;
        System.out.println("Escrevendo do buffer[" + in_buf + "]" + v);
        in_buf = (in_buf + 1) % size;
        count--;
        if(count == size-1)
            notify();
    }

    public synchronized String fetch(){
        while (count == 0)
            try { wait(); } catch (Exception e) {}
        String v = buffer[out_buf];
        System.out.println("Lendo do buffer[" + out_buf + "]" + v + "\n");
        out_buf = (out_buf + 1) % size;
        count--;
        if(count == size - 1)
            notify();
        return v;
    }*/
}
