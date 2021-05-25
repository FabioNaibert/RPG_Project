
public class Personagem {
    private int vida;
    private int dano;
    private String nome;
    private Dado dado = new Dado();

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 10;
    }

    public String getNome() {
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int Dano(){
        dano = dado.D8();
        vida -= dano;
        return dano;
    }
}