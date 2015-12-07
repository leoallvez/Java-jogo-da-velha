package jogodavelha2.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * Projeto jogo da velha.
 * @author Leonardo Pereira Alves.
 * @version 2.0 26/06/2015 - 27/06/2015
 */

public final class Interface extends JFrame {
    
    private JMenuBar menu;
    private final JMenu opcoes;
    private final JMenuItem novoJogo;
    private final JMenuItem voltar;
    private final JSeparator separador;
    private final JMenuItem sair;
    private final JButton[] lacuna;
    private final JLabel placar;
    private final JLabel status;
    private final JPanel barraDeStatus;
    private final JPanel tabela;
    private final JButton novaPartida;
    private final Icon x1; 
    private final Icon o1;
    private final Icon x2;
    private final Icon o2;
    private final Icon x3;
    private final Icon o3;
    private final Color azul;
    private final Color verde;
    private final Color amarelo;
    private final Color branco;
    private final Color preto;
    private final JogadorVirtual playOne;
    private final Jogador playTwo;
    private Tabela game;
    private MenuPrincipal menuP;
    
    public Interface(){
        super("Jogo Da Velha - 2.0 ");
        menuP = new MenuPrincipal(this);
        playOne = new JogadorVirtual("Maquina",0);
        playTwo = new Jogador ("Você",1);
        game = new Tabela(playOne,playTwo);
        setBounds(500,150,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Definido icone do programa
        URL url = this.getClass().getResource("logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        
        game.mostrar();
        
        //Defindo icones.
        x1 = new ImageIcon(getClass().getResource("x1.png"));
        o1 = new ImageIcon(getClass().getResource("o1.png"));
        x2 = new ImageIcon(getClass().getResource("x2.png"));
        o2 = new ImageIcon(getClass().getResource("o2.png"));
        x3 = new ImageIcon(getClass().getResource("x3.png"));
        o3 = new ImageIcon(getClass().getResource("o3.png"));
        
        //Defindindo cores;
        azul = new Color(0,172,255);
        verde = new Color(128,255,0);
        amarelo = new Color(255,250,25);
        branco = Color.white;
        preto = Color.black;
        
        //Definindo menus.
        menu = new JMenuBar();
        novoJogo = new JMenuItem("Novo Jogo");
        voltar = new JMenuItem("Voltar ao menu");
        separador = new JSeparator();
        sair = new JMenuItem("Sair");
        sair.setForeground(Color.red);
        opcoes = new JMenu("Opções");
        opcoes.add(novoJogo);
        opcoes.add(voltar);
        opcoes.add(separador);
        opcoes.add(sair);
        menu = new JMenuBar();
        menu.add(opcoes);
        add(menu,BorderLayout.NORTH);
        
        //Definindo Lacunas
        lacuna = new JButton[9];
        tabela = new JPanel(new GridLayout(3,3));
        for(int i = 0; i < lacuna.length; i++){
            lacuna[i] = new JButton();
            tabela.add(lacuna[i]);
        }
        preencheLacunas();
        add(tabela,BorderLayout.CENTER);
        
        //Definindo barra de status.
        status = new JLabel();
        novaPartida = new JButton("Nova Partida");
        novaPartida.setBackground(branco);
        barraDeStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        placar = new JLabel(setPlacar());
        barraDeStatus.add(placar);
        add(barraDeStatus,BorderLayout.SOUTH);
        
        //Botões de interação com o usuario.
        lacuna[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) { 
                jogada(0);
            }
        } ); 
        
        lacuna[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jogada(1);
            }
        } );
        
        lacuna[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jogada(2);
            }
        } );
        
        lacuna[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jogada(3);
            }
        } );
        
        lacuna[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) { 
                jogada(4);
            }
        } );
        
        lacuna[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) { 
                jogada(5);
            }
        } );
        
        lacuna[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jogada(6);
            }
        } );
        
        lacuna[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {  
                jogada(7);
            }
        } );
        
        lacuna[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jogada(8);
            }
        } );
        
        novoJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                reeinicia();         
            }
        });
        
        novaPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                game.inicializaTabela();
                playOne.mudaVez();
                if(playOne.getVez()){playOne.jogaAleatoriamente();}
                preencheLacunas();
                placar.setText(setPlacar());
                barraDeStatus.remove(novaPartida);
                barraDeStatus.remove(status);
                barraDeStatus.setBackground(null);
                placar.setForeground(Color.black);        
            }
        });
        
        voltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                reeinicia();
                setVisible(false);
                menuP.setVisible(true);   
            }
        });
        
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });  
    }// Fim do metodo construtor InterfaceJogoDaVelha
    
    private void preencheLacunas(){
        int[]a = Tabela.posicoes;
        for(int i = 0; i < a.length; i++){
            
            if(game.mostraPosicao(i) == playOne.getId()){
                lacuna[i].setBackground(branco);
                lacuna[i].setIcon(o1);
            }else if (game.mostraPosicao(i) == playTwo.getId()){
                lacuna[i].setBackground(branco);
                lacuna[i].setIcon(x1);
            }else{
                lacuna[i].setBackground(branco);
                lacuna[i].setIcon(null);
            }
        }
    }
    
    private void preecherVitoria(int id, Color cor, Icon c){
        int[] t = Tabela.posicoes;
        
        //Horizontais
        if((t[0] == id)&&(t[1] == id)&&(t[2] == id)){
            for(int i = 0; i < 3; i++){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        
        if((t[3] == id)&&(t[4] == id)&&(t[5] == id)){
            for(int i = 3; i < 6; i++){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        
        if((t[6] == id)&&(t[7] == id)&&(t[8] == id)){
            for(int i = 6; i < 9; i++){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        
        //Verticais
        if((t[0] == id)&&(t[3] == id)&&(t[6] == id)){
            for(int i = 0; i < 7; i += 3){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            } 
        }
        
        if((t[1] == id)&&(t[4] == id)&&(t[7] == id)){
            for(int i = 1; i < 8; i += 3){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        if((t[2] == id)&&(t[5] == id)&&(t[8] == id)){
            for(int i = 2; i < 9; i += 3){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        
        //Diaginais
        if((t[0] == id)&&(t[4] == id)&&(t[8] == id)){
            for(int i = 0; i < 9; i += 4){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
        
        if((t[6] == id)&&(t[4] == id)&&(t[2] == id)){
            for(int i = 6; i > 0; i -= 2){
                lacuna[i].setBackground(cor);
                lacuna[i].setIcon(c);
            }
        }
    }//Fim do metodo preencheVitoria.
    
    private void preencheEmpate(){
        int[] a = Tabela.posicoes;
        for(int i = 0; i < a.length; i++){
         
            if(game.mostraPosicao(i) == playOne.getId()){
                lacuna[i].setIcon(o3);
                lacuna[i].setBackground(amarelo);
            }else if (game.mostraPosicao(i) == playTwo.getId()){
                lacuna[i].setIcon(x3);
                lacuna[i].setBackground(amarelo);
            }else{
                lacuna[i].setBackground(amarelo);
                lacuna[i].setIcon(null);
            }
        }
    }
    
    private void mostraResultado(){
        if(playTwo.ganhou()){
            preecherVitoria(playTwo.getId(),verde,x2);
            playTwo.marcaPonto();
            preenche(playTwo.getNome(),verde);
        }else if(playOne.ganhou()){
            preecherVitoria(playOne.getId(),azul,o2);
            playOne.marcaPonto();
            preenche(playOne.getNome(), azul);
        }else if(game.tabelaTotalmentePreenchida()){
            preencheEmpate();
            placar.setText("EMPATE!");
            barraDeStatus.setBackground(amarelo);
            barraDeStatus.add(novaPartida);
        }
    }
    
    public void jogada(int mov){
        if((Tabela.vazio(mov)) && (!game.fimDeJogo())){
            playTwo.joga(mov);
            if(!playTwo.ganhou()){playOne.analisarEjogar(playTwo.getId());}
            preencheLacunas();
            game.mostrar();
            if(game.fimDeJogo()){mostraResultado();}
        } 
    }
    
    public String setPlacar(){
        return 
        (playTwo.getNome()+" "+playTwo.getPontos()+
        " X "+playOne.getPontos()+" "+playOne.getNome());
    }   
    
    public void reeinicia(){
        game.inicializaTabela();
        preencheLacunas();
        playOne.zeraPonto();
        playTwo.zeraPonto();
        placar.setForeground(preto);
        placar.setText(setPlacar()); 
        barraDeStatus.setBackground(null);
        barraDeStatus.remove(novaPartida);
        barraDeStatus.remove(status);
    }      
    
    public void preenche(String nome, Color cor){
        placar.setText(setPlacar());
        status.setText(nome+" VENCEU! ");
        placar.setForeground(branco);
        status.setForeground(branco);
        barraDeStatus.add(novaPartida);
        barraDeStatus.add(status);
        barraDeStatus.setBackground(cor);
    }
    
}//Fim da classe Interface.
