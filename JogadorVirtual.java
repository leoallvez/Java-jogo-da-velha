package jogodavelha2.pkg0;

import java.util.Random;

/**
 * Projeto jogo da velha.
 * @author Leonardo Pereira Alves.
 * @version 2.0 26/06/2015 - 27/06/2015
 */

public class JogadorVirtual extends Jogador{
    
    public JogadorVirtual(String nome, int id) {
        super(nome,id);
        vez = false;
    }
    
    private void joga(){
        int maior = 0, x = 0;
     
        for(int i = 0; i < Tabela.posicoes.length; i++){
            if((Tabela.posicoes[i] > maior) && (Tabela.vazio(i))){
                maior = Tabela.posicoes[i];
                x = i;   
            }
        }
        Tabela.posicoes[x] = id;
    } 
    
    public void jogaAleatoriamente(){
        Random random = new Random();
        int mov = random.nextInt(9);
        Tabela.posicoes[mov] = id;    
    }
    
    private boolean podeVencer(int id){
        int[] t = Tabela.posicoes; 
        int p = 10;
        
        //Horizontal Superior
        if((t[0] == id) && (t[1] == id) && (Tabela.vazio(2))){t[2] = p; return true;}
        if((t[1] == id) && (t[2] == id) && (Tabela.vazio(0))){t[0] = p; return true;}
        if((t[0] == id) && (t[2] == id) && (Tabela.vazio(1))){t[1] = p; return true;}
        
        //Horizontal Central
        if((t[3] == id) && (t[4] == id) && (Tabela.vazio(5))){t[5] = p; return true;}
        if((t[4] == id) && (t[5] == id) && (Tabela.vazio(3))){t[3] = p; return true;}
        if((t[3] == id) && (t[5] == id) && (Tabela.vazio(4))){t[4] = p; return true;}
        
        //Horizontal Inferior
        if((t[6] == id) && (t[7] == id) && (Tabela.vazio(8))){t[8] = p; return true;}
        if((t[7] == id) && (t[8] == id) && (Tabela.vazio(6))){t[6] = p; return true;}
        if((t[6] == id) && (t[8] == id) && (Tabela.vazio(7))){t[7] = p; return true;}
        
        //Vertical Esquerdo
        if((t[0] == id) && (t[3] == id) && (Tabela.vazio(6))){t[6] = p; return true;}
        if((t[3] == id) && (t[6] == id) && (Tabela.vazio(0))){t[0] = p; return true;}
        if((t[0] == id) && (t[6] == id) && (Tabela.vazio(3))){t[3] = p; return true;}
        
        //Vertical Central
        if((t[1] == id) && (t[4] == id) && (Tabela.vazio(7))){t[7] = p; return true;}
        if((t[4] == id) && (t[7] == id) && (Tabela.vazio(1))){t[1] = p; return true;}
        if((t[1] == id) && (t[7] == id) && (Tabela.vazio(4))){t[4] = p; return true;}
        
        //Vertical Direito
        if((t[2] == id) && (t[5] == id) && (Tabela.vazio(8))){t[8] = p; return true;}
        if((t[5] == id) && (t[8] == id) && (Tabela.vazio(2))){t[2] = p; return true;}
        if((t[2] == id) && (t[8] == id) && (Tabela.vazio(5))){t[5] = p; return true;}
        
        //Diagonais
        if((t[0] == id) && (t[4] == id) && (Tabela.vazio(8))){t[8] = p; return true;}
        if((t[4] == id) && (t[8] == id) && (Tabela.vazio(0))){t[0] = p; return true;}
        if((t[0] == id) && (t[8] == id) && (Tabela.vazio(4))){t[4] = p; return true;}
        
        if((t[4] == id) && (t[6] == id) && (Tabela.vazio(2))){t[2] = p; return true;}
        if((t[4] == id) && (t[2] == id) && (Tabela.vazio(6))){t[6] = p; return true;}
        if((t[6] == id) && (t[2] == id) && (Tabela.vazio(4))){t[4] = p; return true;}
        
        Tabela.posicoes = t;
     
        return false;   
    }
    
    public void analisarEjogar(int idOponente){
        if(podeVencer(this.id)){ 
            joga();
        }else if(podeVencer(idOponente)){
            joga();
        }else{
            joga();
        }
    }
}//Fim da classe JogadorVitual
