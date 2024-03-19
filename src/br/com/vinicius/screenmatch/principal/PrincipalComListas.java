package br.com.vinicius.screenmatch.principal;

import br.com.vinicius.screenmatch.modelos.Filme;
import br.com.vinicius.screenmatch.modelos.Serie;
import br.com.vinicius.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme poderoChefao = new Filme("O poderoso chefão", 1970, 180, true);
        poderoChefao.avalia(9);
        Filme avatar = new Filme("Avatar", 2023, 180, false);
        avatar.avalia(6);
        Serie lost = new Serie("Lost", 2000);


        List<Titulo> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(poderoChefao);
        listaDeFilmes.add(avatar);
        listaDeFilmes.add(lost);

        for (Titulo item : listaDeFilmes) {
            System.out.println(item.getNome());

            if (item instanceof Filme filme) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        Collections.sort(listaDeFilmes);
        listaDeFilmes.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaDeFilmes);
    }
}
