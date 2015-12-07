package jogodavelha2.pkg0;

/**
 * Projeto jogo da velha.
 * @author Leonardo Pereira Alves.
 * @version 2.0 26/06/2015 - 27/06/2015
 */
public final class Tabela {
    
    private final Jogador player1;
    private final Jogador player2;
    public static int[] posicoes;
    public static final int min = 2;
    
    public Tabela(Jogador player1, Jogador player2){
        this.player1 = player1;
        this.player2 = player2;
        posicoes = new int [9];
        inicializaTabela();
    }
    
    public void inicializaTabela(){
        boolean x = true;
        for(int i = 0; i < posicoes.length; i++){
            
            if(i == 4){
                posicoes[i] = 4;
            }else if(x == true){
                posicoes[i] = 3;
            }else{
                posicoes[i] = 2;
            }
            x = !x;
        }
    }
    
    public int mostraPosicao(int mov){
        return posicoes[mov];
    }
    
    public boolean tabelaTotalmentePreenchida(){
        int i = 0;
        for (int posicoe : posicoes) {
            if ((posicoe == player1.getId()) || (posicoe == player2.getId())){
                i++;
            }
        }
        return i == Tabela.posicoes.length;
    }
    
    public boolean fimDeJogo(){
        if(tabelaTotalmentePreenchida()){return true;}
        if(player1.ganhou()){return true;}
        return player2.ganhou();
    }
    
    public static boolean vazio(int mov){
        return posicoes[mov] >= min;
    }
    
    public void mostrar(){
        System.out.println();
        System.out.println();
        for(int i = 0; i < posicoes.length; i++){
            System.out.print(posicoes[i]);
            if(i % 3 == 2){System.out.println();}
        }
    }    
}//Fim da classe tabela.
