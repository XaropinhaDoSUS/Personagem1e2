//Personagem

class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean isMorto;

    public Personagem (String nome, int vida, int ataque, int defesa ) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.isMorto = false;
    }

    public String getNome (){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getVida(){
        return vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getAtaque(){
        return ataque;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public int getDefesa(){
        return defesa;
    }

    public void setDefesa(int defesa){
        this.defesa = defesa;
    }

    public void Info(){
        if (isMorto){
            System.out.println("Nome: " + nome + ", Vida: " + vida + ", Ataque: " + ataque + ", Defesa: " + defesa);
        } else {
            System.out.println("Nome: " + nome + ", Vida: " + vida + ", Ataque: " + ataque + ", Defesa: " + defesa);
        }
    }

    public void atacar (Personagem alvo){
        if (this.isMorto) {
            System.out.println(this.nome + " não pode atacar porque foi de arrasta");
            return;
        }
        if (alvo.isMorto) {
            System.out.println(alvo.nome + " Morreu da silva");
            return;
        }

        int dano = this.ataque - alvo.defesa;
        if (dano < 0) {
            dano = 0;
        }

        alvo.vida -= dano;

        System.out.println(this.nome + " atacou " + alvo.nome + " causando " + dano + " de dano");

        if(alvo.vida <= 0){
            alvo.vida = 0;
            alvo.isMorto = true;
            System.out.println(alvo.nome + " foi derrotado");
        } else {
            System.out.println(alvo.nome + " agora tem " + alvo.vida + " de vida.");
        }
    }
}

//Print

 class Main {
    public static void main (String[] args) {
        Personagem personagem1 = new Personagem("Jinx", 200, 50, 60);
        Personagem personagem2 = new Personagem("Caitlyn", 150, 40, 50);

        personagem1.Info();
        personagem2.Info();

        personagem1.atacar(personagem2);
        personagem1.atacar(personagem2);
        personagem1.atacar(personagem2);

        personagem2.atacar(personagem1);

        personagem1.Info();
        personagem2.Info();
    }
}
