import java.util.Scanner;

// Controla o cadastro dos alunos e a apresentação dos resultados.
public class RegistroNotas {

    // Ponto de entrada do programa.
    public static void main(String[] args) {

        // Prepara a leitura dos dados pelo teclado.
        Scanner scanner = new Scanner(System.in);

        // Recebe a quantidade de alunos que serão cadastrados.
        System.out.println("Quantos alunos deseja cadastrar?");
        int quantidadeAlunos = scanner.nextInt();

        // Impede uma quantidade de alunos menor que 1.
        while (quantidadeAlunos < 1) {
            System.out.println("Informe uma quantidade de alunos maior que zero:");
            quantidadeAlunos = scanner.nextInt();
        }

        // Cria o vetor que armazenará os objetos Aluno.
        Aluno[] alunos = new Aluno[quantidadeAlunos];

        // Consome a quebra de linha deixada pelo nextInt().
        scanner.nextLine();

        // Exibe a quantidade de posições disponíveis no vetor.
        System.out.println("Quantidade de alunos a cadastrar: " + alunos.length);

        // Cadastra cada aluno na posição correspondente do vetor.
        for (int i = 0; i < alunos.length; i++) {

            System.out.println("\nCadastro do aluno " + (i + 1) + ":");

            // Recebe o nome completo do aluno.
            System.out.println("Digite o nome do aluno:");
            String nome = scanner.nextLine();

            // Recebe a quantidade de notas deste aluno.
            System.out.println("Quantas notas deseja informar?");
            int quantidadeNotas = scanner.nextInt();

            // Garante pelo menos uma nota para permitir o cálculo da média.
            while (quantidadeNotas < 1) {
                System.out.println("Informe uma quantidade de notas maior que zero:");
                quantidadeNotas = scanner.nextInt();
            }

            // Cria um vetor de notas exclusivo para este aluno.
            double[] notas = new double[quantidadeNotas];

            // Preenche cada posição do vetor com uma nota válida.
            for (int j = 0; j < notas.length; j++) {

                System.out.println("Digite a " + (j + 1) + "ª nota:");
                double nota = scanner.nextDouble();

                // Repete a leitura enquanto a nota estiver fora de 0 a 10.
                while (!Double.isFinite(nota) || nota < 0 || nota > 10) {
                    System.out.println("Nota inválida! Digite uma nota entre 0 e 10:");
                    nota = scanner.nextDouble();
                }

                // Armazena a nota somente depois da validação.
                notas[j] = nota;
            }

            // Consome a quebra de linha antes da leitura do próximo nome.
            scanner.nextLine();

            // Cria o objeto pelo construtor e o guarda no vetor de alunos.
            alunos[i] = new Aluno(nome, notas);

            // Confirma o cadastro utilizando o getter do nome.
            System.out.println("Aluno cadastrado: " + alunos[i].getNome());
        }

        // Inicia a apresentação dos resultados após todos os cadastros.
        System.out.println("\n===== RESUMO DOS ALUNOS =====");

        // Percorre os objetos Aluno armazenados no vetor.
        for (Aluno aluno : alunos) {

            // Consulta e exibe o nome usando o getter.
            System.out.println("\nNome: " + aluno.getNome());

            // Consulta o vetor pelo getter e exibe cada nota.
            System.out.print("Notas: ");

            for (double nota : aluno.getNotas()) {
                System.out.print(nota + " ");
            }

            // Encerra a linha das notas.
            System.out.println();

            // Calcula e exibe a média com duas casas decimais.
            System.out.printf("Média: %.2f%n", aluno.calcularMedia());
        }

        // Fecha o leitor após concluir todas as entradas do programa.
        scanner.close();
    }
}