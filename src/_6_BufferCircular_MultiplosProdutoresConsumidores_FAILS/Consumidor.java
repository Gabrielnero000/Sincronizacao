package _6_BufferCircular_MultiplosProdutoresConsumidores_FAILS;

public class Consumidor extends Thread {
    BoundedBuffer buffer;
    String value;

    public Consumidor(BoundedBuffer b){
        this.buffer = b;
    }
    public void run(){
        while (true){
            value = buffer.fetch();
            // try { sleep(2400); }catch (Exception e){};
            try { sleep(3600); }catch (Exception e){};
        }
    }
}
