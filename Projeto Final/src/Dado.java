import java.util.Random;

public class Dado {
    Random dado = new Random();

    public Dado(){
    }

    public int D20(){
        return dado.nextInt(20) + 1;
    }

    public int D8(){
        return dado.nextInt(8) + 1;
    }
}