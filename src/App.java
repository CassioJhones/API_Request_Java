import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // ---CONEXAO HTTP E BUSCA DE FILMES---
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


        // ---EXTRAIR SOMENTE DADOS NECESSARIOS
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        

        // ---EXIBIR E MANIPULAR
        var geradora = new GeradorDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputstream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            
            geradora.cria(inputstream, nomeArquivo);
            System.out.println(titulo);
            System.out.println();
        }
    }
}
