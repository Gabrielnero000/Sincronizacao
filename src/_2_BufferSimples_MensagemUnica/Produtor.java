package _2_BufferSimples_MensagemUnica;

public class Produtor extends Thread {
    SingleBuffer buffer;
    String value;

    public Produtor(SingleBuffer b, String v){
        this.buffer = b;
        this.value =  v;
    }

    public void run(){
        System.out.println("Produtor: " + value);
        buffer.deposit(value);
    }
}
