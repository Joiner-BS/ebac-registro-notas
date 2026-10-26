// Representa um aluno, suas notas e o cálculo de sua média.
public class Aluno {

    // Atributos privados: o acesso externo ocorre pelos métodos da classe.
    private String nome;
    private double[] notas;

    // Inicializa o aluno com o nome e o vetor de notas recebidos.
    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    // Retorna o nome do aluno.
    public String getNome() {
        return nome;
    }

    // Permite alterar o nome do aluno.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o vetor de notas do aluno.
    public double[] getNotas() {
        return notas;
    }

    // Permite substituir o vetor de notas do aluno.
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    // Calcula a média aritmética das notas do aluno.
    public double calcularMedia() {
        double soma = 0;

        // Percorre o vetor e acumula o valor de cada nota.
        for (double nota : notas) {
            soma += nota;
        }

        // Divide a soma pela quantidade de notas.
        return soma / notas.length;
    }
}