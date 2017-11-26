package _3_BufferSimples_VariasMensagens_FAILS;

public class Consumidor extends Thread {
    SingleBuffer buffer;
    String value;

    public Consumidor(SingleBuffer b){
        this.buffer = b;
    }
    public void run(){
        while (true){
            value = buffer.fetch();
            try { sleep(2400); }catch (Exception e){};
            // CASO DE FALHA:
            // try { sleep(3600); }catch (Exception e){};
        }
    }
}
