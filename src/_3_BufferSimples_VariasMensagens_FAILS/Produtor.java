package _3_BufferSimples_VariasMensagens_FAILS;

public class Produtor extends Thread {
    SingleBuffer buffer;
    String value;

    public Produtor(SingleBuffer b, String v){
        this.buffer = b;
        this.value =  v;
    }

    public void run(){
        int i = 0;
        String message;
        while (true){
            message = value + " " + String.valueOf(i++);
            buffer.deposit(message);
            try { sleep(3000); }catch (Exception e){};
            // CASO DE FALHA:
            // try { sleep(1500); }catch (Exception e){};
        }

    }
}
