package _9_Jantar_GarfosSimultaneos;

import java.util.concurrent.Semaphore;

public class Mesa {

    //Implementacao com semaforos

    /*Semaphore[] garfo;
    Semaphore mutex;
    int assentos;

    public Mesa(int s){
        this.assentos = s;
        mutex = new Semaphore(1);
        garfo = new Semaphore[s];
        for(int i = 0; i < s; i++){
            garfo[i] = new Semaphore(1);
        }
    }

    public void acquire(int id){
        mutex.acquireUninterruptibly();
        garfo[id].acquireUninterruptibly();
        //try {Thread.sleep(5000); }catch (Exception e){}
        garfo[(id + 1) % assentos].acquireUninterruptibly();
        mutex.release();
    }

    public void release(int id){
        garfo[id].release();
        garfo[(id + 1) % assentos].release();
    }*/

    //Implementacao com monitores

    boolean[] garfos;
    int assentos;

    public Mesa(int s){
        this.assentos = s;
        garfos = new boolean[s];
        for(int i = 0; i < s; i++)
            garfos[i] = false;
    }

    public synchronized void acquire(int id){
        int i, j;
        i = id;
        j = (id + 1) % assentos;
        while (garfos[i] || garfos[j])
            try { wait(); } catch (Exception e) {}
        garfos[i] = true;
        garfos[j] = true;
    }

    public synchronized void release(int id){
        int i, j;
        i = id;
        j = (id + 1) % assentos;
        garfos[i] = false;
        garfos[j] = false;
        notifyAll();
    }
}
