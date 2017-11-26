package _8_Jantar_FAILS;

// Jantar dos filosofos, cada um pensa, fica com fome e come
// Para comer, cada um precisa pegar dois garfos
// Cada filosofo pega primeiro o garfo da direita, depois o da esquerda
// CASO DE FALHA: deadlock, ninguem consegue ter dois garfos
// SEMAFORO: um semaforo para cada assento na mesa

public class Jantar {
    public static void main(String[] args) {
        Mesa m = new Mesa(10);
        Filosofo[] f = new Filosofo[10];
        Thread[] t = new Thread[10];
        for(int i = 0; i < 10; i++){
            f[i] = new Filosofo(i, m);
            t[i] = new Thread(f[i]);
            t[i].start();
        }
    }
}
