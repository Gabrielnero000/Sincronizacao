// Exclusão Mútua com semáforo binário.
// Composto de um int (para decisões) e uma fila de processos.
// IT WOOOORKS!

package _1_ExclusaoMutua;

public class MyLock extends Thread {
    BinarySemaphore s;
    int id;

    public MyLock(BinarySemaphore s, int id) {
        this.s = s;
        this.id = id;
    }

    public void run() {
        while (true) {
            s.P();
            //Inicio da seção critica

            System.out.println("Entrando na seção...");
            System.out.println("teste " + id);
            System.out.println("Saindo na seção...\n");

            //Fim da Seção Crítica
            s.V();
        }
    }

    public static void main(String[] args) {
        int nproc = 10;                        // Quantidade de processos
        Thread[] threads = new Thread[nproc];
        MyLock[] myLocks = new MyLock[nproc];

        BinarySemaphore s = new BinarySemaphore();

        for (int p = 0; p < nproc; p++)        //Inicia threads
        {
            myLocks[p] = new MyLock(s, p);
            threads[p] = new Thread(myLocks[p]);
            threads[p].start();
        }
    }
}
