package br.com.vinicius.screenmatch.modelos;

import br.com.vinicius.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb novoTituloOmdb) {
        this.nome = novoTituloOmdb.title();
        if(novoTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Nao consegui converter o ano por ter mais de 04 caracteres");
        } else{
            this.anoDeLancamento = Integer.valueOf(novoTituloOmdb.year());
        }

        this.duracaoEmMinutos = Integer.valueOf(novoTituloOmdb.runtime().substring(0,2));
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme => " + nome);
        System.out.println("Ano de lançamento => " + anoDeLancamento);
        System.out.println("Duração em minutos => " + duracaoEmMinutos);
        System.out.println("Incluido no plano => " + incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return  this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Titulo: " + nome + ", ano de lançamento: " + anoDeLancamento + ", Duração: " + duracaoEmMinutos + ")";
    }
}
