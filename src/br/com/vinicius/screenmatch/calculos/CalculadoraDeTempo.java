package br.com.vinicius.screenmatch.calculos;

import br.com.vinicius.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;


    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluiTitulo(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
