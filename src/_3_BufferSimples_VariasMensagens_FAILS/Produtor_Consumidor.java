package _3_BufferSimples_VariasMensagens_FAILS;

// Produtor-Consumidor: buffer simples, multiplas mensagens
// Produtor produz mensagens e armazena-as no buffer
// Consumidor lê do buffer e imprime apenas uma mensagem
// CASO DE FALHA: produtor pode sobreescrever no buffer

public class Produtor_Consumidor {
    public static void main(String[] args) {

        String message = "Testando...";
        SingleBuffer b = new SingleBuffer();
        Produtor p = new Produtor(b, message);
        Consumidor c = new Consumidor(b);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        //t2.start();
        //try { Thread.sleep(1000); }catch (Exception e){}
        //t1.start();
        t2.start();

    }
}
