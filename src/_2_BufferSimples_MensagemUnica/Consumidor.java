package _2_BufferSimples_MensagemUnica;

public class Consumidor extends Thread {
    SingleBuffer buffer;
    String value;

    public Consumidor(SingleBuffer b){
        this.buffer = b;
    }
    public void run(){
        value = buffer.fetch();
        System.out.println("Consumidor: " + value);
    }
}
