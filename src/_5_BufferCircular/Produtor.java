package _5_BufferCircular;

public class Produtor extends Thread {
    BoundedBuffer buffer;
    String value;

    public Produtor(BoundedBuffer b, String v){
        this.buffer = b;
        this.value =  v;
    }

    public void run(){
        int i = 0;
        String message;
        while (true){
            message = value + " " + String.valueOf(i++);
            buffer.deposit(message);
            // try { sleep(3000); }catch (Exception e){};
            try { sleep(1500); }catch (Exception e){};
        }

    }
}
