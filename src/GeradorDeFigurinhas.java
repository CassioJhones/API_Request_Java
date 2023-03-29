import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    void cria(InputStream inputstream, String nomeArquivo) throws IOException{
        //--LEITURA DA IMAGEM

        // InputStream inputstream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        // InputStream inputstream = new FileInputStream(new File("entrada/rings.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputstream);


        //-- CRIAR NOVA IMAGEM COM TRANSPARENCIA E COM NOVO TAMANHO (em memoria)
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        //--COPIAR A AMAGE ORIGINAL PARA NOVA IMAGEM (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        //--FONTE E COR
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);


        //--ESCREVER FRASE NA NOVA IMAGEM
        graphics.drawString("Senhor dos Anéis", 50, novaAltura-80);


        //--ESCREVER A NOVA IMAGEM EM ARQUIVO
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
    
}
