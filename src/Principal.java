import br.com.vinicius.screenmatch.calculos.FiltroRecomendacao;
import br.com.vinicius.screenmatch.modelos.Episodio;
import br.com.vinicius.screenmatch.modelos.Filme;
import br.com.vinicius.screenmatch.modelos.Serie;
import br.com.vinicius.screenmatch.calculos.CalculadoraDeTempo;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8.5);
        meuFilme.avalia(9.1);
        meuFilme.avalia(5);
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
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
    }
}