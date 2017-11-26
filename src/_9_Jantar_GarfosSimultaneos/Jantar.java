package _9_Jantar_GarfosSimultaneos;

// Jantar dos filosofos, cada um pensa, fica com fome e come
// Para comer, cada um precisa pegar dois garfos
// Cada filosofo pega os dois garfos de uma vez
// Funciona, após terminar, o filosofo libera os garfos e o seguinte pega
// SEMAFORO: um semaforo para cada assento na mesa e outro para controlar o acesso

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
