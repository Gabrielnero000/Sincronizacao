package _8_Jantar_FAILS;

import java.util.concurrent.Semaphore;

public class Mesa {

    //Implementacao com semaforos

    /*Semaphore[] garfo;
    int assentos;

    public Mesa(int s){
        this.assentos = s;
        garfo = new Semaphore[s];
        for(int i = 0; i < s; i++){
            garfo[i] = new Semaphore(1);
        }
    }

    public void acquire(int id){
        garfo[id].acquireUninterruptibly();
        //CASO DE FALHA
        //try {Thread.sleep(5000); }catch (Exception e){}
        garfo[(id + 1) % assentos].acquireUninterruptibly();
    }

    public void release(int id){
        garfo[id].release();
        garfo[(id + 1) % assentos].release();
    }*/

    boolean[] garfos;
    int assentos;

    public Mesa(int s){
        this.assentos = s;
        this.garfos = new boolean[s];
        for(int i = 0; i < s; i++){
            garfos[i] = false;
        }
    }
    public void acquire(int id){
        int i, j;
        i = id;
        j = (id + 1) % assentos;
        synchronized (this){
            while (garfos[i])
                try { wait(); } catch (InterruptedException e) { }
            garfos[i] = true;
            //CASO DE FALHA
            //try {Thread.sleep(5000); }catch (Exception e){}
        }
        synchronized (this){
            while (garfos[j])
                try { wait(); } catch (InterruptedException e) { }
            garfos[j] = true;
        }
    }
    public void release(int id){
        int i, j;
        i = id;
        j = (id + 1) % assentos;
        synchronized (this){
            garfos[i] = false;
            notifyAll();
        }synchronized (this){
            garfos[j] = false;
            notifyAll();
        }
    }
}
