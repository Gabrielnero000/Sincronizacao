package _6_BufferCircular_MultiplosProdutoresConsumidores_FAILS;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
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
}
