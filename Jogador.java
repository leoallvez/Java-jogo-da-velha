package jogodavelha2.pkg0;

/**
 * Projeto jogo da velha.
 * @author Leonardo Pereira Alves.
 * @version 2.0 26/06/2015 - 27/06/2015
 */
public class Jogador {
    protected String nome;
    protected boolean vez;
    protected int id;
    protected int pontos;
    
    Jogador(String nome, int id){
        this.nome = nome;
        this.id = id;
        this.pontos = 0;
    }
    
    public void mudaVez(){
        vez = !vez;
    }
    
    public boolean getVez(){return vez;}
    public void joga(int mov){
        if(Tabela.vazio(mov)){Tabela.posicoes[mov] = id;}
    }
    
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
    
    public void marcaPonto(){
        pontos = pontos + 1;
    }
    
    public int getId() {
        return id;
    }
    
    public void zeraPonto(){
        pontos = 0;
    }
    
    public boolean ganhou(){
        int[] t = Tabela.posicoes;
        return
        //Horizontais
       (((t[0] == id)&&(t[1] == id)&&(t[2] == id)) ||
        ((t[3] == id)&&(t[4] == id)&&(t[5] == id)) ||
        ((t[6] == id)&&(t[7] == id)&&(t[8] == id)) ||
        //Verticais
        ((t[0] == id)&&(t[3] == id)&&(t[6] == id)) ||
        ((t[1] == id)&&(t[4] == id)&&(t[7] == id)) ||
        ((t[2] == id)&&(t[5] == id)&&(t[8] == id)) ||
        //Diagonais
        ((t[0] == id)&&(t[4] == id)&&(t[8] == id)) ||
        ((t[6] == id)&&(t[4] == id)&&(t[2] == id)));
    }
} //Fim da classe Jogador
