package br.com.vinicius.screenmatch.modelos;

import br.com.vinicius.screenmatch.calculos.Classificacao;

public class Filme extends Titulo implements Classificacao {
    private String diretor;

    public Filme(String nomeDoFilme, int anoDeLancamento, int duracao, boolean incluidoNoPlano) {
        super(nomeDoFilme, anoDeLancamento);
        this.setDuracaoEmMinutos(duracao);
        this.setIncluidoNoPlano(incluidoNoPlano);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
