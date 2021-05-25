import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class Tela extends JFrame {
    //Painéis que serão adicionados no container
    private JPanel jpanel = new JPanel();
    private JFrame jframe = new JFrame();

    //Variável URL
    private URL iconURL;

    //String capitulo para o Save
    private String progresso;

    //Variáveis da Home
    private JButton playBtn;
    private JButton continuarBtn;
    private JButton creditosBtn;
    private JLabel homeTitulo;

    //Variáveis do Prologo
    private JLabel prologoTitulo;
    private JTextArea prologoHistoria;
    private JButton prologoAvancarBtn;

    //Variáveis do capítulo 1
    private JLabel capitulo1Titulo;
    private JTextArea capitulo1Historia;
    private JTextField capitulo1Resposta;
    private JButton capitulo1OkBtn;
    private int contCapitulo1;

    //Variáveis do Capítulo 2
    private JLabel capitulo2Titulo;
    private JTextArea capitulo2Historia;
    private JButton capitulo2NormalBtn;
    private JButton capitulo2FurtivoBtn;
    private JButton capitulo2VerificarBtn;

    //Variáveis Charada Errada
    private JLabel erradoTitulo;
    private JTextArea erradoHistoria;
    private JButton erradoTentarBtn;

    //Game Over Charada errada 3x
    private JLabel gameOverTitulo;
    private JTextArea gameOverHistoria;
    private JButton gameOverBtn;

    //Variáveis do Créditos
    private JLabel creditosTitulo;
    private JTextArea creditosTexto;
    private JLabel  creditosAgradecimentosTitulo;
    private JTextArea creditosAgradecimentosTexto;
    private JButton creditosVoltarBtn;

    //Variáveis Entrar sem medo
    private JLabel entrarSemMedoTitulo;
    private JTextArea entrarSemMedoHistoria;
    private JButton entrarSemMedoAvancarBtn;

    //Variáveis Furtivo
    private JLabel furtivoTitulo;
    private JTextArea furtivoHistoria;
    private JButton furtivoAvancarBtn;

    //Variáveis Verificar Redondezas
    private JLabel verificarRedondezasTitulo;
    private JTextArea verificarRedondezasHistoria;
    private JButton verificarRedondezasGameOverBtn;

    //Variáveis Fugir
    private JLabel capitulo3FugirTitulo;
    private JTextArea capitulo3FugirHistoria;
    private JButton fugirGameOverBtn;

    //Variáveis Capitulo 3 Confronto
    private JLabel capitulo3ConfrontoTitulo;
    private JTextArea capitulo3ConfrontoHistoria;
    private JButton atacarBtn;
    private JButton fugirBtn;

    //Variáveis Batalha
    private int dadoD20;
    private int vez;
    private JLabel batalhaTitulo;
    private JTextArea batalhaTexto;
    private Dado dado = new Dado();
    private Personagem melian = new Personagem("Melian");
    private Personagem monstro = new Personagem("Monstro");
    private JButton batalhaLutarBtn;
    private JButton batalhaFugirBtn;
    private JButton batalhaContinuarBtn;

    //Variáveis Capitulo 4 Vence Confronto
    private JLabel capitulo4VenceConfrontoTitulo;
    private JTextArea capitulo4VenceConfrontoHistoria;
    private JButton capitulo4ProcurarTesouroBtn;
    private JButton capitulo4ProcurarSobreviventesBtn;
    private int dadoDefineFinal;

    //Variáveis Game Over Confronto
    private JLabel gameOverConfrontoTitulo;
    private JTextArea gameOverConfrontoHistoria;
    private JButton gameOverConfrontoBtn;

    //Variáveis Final 3
    private JLabel final3Titulo;
    private JTextArea final3Historia;
    private JButton final3Btn;

    //Variáveis Final 2
    private JLabel final2Titulo;
    private JTextArea final2Historia;
    private JButton final2Btn;

    //Variáveis Final 1
    private JLabel final1Titulo;
    private JTextArea final1Historia;
    private JButton final1Btn;

    //Variáveis do Nenhum save
    private JLabel nenhumSaveTitulo;
    private JTextArea nenhumSaveTexto;
    private JButton nenhumSaveVoltarBtn;

    //Costrutor padrão da tela
    public Tela(String progresso) {
        this.progresso = progresso;

        jframe.setTitle("O Mistério da Tumba");

        iconURL = Tela.class.getResource("/imgs/icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        jframe.setIconImage(icon.getImage());

        jframe.setVisible(false);
        jframe.setMinimumSize(new Dimension(609, 500));
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
    }

    //Getters e Setters
    public String getProgresso(){
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public int getContCapitulo1() {
        return contCapitulo1;
    }

    public void setContCapitulo1(int contCapitulo1) {
        this.contCapitulo1 = contCapitulo1;
    }

    public int getDadoD20() {
        return dadoD20;
    }

    public void setDadoD20(int dadoD20) {
        this.dadoD20 = dadoD20;
    }

    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }

    public int getDadoDefineFinal() {
        return dadoDefineFinal;
    }

    public void setDadoDefineFinal(int dadoDefineFinal) {
        this.dadoDefineFinal = dadoDefineFinal;
    }

    //Home com botões
    public void Home() {
        contCapitulo1 = 3;
        melian.setVida(10);
        monstro.setVida(10);
        vez = 0;

        playBtn = new JButton("Play");
        playBtn.setBounds(220,125,150,30);
        ActionListener clique1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(homeTitulo);
                jframe.remove(playBtn);
                jframe.remove(continuarBtn);
                jframe.remove(creditosBtn);
                Prologo();
            }
        };
        playBtn.addActionListener(clique1);

        continuarBtn = new JButton("Continuar");
        continuarBtn.setBounds(220,165,150,30);
        ActionListener clique2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(homeTitulo);
                jframe.remove(playBtn);
                jframe.remove(continuarBtn);
                jframe.remove(creditosBtn);

                if(progresso.equals("1")) {
                    Capitulo1();
                }else if(progresso.equals("2")){
                    Capitulo2();
                }else if(progresso.equals("21")){
                    Capitulo2Furtivo();
                }else if(progresso.equals("22")){
                    Capitulo2EntrarSemMedo();
                }else if(progresso.equals("3")){
                    Capitulo3Confronto();
                }else if(progresso.equals("4")){
                    Capitulo4VenceConfronto();
                }else{
                    NenhumSave();
                }
            }
        };
        continuarBtn.addActionListener(clique2);

        creditosBtn = new JButton("Créditos");
        creditosBtn.setBounds(220,205,150,30);
        ActionListener clique3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(homeTitulo);
                jframe.remove(playBtn);
                jframe.remove(continuarBtn);
                jframe.remove(creditosBtn);
                Creditos();
            }
        };
        creditosBtn.addActionListener(clique3);

        homeTitulo = new JLabel("O Mistério da Tumba");
        homeTitulo.setFont(new Font("", 1, 20));
        homeTitulo.setBounds(195,40,300,60);

        jframe.add(homeTitulo);
        jframe.add(playBtn);
        jframe.add(continuarBtn);
        jframe.add(creditosBtn);

        jframe.getContentPane().add(jpanel, BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);

    }

    public void Prologo(){
        prologoTitulo = new JLabel("Prólogo");
        prologoTitulo.setFont(new Font("", 1, 20));
        prologoTitulo.setBounds(255,10,300, 60);

        prologoHistoria = new JTextArea("Você é Melian, uma artista marcial de muito talento, tendo desvendado vários crimes e mistérios que assolam as províncias de Kirdan. Junto à sua espada, visita várias localidades sempre procurando desafios que deem significado a sua fama.\n\nMelian ouviu rumores que em uma região do interior foi descoberta uma ruína com escrituras de uma antiga tribo desconhecida, a qual tinha tumbas e palacetes espalhadas por todo o império. Essa ruína possui escritas muito intrigantes revelando que no seu interior há grande riqueza. Por ser uma província distante, além das montanhas, tem pouca visibilidade para a capital ao ponto de ser quase esquecida – exceto no momento de cobrar os impostos. Possui um povo trabalhador e pobre que, ao descobrir sobre a ruína, muitos se aventuraram com a promessa de uma vida melhor para suas famílias. Pois aí começa o problema. Todos que entraram na tumba não voltaram e muitos boatos começaram a se espalhar ao redor da província sobre algum tipo de maldição ou monstro que habitam no interior da tumba.\n\nMelian, um tanto cética, resolve aventurar-se nesse desafio em busca de resposta às famílias e provar mais uma vez para o mundo o motivo de seus nobres títulos...\n\n*Todos os personagens começam com 10 pontos de vida.");
        prologoHistoria.setBounds(10,70,575,290);
        prologoHistoria.setWrapStyleWord(true);
        prologoHistoria.setLineWrap(true);
        prologoHistoria.setEditable(false);
        prologoHistoria.setBackground(jframe.getBackground());


        prologoAvancarBtn = new JButton("Avançar");
        prologoAvancarBtn.setBounds(220,400,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(prologoTitulo);
                jframe.remove(prologoHistoria);
                jframe.remove(prologoAvancarBtn);
                Capitulo1();
            }
        };
        prologoAvancarBtn.addActionListener(clique);

        jframe.add(prologoTitulo);
        jframe.add(prologoHistoria);
        jframe.add(prologoAvancarBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);

    }

    public void Capitulo1(){
        progresso = "1";

        capitulo1Titulo = new JLabel("Capítulo 1");
        capitulo1Titulo.setBounds(255,10,300, 60);
        capitulo1Titulo.setFont(new Font("", 1, 20));

        capitulo1Historia = new JTextArea("Ao chegar na cidade, dirigiu-se à uma taverna atrás de informações e, se possível, a localização exata da tal tumba amaldiçoada.\n" +
                "Durante uma conversa com o dono da taverna, revelou-se o local da tumba, afinal, não era segredo nenhum para as pessoas da cidade tudo que estava ocorrendo com os desaparecimentos.\n" +
                "No dia seguinte, Melian iniciou sua busca e, somente ao entardecer, encontrou com facilidade um portão enorme com escrituras da antiga língua que para ela não era um desafio traduzir.\n" +
                "Em destaque encontrava-se a seguinte frase:\n" +
                " \n" +
                "“Fui criada no primeiro dia e através de mim, o interior desta tumba, seu tesouro e até este portão brilhará… Assim que você, mais uma vez, me nomear.”\n" +
                " \n" +
                "Melian tentou empurrar o portão, mas sem êxito.\n" +
                " \n" +
                "   - Deve haver uma forma mais fácil! Não é possível empurrar um portão desses.\n" +
                " \n" +
                "Ela olhou ao redor e avistou algumas pedras. Em cada uma, havia entalhada uma letra do alfabeto antigo, logo ela percebeu o que deveria ser feito.\n" +
                " \n" +
                "   - Devo organizar as pedras em frente ao portão e a resposta deve estar relacionada com as escrituras.");
        capitulo1Historia.setBounds(10,70,575,310);
        capitulo1Historia.setWrapStyleWord(true);
        capitulo1Historia.setLineWrap(true);
        capitulo1Historia.setEditable(false);
        capitulo1Historia.setBackground(jframe.getBackground());

        capitulo1Resposta = new JTextField("Qual foi a resposta de Melian?");
        capitulo1Resposta.setBounds(160,390,200, 30);
        capitulo1Resposta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                capitulo1Resposta.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                capitulo1Resposta.setToolTipText("Se estiver com dificuldade, pesquise no Google ;)");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        capitulo1OkBtn = new JButton("Ok (" + contCapitulo1 + ")");
        capitulo1OkBtn.setBounds(361,390, 70,29);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo1Titulo);
                jframe.remove(capitulo1Historia);
                jframe.remove(capitulo1Resposta);
                jframe.remove(capitulo1OkBtn);
                if(capitulo1Resposta.getText().toLowerCase().equals("luz")){
                    Capitulo2();
                }
                else{
                    if(contCapitulo1>1) {
                        contCapitulo1--;
                        CharadaErrada();
                    }else{
                        GameOverCharada();
                    }
                }
            }
        };
        capitulo1OkBtn.addActionListener(clique);

        jframe.add(capitulo1Titulo);
        jframe.add(capitulo1Historia);
        jframe.add(capitulo1Resposta);
        jframe.add(capitulo1OkBtn);

        jframe.getContentPane().add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Capitulo2(){
        progresso = "2";

        capitulo2Titulo = new JLabel("Capítulo 2");
        capitulo2Titulo.setBounds(255,10,300, 60);
        capitulo2Titulo.setFont(new Font("", 1, 20));

        capitulo2Historia =  new JTextArea("De repente as pedras que ela organizara na frente do portão brilharam, assim como o portão também. O Chão começou a tremer e um estrondo muito alto ecoou a partir do portão. Lentamente abriu-se a entrada para a tumba.\n" +
                " \n" +
                "   - Aahh, finalmente! Mas preciso tomar cuidado e pensar bem no que devo fazer a partir de agora.\n");
        capitulo2Historia.setBounds(10,125,575,150);
        capitulo2Historia.setWrapStyleWord(true);
        capitulo2Historia.setLineWrap(true);
        capitulo2Historia.setEditable(false);
        capitulo2Historia.setBackground(jframe.getBackground());

        capitulo2NormalBtn = new JButton("Entrar Sem Medo");
        capitulo2NormalBtn.setBounds(65,300,150,30);
        //click no btn "Entrar sem medo"
        ActionListener clique3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo2Titulo);
                jframe.remove(capitulo2Historia);
                jframe.remove(capitulo2FurtivoBtn);
                jframe.remove(capitulo2NormalBtn);
                jframe.remove(capitulo2VerificarBtn);
                Capitulo2EntrarSemMedo();
            }
        };
        capitulo2NormalBtn.addActionListener(clique3);

        capitulo2FurtivoBtn = new JButton("Entrar Furtivamente");
        capitulo2FurtivoBtn.setBounds(216,300,150,30);
        //click no btn "Entrar frutivamente"
        ActionListener clique5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo2Titulo);
                jframe.remove(capitulo2Historia);
                jframe.remove(capitulo2FurtivoBtn);
                jframe.remove(capitulo2NormalBtn);
                jframe.remove(capitulo2VerificarBtn);
                Capitulo2Furtivo();
            }
        };
        capitulo2FurtivoBtn.addActionListener(clique5);

        capitulo2VerificarBtn = new JButton("Verificar Redondezas");
        capitulo2VerificarBtn.setBounds(367,300,160,30);
        //click no btn "Verificar redondezas"
        ActionListener clique6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo2Titulo);
                jframe.remove(capitulo2Historia);
                jframe.remove(capitulo2FurtivoBtn);
                jframe.remove(capitulo2NormalBtn);
                jframe.remove(capitulo2VerificarBtn);
                Capitulo2VerificarRedondezas();
            }
        };
        capitulo2VerificarBtn.addActionListener(clique6);

        jframe.add(capitulo2Titulo);
        jframe.add(capitulo2Historia);
        jframe.add(capitulo2NormalBtn);
        jframe.add(capitulo2FurtivoBtn);
        jframe.add(capitulo2VerificarBtn);

        jframe.getContentPane().add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }


    //SUELEN MEXENDO ---------------------------------------------------------------------------------------------------

    public void Capitulo2VerificarRedondezas() {
        progresso = "null";
        
        verificarRedondezasTitulo = new JLabel("Melian preferiu verificar as redondezas do local...");
        verificarRedondezasTitulo.setFont(new Font("", 1, 15));
        verificarRedondezasTitulo.setBounds(135,10,360, 60);

        verificarRedondezasHistoria = new JTextArea("Levando em conta que o portão é impossível de ser aberto apenas com força física, Melian pensou ser improvável que tantos desaparecimentos estivessem ocorrendo naquela tumba. Então resolveu averiguar as redondezas à procura de mais pistas. \n\n" +
                "Depois de cinco dias de intensas buscas, Melian não encontrou nenhum rastro.\n" +
                "Ela voltou para a capital e seguiu sua vida e atividades que a tornaram tão famosa. \n\n" +
                "Infelizmente, os boatos de seu fracasso à alcançaram na capital e marcaram negativamente sua carreira até o fim de sua vida.\n");

        verificarRedondezasHistoria.setBounds(10,100,575,250);
        verificarRedondezasHistoria.setWrapStyleWord(true);
        verificarRedondezasHistoria.setLineWrap(true);
        verificarRedondezasHistoria.setEditable(false);
        verificarRedondezasHistoria.setBackground(jframe.getBackground());

        verificarRedondezasGameOverBtn = new JButton("Game Over");
        verificarRedondezasGameOverBtn.setBounds(220,385,150,30);
        ActionListener clique4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(verificarRedondezasTitulo);
                jframe.remove(verificarRedondezasHistoria);
                jframe.remove(verificarRedondezasGameOverBtn);
                Home();
            }
        };
        verificarRedondezasGameOverBtn.addActionListener(clique4);

        jframe.add(verificarRedondezasTitulo);
        jframe.add(verificarRedondezasHistoria);
        jframe.add(verificarRedondezasGameOverBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Capitulo2Furtivo() {
        progresso = "21";

        furtivoTitulo = new JLabel("Melian entrou furtivamente no local");
        furtivoTitulo.setFont(new Font("", 1, 15));
        furtivoTitulo.setBounds(180,10,340, 60);

        furtivoHistoria = new JTextArea("Ainda do lado de fora da tumba, Melian observou atentamente o enorme corredor, o qual estava selado pelo portão gigante.  Dali não era possível avistar o fim do corredor. Mesmo sem tochas no interior da tumba, ainda podia enxergar alguma coisa (mesmo com certa dificuldade), como se houvesse um brilho natural semelhante a uma noite de lua cheia.\n\n" +
                "Mesmo assim ela decidiu entrar com cautela, pois não sabia o que podia estar escondido ali.\n" +
                "Avançando com cuidado ela observou gravuras nas paredes. Nelas apareciam os antigos povos, que moravam ali, venerando uma criatura. Algo que ela nunca vira em seus anos de estudos sobre povos antigos. Mostrava pessoas levando tributos e preparando banquetes, além de rituais de sacrifício.\n" +
                "Após alguns longos minutos de caminhada, ela chegou no fim do corredor, o ambiente abriu-se de uma forma que a deixou sem fôlego:\n" +
                " \n" +
                "   - Esse lugar é imenso. Como é possível ter ficado escondido todos esses anos?! - Pensou, enquanto se segurava para não esboçar reações que pudessem chamar a atenção de algo que ela não queria.\n");

        furtivoHistoria.setBounds(10,100,575,280);
        furtivoHistoria.setWrapStyleWord(true);
        furtivoHistoria.setLineWrap(true);
        furtivoHistoria.setEditable(false);
        furtivoHistoria.setBackground(jframe.getBackground());

        furtivoAvancarBtn = new JButton("Avançar");
        furtivoAvancarBtn.setBounds(220,385,150,30);
        ActionListener clique5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(furtivoTitulo);
                jframe.remove(furtivoHistoria);
                jframe.remove(furtivoAvancarBtn);
                Capitulo3Confronto();
            }
        };
        furtivoAvancarBtn.addActionListener(clique5);

        jframe.add(furtivoTitulo);
        jframe.add(furtivoHistoria);
        jframe.add(furtivoAvancarBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Capitulo2EntrarSemMedo() {
        progresso = "22";

        entrarSemMedoTitulo = new JLabel("Melian entrou no local sem medo");
        entrarSemMedoTitulo.setFont(new Font("", 1, 15));
        entrarSemMedoTitulo.setBounds(180,10,340, 60);

        entrarSemMedoHistoria = new JTextArea("Ainda do lado de fora da tumba, Melian observou atentamente o enorme corredor, o qual estava selado pelo portão gigante.  Dali não era possível avistar o fim do corredor. Mesmo sem tochas no interior da tumba, ainda podia enxergar alguma coisa (mesmo com certa dificuldade), como se houvesse um brilho natural semelhante a uma noite de lua cheia.\n\n" +
                "Melian sentiu-se segura para adentrar a tumba sem grandes anseios, afinal não avistara nenhum perigo. \n\n" +
                "Seguiu seu caminho a passos largos. Seu instinto dizia que estava no caminho certo.\n" +
                "Ao chegar no fim do corredor, o ambiente abriu-se de uma forma que a deixou sem fôlego:\n" +
                " \n" +
                "   - Esse lugar é imenso. Como é possível ter ficado escondido todos esses anos?!\n");


        entrarSemMedoHistoria.setBounds(10,100,575,280);
        entrarSemMedoHistoria.setWrapStyleWord(true);
        entrarSemMedoHistoria.setLineWrap(true);
        entrarSemMedoHistoria.setEditable(false);
        entrarSemMedoHistoria.setBackground(jframe.getBackground());

        entrarSemMedoAvancarBtn = new JButton("Avançar");
        entrarSemMedoAvancarBtn.setBounds(220,385,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(entrarSemMedoTitulo);
                jframe.remove(entrarSemMedoHistoria);
                jframe.remove(entrarSemMedoAvancarBtn);
                Capitulo3Confronto();
            }
        };
        entrarSemMedoAvancarBtn.addActionListener(clique);

        jframe.add(entrarSemMedoTitulo);
        jframe.add(entrarSemMedoHistoria);
        jframe.add(entrarSemMedoAvancarBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Capitulo3Fugir() {
        progresso = "null";

        capitulo3FugirTitulo = new JLabel("Melian fugiu o mais rápido possível...");
        capitulo3FugirTitulo.setFont(new Font("", 1, 15));
        capitulo3FugirTitulo.setBounds(180,10,340, 60);

        capitulo3FugirHistoria = new JTextArea("Mesmo com sua habilidade formidável com uma espada, Melian sentia que não poderia vencer daquela criatura. \n" +
                " \n" +
                "- Preciso dar um jeito de escapar dessa. Essa coisa parece ser 3 vezes mais forte que qualquer um que já enfrentei. Não sei se consigo sair viva deste confronto. Assim que aparecer uma brecha, tentarei escapar. - Pensou rapidamente.\n" +
                " \n" +
                " \n" +
                "Assim que a criatura fez sua primeira investida, Melian desviou e correu para longe dali em direção a saída. A criatura não contente voltou-se para Melian e começou a persegui-la. Enquanto ela corria com todas as sua forças, a criatura logo atrás a cada segundo diminuía a distância entre os dois. Quando a criatura estava quase alcançando Melian, ela conseguiu atravessar o portão que fechou-se num instante, jogando a criatura para dentro da tumba novamente.\n");

        capitulo3FugirHistoria.setBounds(10,100,575,280);
        capitulo3FugirHistoria.setWrapStyleWord(true);
        capitulo3FugirHistoria.setLineWrap(true);
        capitulo3FugirHistoria.setEditable(false);
        capitulo3FugirHistoria.setBackground(jframe.getBackground());

        fugirGameOverBtn = new JButton("Game Over");
        fugirGameOverBtn.setBounds(220,385,150,30);
        ActionListener clique8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo3FugirTitulo);
                jframe.remove(capitulo3FugirHistoria);
                jframe.remove(fugirGameOverBtn);
                Home();
            }
        };
        fugirGameOverBtn.addActionListener(clique8);

        jframe.add(capitulo3FugirTitulo);
        jframe.add(capitulo3FugirHistoria);
        jframe.add(fugirGameOverBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    //TELA DA LUTA
    public void Capitulo3Confronto() {
        progresso = "3";

        capitulo3ConfrontoTitulo = new JLabel("Capítulo 3");
        capitulo3ConfrontoTitulo.setFont(new Font("", 1, 20));
        capitulo3ConfrontoTitulo.setBounds(245,7,340, 60);

        capitulo3ConfrontoHistoria = new JTextArea("Enquanto procurava por mais pistas, encontrou alguns corpos ou o que sobrou deles. Seriam das pessoas que estavam a procura do tal tesouro ou de alguma alma que habitará há anos este local... A energia era sufocante e amedrontadora, mas não foi o suficiente para abalar seus nervos, pois sua mente foi treinada. \n\n" +
                "Havia um rastro no chão que, estranhamente, se espelhava também no teto da tumba, como um reflexo. Ao caminhar mais para dentro da tumba, alguns ossos quebrados espalhados se encontravam dispersos pelo chão, como se tivessem sido pisados recentemente. Naquela direção havia outro corredor, um pouco menor desta vez e um tanto mais escuro.\n" +
                "Ao entrar, logo esbarrou em uma criatura que nunca havia visto antes, nem em seus pesadelos. A criatura era alta, quase batia a cabeça no teto do corredor, envolta de escuridão, somente podia-se ver sua silhueta e seus enormes olhos vermelhos fixos em Melian, como se ela fosse uma presa diante de seu predador. Melian entoou algumas palavras e sacou a espada que emitiu um raio, o qual percorreu toda a lâmina e desapareceu, assumindo posição de defesa. Foi então que a criatura mostrou inteligência e de suas mãos era possível ver uma clava.\n" +
                "" +
                "   - Mais uma alma será rompida. Vou matá-la e servi-la como alimento!\n" +
                " \n" +
                "Melian respondeu:\n    - Você fala?! Mas não por muito tempo!\n\n" +
                "                                                                       O que Melian deve fazer?\n");

        capitulo3ConfrontoHistoria.setBounds(10,60,575,340);
        capitulo3ConfrontoHistoria.setWrapStyleWord(true);
        capitulo3ConfrontoHistoria.setLineWrap(true);
        capitulo3ConfrontoHistoria.setEditable(false);
        capitulo3ConfrontoHistoria.setBackground(jframe.getBackground());

        atacarBtn = new JButton("Lutar");
        atacarBtn.setBounds(135, 415, 150, 30);
        ActionListener clique1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo3ConfrontoTitulo);
                jframe.remove(capitulo3ConfrontoHistoria);
                jframe.remove(atacarBtn);
                jframe.remove(fugirBtn);
                Batalha();
            }
        };
        atacarBtn.addActionListener(clique1);

        fugirBtn = new JButton("Fugir");
        fugirBtn.setBounds(305, 415, 150, 30);
        ActionListener clique2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo3ConfrontoTitulo);
                jframe.remove(capitulo3ConfrontoHistoria);
                jframe.remove(atacarBtn);
                jframe.remove(fugirBtn);
                Capitulo3Fugir();
            }
        };
        fugirBtn.addActionListener(clique2);

        jframe.add(capitulo3ConfrontoTitulo);
        jframe.add(capitulo3ConfrontoHistoria);
        jframe.add(atacarBtn);
        jframe.add(fugirBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Batalha(){
        dadoD20 = dado.D20();
        if(vez == 0) {
            vez = 1;

            batalhaTitulo = new JLabel("Confronto");
            batalhaTitulo.setFont(new Font("", 1, 20));
            batalhaTitulo.setBounds(225, 50, 340, 60);

            if (dadoD20 > 10) {
                batalhaTexto = new JTextArea("Dado(D20) = "+ dadoD20 + "\n\n" + melian.getNome() + " acertou um golpe!\n\nDano (D8)= " + String.valueOf(monstro.Dano()));
                batalhaTexto.setBounds(220, 170, 500, 100);
                batalhaTexto.setWrapStyleWord(true);
                batalhaTexto.setLineWrap(true);
                batalhaTexto.setEditable(false);
                batalhaTexto.setBackground(jframe.getBackground());

                batalhaContinuarBtn = new JButton("Continuar");
                batalhaContinuarBtn.setBounds(200, 300, 150, 30);
                ActionListener clique = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jframe.remove(batalhaTitulo);
                        jframe.remove(batalhaTexto);
                        jframe.remove(batalhaContinuarBtn);
                        if (monstro.getVida()<=0){
                            Capitulo4VenceConfronto();
                        }else {
                            Batalha();
                        }
                    }
                };
                batalhaContinuarBtn.addActionListener(clique);

            } else {
                batalhaTexto = new JTextArea("Dado(D20) = "+ dadoD20 + "\n\n" + melian.getNome() + " errou o golpe!");
                batalhaTexto.setBounds(220, 170, 500, 100);
                batalhaTexto.setWrapStyleWord(true);
                batalhaTexto.setLineWrap(true);
                batalhaTexto.setEditable(false);
                batalhaTexto.setBackground(jframe.getBackground());

                batalhaContinuarBtn = new JButton("Continuar");
                batalhaContinuarBtn.setBounds(200, 300, 150, 30);
                ActionListener clique = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jframe.remove(batalhaTitulo);
                        jframe.remove(batalhaTexto);
                        jframe.remove(batalhaContinuarBtn);
                        Batalha();
                    }
                };
                batalhaContinuarBtn.addActionListener(clique);

            }
            jframe.add(batalhaTitulo);
            jframe.add(batalhaTexto);
            jframe.add(batalhaContinuarBtn);

        }else {
            vez = 0;

            batalhaTitulo = new JLabel("Confronto");
            batalhaTitulo.setFont(new Font("", 1, 20));
            batalhaTitulo.setBounds(225, 50, 340, 60);

            if (dadoD20 > 10) {
                batalhaTexto = new JTextArea("Dado(D20) = "+ dadoD20 + "\n\n" + monstro.getNome() + " acertou um golpe!\n\nDano (D8)= " + String.valueOf(melian.Dano()));
                batalhaTexto.setBounds(220, 170, 500, 100);
                batalhaTexto.setWrapStyleWord(true);
                batalhaTexto.setLineWrap(true);
                batalhaTexto.setEditable(false);
                batalhaTexto.setBackground(jframe.getBackground());

                if(melian.getVida()<=0){
                    batalhaContinuarBtn = new JButton("Continuar");
                    batalhaContinuarBtn.setBounds(200, 300, 150, 30);
                    ActionListener clique = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jframe.remove(batalhaTitulo);
                            jframe.remove(batalhaTexto);
                            jframe.remove(batalhaContinuarBtn);
                            GameOverConfronto();
                        }
                    };
                    batalhaContinuarBtn.addActionListener(clique);

                    jframe.add(batalhaContinuarBtn);
                }else {

                    batalhaLutarBtn = new JButton("Lutar");
                    batalhaLutarBtn.setBounds(135, 300, 150, 30);
                    ActionListener clique1 = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jframe.remove(batalhaTitulo);
                            jframe.remove(batalhaTexto);
                            jframe.remove(batalhaLutarBtn);
                            jframe.remove(batalhaFugirBtn);
                            Batalha();
                        }
                    };
                    batalhaLutarBtn.addActionListener(clique1);

                    batalhaFugirBtn = new JButton("Fugir");
                    batalhaFugirBtn.setBounds(305, 300, 150, 30);
                    ActionListener clique2 = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jframe.remove(batalhaTitulo);
                            jframe.remove(batalhaTexto);
                            jframe.remove(batalhaLutarBtn);
                            jframe.remove(batalhaFugirBtn);
                            Capitulo3Fugir();
                        }
                    };
                    batalhaFugirBtn.addActionListener(clique2);

                    jframe.add(batalhaLutarBtn);
                    jframe.add(batalhaFugirBtn);
                }
                jframe.add(batalhaTitulo);
                jframe.add(batalhaTexto);

            } else {
                batalhaTexto = new JTextArea("Dado(D20) = "+ dadoD20 + "\n\n" + monstro.getNome() + " errou o golpe!");
                batalhaTexto.setBounds(220, 170, 500, 100);
                batalhaTexto.setWrapStyleWord(true);
                batalhaTexto.setLineWrap(true);
                batalhaTexto.setEditable(false);
                batalhaTexto.setBackground(jframe.getBackground());

                batalhaLutarBtn = new JButton("Lutar");
                batalhaLutarBtn.setBounds(135, 300, 150, 30);
                ActionListener clique1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jframe.remove(batalhaTitulo);
                        jframe.remove(batalhaTexto);
                        jframe.remove(batalhaLutarBtn);
                        jframe.remove(batalhaFugirBtn);
                        Batalha();
                    }
                };
                batalhaLutarBtn.addActionListener(clique1);

                batalhaFugirBtn = new JButton("Fugir");
                batalhaFugirBtn.setBounds(305, 300, 150, 30);
                ActionListener clique2 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jframe.remove(batalhaTitulo);
                        jframe.remove(batalhaTexto);
                        jframe.remove(batalhaLutarBtn);
                        jframe.remove(batalhaFugirBtn);
                        Capitulo3Fugir();
                    }
                };
                batalhaFugirBtn.addActionListener(clique2);

                jframe.add(batalhaTitulo);
                jframe.add(batalhaTexto);
                jframe.add(batalhaLutarBtn);
                jframe.add(batalhaFugirBtn);
            }
        }
        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void GameOverConfronto(){
        progresso = "null";

        gameOverConfrontoTitulo = new JLabel("Golpe fatal!");
        gameOverConfrontoTitulo.setFont(new Font("", 1, 15));
        gameOverConfrontoTitulo.setBounds(260,10,340, 60);

        gameOverConfrontoHistoria = new JTextArea("Com a rapidez de um piscar de olhos, a criatura desferiu um golpe fatal e, naquele local, Melian deu seu último suspiro, mas sem antes conseguir criar uma barreira de energia capaz de impedir qualquer pessoa de se aproximar da tumba... E ninguém mais conseguiu entrar naquela tumba. \n\n" +
                "Após um mês de seu desaparecimento, amigos, familiares e colegas a homenagearam na capital e fizeram um enterro simbólico, já que seu corpo nunca voltou para casa.\n");
        gameOverConfrontoHistoria.setBounds(10,90,575,290);
        gameOverConfrontoHistoria.setWrapStyleWord(true);
        gameOverConfrontoHistoria.setLineWrap(true);
        gameOverConfrontoHistoria.setEditable(false);
        gameOverConfrontoHistoria.setBackground(jframe.getBackground());

        gameOverConfrontoBtn = new JButton("Game over");
        gameOverConfrontoBtn.setBounds(220,385,150,30);
        ActionListener clique13 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(gameOverConfrontoTitulo);
                jframe.remove(gameOverConfrontoHistoria);
                jframe.remove(gameOverConfrontoBtn);
                Home();
            }
        };
        gameOverConfrontoBtn.addActionListener(clique13);

        jframe.add(gameOverConfrontoTitulo);
        jframe.add(gameOverConfrontoHistoria);
        jframe.add(gameOverConfrontoBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Capitulo4VenceConfronto(){
        progresso = "4";

        capitulo4VenceConfrontoTitulo = new JLabel("Melian derrota o inimigo");
        capitulo4VenceConfrontoTitulo.setFont(new Font("", 1, 15));
        capitulo4VenceConfrontoTitulo.setBounds(210,10,340, 60);

        capitulo4VenceConfrontoHistoria = new JTextArea("A criatura soturna avançou na direção de Melian que, rapidamente concentrou sua energia na sua espada e desferiu um golpe, como um relâmpago, atravessando o tronco da criatura que soltou um breve suspiro e desvaneceu lentamente... logo percebeu-se que a escuridão estava se dissipando da tumba.\n\n" +
                "   - Essa foi por pouco. Me pergunto se ainda há sobreviventes aqui. Duvido que algo tenha passado despercebido por aquela coisa.\n");

        capitulo4VenceConfrontoHistoria.setBounds(10,100,575,280);
        capitulo4VenceConfrontoHistoria.setWrapStyleWord(true);
        capitulo4VenceConfrontoHistoria.setLineWrap(true);
        capitulo4VenceConfrontoHistoria.setEditable(false);
        capitulo4VenceConfrontoHistoria.setBackground(jframe.getBackground());

        capitulo4ProcurarTesouroBtn = new JButton("Procurar tesouro");
        capitulo4ProcurarTesouroBtn.setBounds(120,385,150,30);
        ActionListener clique9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo4VenceConfrontoTitulo);
                jframe.remove(capitulo4VenceConfrontoHistoria);
                jframe.remove(capitulo4ProcurarTesouroBtn);
                jframe.remove(capitulo4ProcurarSobreviventesBtn);
                dadoDefineFinal = dado.D20();
                if(dadoDefineFinal>10) {
                    Final1();
                }else{
                    Final2();
                }
            }
        };
        capitulo4ProcurarTesouroBtn.addActionListener(clique9);

        capitulo4ProcurarSobreviventesBtn = new JButton("Procurar sobreviventes");
        capitulo4ProcurarSobreviventesBtn.setBounds(300,385,170,30);
        ActionListener clique10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(capitulo4VenceConfrontoTitulo);
                jframe.remove(capitulo4VenceConfrontoHistoria);
                jframe.remove(capitulo4ProcurarTesouroBtn);
                jframe.remove(capitulo4ProcurarSobreviventesBtn);
                    Final3();
            }
        };
        capitulo4ProcurarSobreviventesBtn.addActionListener(clique10);

        jframe.add(capitulo4VenceConfrontoTitulo);
        jframe.add(capitulo4VenceConfrontoHistoria);
        jframe.add(capitulo4ProcurarTesouroBtn);
        jframe.add(capitulo4ProcurarSobreviventesBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Final3() {
        progresso = "null";

        final3Titulo = new JLabel("Final bom!");
        final3Titulo.setFont(new Font("", 1, 15));
        final3Titulo.setBounds(260,10,340, 60);

        final3Historia = new JTextArea("Mesmo com grandes empecilhos para sobreviver naquele local, Melian sabia da capacidade humana de resistir ao improvável e ela mesma acabara de mostrar um exemplo disso. \n" +
                "Resolveu continuar suas buscas por sobreviventes seguindo os rastros que encontrara naquele lugar. Após horas caminhando em diversos corredores, encontrou uma câmara fechada, mas os rastros convergiam naquela direção. Melian gritou por alguém na esperança de ouvir uma resposta.\n" +
                " \n" +
                "   - Aqui!! Estamos aqui!!!\n" +
                " \n" +
                "Finalmente ela escutou. Com certo esforço as pessoas que estavam na câmara abriram a porta. Melian resgatou cerca de 4 pessoas. Infelizmente muitos perderam a vida ali, mas para algumas famílias aquele não foi o fim.\n\n" +
                "Melian ficou mais alguns dias no vilarejo ajudando aqueles que resgatara, pois estavam debilitados devido a falta de comida e água. Felizmente, todos melhoraram e dentro de pouco tempo voltaram as suas atividades normais.\n\n" +
                "A pequena província recompensou Melian com o que podia, mas para ela, era mais do que precisava. O que buscava era uma aventura, um desafio, uma história.\n");

        final3Historia.setBounds(10,80,575,290);
        final3Historia.setWrapStyleWord(true);
        final3Historia.setLineWrap(true);
        final3Historia.setEditable(false);
        final3Historia.setBackground(jframe.getBackground());

        final3Btn = new JButton("Fim");
        final3Btn.setBounds(220,385,150,30);
        ActionListener clique11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(final3Titulo);
                jframe.remove(final3Historia);
                jframe.remove(final3Btn);
                Home();
            }
        };
        final3Btn.addActionListener(clique11);

        jframe.add(final3Titulo);
        jframe.add(final3Historia);
        jframe.add(final3Btn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Final2() { //AJUSTAR PARA QUE SEJA UM FINAL NEUTRO, POIS PARECE UM FINAL RUIM E DIMINUIR O TEXTO TBM?
        progresso = "null";

        final2Titulo = new JLabel("Dado(D20) = " + dadoDefineFinal +"   Final neutro");
        final2Titulo.setFont(new Font("", 1, 15));
        final2Titulo.setBounds(200,10,340, 50);

        final2Historia = new JTextArea("Melian levou em consideração tudo o que passou para sobreviver e achou improvável que alguém estivesse vivo, principalmente considerando o que vivia ali. Então decidiu procurar pelo tesouro, afinal o que impedia o sucesso dos exploradores já foi resolvido.\n\n" +
                "Após andar por horas, atravessando corredores, como um labirinto, se deparou com uma câmara que, em seu interior, brilhava em ouro um tesouro que seria impossível ser carregado sozinho, imaginou que poderia ter armadilhas e se certificou que a saída da câmara não se fechasse colocando alguns obstáculos que encontrara no corredor. \n\n" +
                "Quando Melian tocou em uma peça de ouro a porta da câmara quase fechou, mas como já havia premeditado aquilo, conseguiu resolver sem problemas. Melian pegou o máximo que conseguiu carregar.\n\n" +
                "Saindo da câmara, escutou pedidos de socorro vindo de um dos corredores. Largou o tesouro no chão e foi de encontro das vozes que fracas pediam ajuda. Encontrou uma câmara com 4 sobreviventes dentro, os quais ela guiou para fora daquele lugar, sem antes esquecer de pegar o tesouro.\n\n" +
                "Ao retornar para a capital, foi gratificada e recebeu honras da província, porém a ganância a tomou, deixando para trás sua vida de benevolência e ajuda ao próximo, apenas aproveitando sua fama e fortuna.\n");

        final2Historia.setBounds(10,60,575,318);
        final2Historia.setWrapStyleWord(true);
        final2Historia.setLineWrap(true);
        final2Historia.setEditable(false);
        final2Historia.setBackground(jframe.getBackground());

        final2Btn = new JButton("Game over");
        final2Btn.setBounds(220,395,150,30);
        ActionListener clique12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(final2Titulo);
                jframe.remove(final2Historia);
                jframe.remove(final2Btn);
                Home();
            }
        };
        final2Btn.addActionListener(clique12);

        jframe.add(final2Titulo);
        jframe.add(final2Historia);
        jframe.add(final2Btn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Final1() {
        progresso = "null";

        final1Titulo = new JLabel("Dado(D20) = " + dadoDefineFinal +"  Final ruim!");
        final1Titulo.setFont(new Font("", 1, 15));
        final1Titulo.setBounds(200,10,340, 60);

        final1Historia = new JTextArea("Melian levou em consideração tudo o que passou para sobreviver e achou improvável que alguém estivesse vivo, principalmente considerando o que vivia ali. Então decidiu procurar pelo suposto tesouro, afinal o que impedia o sucesso dos exploradores já foi resolvido.\n\n" +
                "Ela andou por horas e atravessou dezenas de corredores. Aquele lugar parecia um labirinto.\n" +
                "Até que achou uma câmara com um brilho incomum. Ao entrar, ela se deparou um com um tesouro que seria impossível ser carregado sozinho. \n\n" +
                "Aquilo irradiava um brilho tão intenso que parecia dia... seus olhos ficaram hipnotizados pela riqueza e imediatamente surgiram pensamentos de ganância. Quando Melian tocou em uma peça de ouro a câmara se fechou.\n\n" +
                "Em desespero tentou empurrar o máximo que podia, mas a porta nem balançava. Tentou riscar no chão a mesma palavra que abriu o portão da tumba, mas de nada adiantou. Melian seguiu tentando abrir a passagem, mas sempre sem êxito. Infelizmente aquele era seu fim. Ninguém mais conseguiu entrar naquela tumba. \n\n" +
                "Após um mês de seu desaparecimento, amigos, familiares e colegas a homenagearam na capital e fizeram um enterro simbólico, já que seu corpo nunca voltou pra casa.");

        final1Historia.setBounds(10,60,575,310);
        final1Historia.setWrapStyleWord(true);
        final1Historia.setLineWrap(true);
        final1Historia.setEditable(false);
        final1Historia.setBackground(jframe.getBackground());

        final1Btn = new JButton("Game over");
        final1Btn.setBounds(220,385,150,30);
        ActionListener clique13 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(final1Titulo);
                jframe.remove(final1Historia);
                jframe.remove(final1Btn);
                Home();
            }
        };
        final1Btn.addActionListener(clique13);

        jframe.add(final1Titulo);
        jframe.add(final1Historia);
        jframe.add(final1Btn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void CharadaErrada(){
        erradoTitulo = new JLabel("Não foi dessa vez...");
        erradoTitulo.setFont(new Font("", 1, 20));
        erradoTitulo.setBounds(200,30,300, 60);

        erradoHistoria = new JTextArea("Não houve nenhuma mudança nem sinal que haveria alguma.\n" +
                " \n" +
                "      - Será que fiz algo errado?! Vou tentar mais uma vez.\n");
        erradoHistoria.setBounds(120,180,575,100);
        erradoHistoria.setWrapStyleWord(true);
        erradoHistoria.setLineWrap(true);
        erradoHistoria.setEditable(false);
        erradoHistoria.setBackground(jframe.getBackground());

        erradoTentarBtn = new JButton("Tentar Novamente");
        erradoTentarBtn.setBounds(220,350,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(erradoTitulo);
                jframe.remove(erradoHistoria);
                jframe.remove(erradoTentarBtn);
                Capitulo1();
            }
        };
        erradoTentarBtn.addActionListener(clique);

        jframe.add(erradoTitulo);
        jframe.add(erradoHistoria);
        jframe.add(erradoTentarBtn);

        jframe.getContentPane().add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void GameOverCharada(){
        progresso = "null";

        gameOverTitulo = new JLabel("Errou três vezes!");
        gameOverTitulo.setFont(new Font("", 1, 20));
        gameOverTitulo.setBounds(208,20,300, 60);

        gameOverHistoria = new JTextArea("Não houve nenhuma mudança nem sinal que haveria alguma.\n" +
                " \n" +
                "   - Não pode ser aqui! Como tantas pessoas desapareceram nesta tumba com um enigma deste nível. Vou procurar outra tumba pelas redondezas...\n" +
                " \n" +
                "Depois de cinco dias de intensas buscas, Melian não encontrou nenhuma pista, muito menos a tal tumba a qual ela procurava. Ela voltou para a capital e seguiu sua vida e atividades que a tornaram tão famosa. \n\n" +
                "Infelizmente, os boatos de seu fracasso à alcançaram na capital e marcaram negativamente sua carreira até o fim de sua vida.\n");
        gameOverHistoria.setBounds(10,120,575,180);
        gameOverHistoria.setWrapStyleWord(true);
        gameOverHistoria.setLineWrap(true);
        gameOverHistoria.setEditable(false);
        gameOverHistoria.setBackground(jframe.getBackground());

        gameOverBtn = new JButton("Game over");
        gameOverBtn.setBounds(220,350,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(gameOverTitulo);
                jframe.remove(gameOverHistoria);
                jframe.remove(gameOverBtn);
                Home();
            }
        };
        gameOverBtn.addActionListener(clique);

        jframe.add(gameOverTitulo);
        jframe.add(gameOverHistoria);
        jframe.add(gameOverBtn);

        jframe.getContentPane().add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void Creditos(){
        creditosTitulo = new JLabel("Créditos");
        creditosTitulo.setFont(new Font("", 1, 20));
        creditosTitulo.setBounds(255,20,300, 60);

        creditosTexto = new JTextArea("Desenvolvido por:              Fábio Leal Naibert\n                                                               e\n                                     Suélen Ivana Wagner Cardoso");
        creditosTexto.setBounds(105,120,575,100);
        creditosTexto.setWrapStyleWord(true);
        creditosTexto.setLineWrap(true);
        creditosTexto.setEditable(false);
        creditosTexto.setBackground(jframe.getBackground());

        creditosAgradecimentosTitulo = new JLabel("Agradecimentos Especiais");
        creditosAgradecimentosTitulo.setFont(new Font("", 1, 18));
        creditosAgradecimentosTitulo.setBounds(180,225,300, 60);

        creditosAgradecimentosTexto = new JTextArea("Professora Fernanda de Nardin Walker");
        creditosAgradecimentosTexto.setBounds(190,310,575,50);
        creditosAgradecimentosTexto.setWrapStyleWord(true);
        creditosAgradecimentosTexto.setLineWrap(true);
        creditosAgradecimentosTexto.setEditable(false);
        creditosAgradecimentosTexto.setBackground(jframe.getBackground());



        creditosVoltarBtn = new JButton("Voltar");
        creditosVoltarBtn.setBounds(220,400,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(creditosTitulo);
                jframe.remove(creditosTexto);
                jframe.remove(creditosAgradecimentosTexto);
                jframe.remove(creditosAgradecimentosTitulo);
                jframe.remove(creditosVoltarBtn);
                Home();
            }
        };
        creditosVoltarBtn.addActionListener(clique);

        jframe.add(creditosTitulo);
        jframe.add(creditosTexto);
        jframe.add(creditosAgradecimentosTitulo);
        jframe.add(creditosAgradecimentosTexto);
        jframe.add(creditosVoltarBtn);

        jframe.getContentPane().add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }

    public void NenhumSave(){
        nenhumSaveTitulo = new JLabel("Opss...");
        nenhumSaveTitulo.setFont(new Font("", 1, 20));
        nenhumSaveTitulo.setBounds(260,60,300, 60);

        nenhumSaveTexto = new JTextArea("Não há nenhum progresso salvo ou sua partida terminou.");
        nenhumSaveTexto.setBounds(140,190,575,100);
        nenhumSaveTexto.setWrapStyleWord(true);
        nenhumSaveTexto.setLineWrap(true);
        nenhumSaveTexto.setEditable(false);
        nenhumSaveTexto.setBackground(jframe.getBackground());

        nenhumSaveVoltarBtn = new JButton("Voltar");
        nenhumSaveVoltarBtn.setBounds(220,300,150,30);
        ActionListener clique = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(nenhumSaveTitulo);
                jframe.remove(nenhumSaveTexto);
                jframe.remove(nenhumSaveVoltarBtn);
                Home();
            }
        };
        nenhumSaveVoltarBtn.addActionListener(clique);

        jframe.add(nenhumSaveTitulo);
        jframe.add(nenhumSaveTexto);
        jframe.add(nenhumSaveVoltarBtn);

        jframe.getContentPane().add(jpanel,BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setSize(610,500);
    }
}