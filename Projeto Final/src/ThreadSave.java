import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;

public class ThreadSave extends Thread {
    Tela tela;

    public ThreadSave(Tela tela) {
        this.tela = tela;
    }

    public void run(){
            Gravar(tela.getProgresso());

            try {
                Thread.sleep(1000);
                run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void Gravar(String prog){

        FileWriter writer;
        BufferedWriter escrever;
        File arquivo;

        if(tela.getProgresso().equals("null") || tela.getProgresso().equals("1") || tela.getProgresso().equals("2") ||
           tela.getProgresso().equals("21") || tela.getProgresso().equals("22") || tela.getProgresso().equals("3") || tela.getProgresso().equals("4")) {
            try {
                arquivo = new File("C:\\Windows\\Temp\\Save.txt");
                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }
                writer = new FileWriter(arquivo);
                escrever = new BufferedWriter(writer);

                escrever.write(prog);

                escrever.close();
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}