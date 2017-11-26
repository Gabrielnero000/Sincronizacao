package _10_JantarGarfosAlternados;

public class Filosofo extends Thread{
    int id;
    Mesa m;

    public Filosofo(int i, Mesa m){
        this.id = i;
        this.m = m;
    }

    public void run(){
        while (true){
            System.out.println("Fil. " + id + " esta pensando");
            try {sleep(2000); }catch (Exception e){}
            System.out.println("Fil. " + id + " esta com fome");
            m.acquire(id);
            System.out.println("Fil. " + id + " esta comendo");
            try {sleep(2000); }catch (Exception e){}
            m.release(id);
        }
    }
}
