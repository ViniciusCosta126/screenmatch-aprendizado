package br.com.vinicius.screenmatch.principal;

import br.com.vinicius.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.vinicius.screenmatch.modelos.Titulo;
import br.com.vinicius.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        var busca = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        List<Titulo> titulos = new ArrayList<>();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o filme que deseja buscar: ");
            busca = sc.nextLine();
            
            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            try {
                String endereco = "https://www.omdbapi.com/?apikey=230c22ac&t=" + busca.replace(" ", "+");
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                TituloOmdb novoTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                Titulo novoTitulo = new Titulo(novoTituloOmdb);
                System.out.println(novoTitulo);

                titulos.add(novoTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        System.out.println(titulos);
        escrita.close();
    }
}
