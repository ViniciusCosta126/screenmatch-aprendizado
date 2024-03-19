package br.com.vinicius.screenmatch.principal;

import br.com.vinicius.screenmatch.calculos.FiltroRecomendacao;
import br.com.vinicius.screenmatch.modelos.Episodio;
import br.com.vinicius.screenmatch.modelos.Filme;
import br.com.vinicius.screenmatch.modelos.Serie;
import br.com.vinicius.screenmatch.calculos.CalculadoraDeTempo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970,180,true);

        Filme outroFilme = new Filme("Avatar",2023,180,false);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8.5);
        meuFilme.avalia(9.1);
        meuFilme.avalia(5);
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        outroFilme.exibeFichaTecnica();
        outroFilme.avalia(8.5);
        outroFilme.avalia(9.1);
        outroFilme.avalia(10);
        System.out.println(outroFilme.getTotalDeAvaliacoes());
        System.out.println(outroFilme.pegaMedia());

        Serie lost = new Serie("Lost",2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar lost:" + lost.getDuracaoEmMinutos());


        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.incluiTitulo(meuFilme);
        calculadoraDeTempo.incluiTitulo(lost);
        System.out.println(calculadoraDeTempo.getTempoTotal());

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalDeVisualicoes(300);
        filtroRecomendacao.filtra(episodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(meuFilme);

        System.out.println("Tamanho da lista:" + listaDeFilmes.size());
        System.out.println("Primeiro filme:" + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}