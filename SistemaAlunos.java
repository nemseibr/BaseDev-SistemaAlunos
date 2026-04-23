import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    int idade;
    double nota1;
    double nota2;

    Aluno(String nome, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    double calcularMedia() {
        return (nota1 + nota2) / 2;
    }
}

public class SistemaAlunos {

    static ArrayList<Aluno> alunos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    buscarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    calcularMedias();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    static void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Buscar aluno");
        System.out.println("4 - Remover aluno");
        System.out.println("5 - Calcular médias");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Nota 1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Nota 2: ");
        double nota2 = scanner.nextDouble();
        scanner.nextLine();

        alunos.add(new Aluno(nome, idade, nota1, nota2));

        System.out.println("Aluno cadastrado com sucesso!");
    }

    static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            System.out.println(i + " - " + a.nome + " | Idade: " + a.idade);
        }
    }

    static void buscarAluno() {
        System.out.print("Digite o nome: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrado = false;

        for (Aluno a : alunos) {
            if (a.nome.equalsIgnoreCase(nomeBusca)) {
                System.out.println("Encontrado: " + a.nome + " | Média: " + a.calcularMedia());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    static void removerAluno() {
        listarAlunos();

        System.out.print("Digite o índice para remover: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < alunos.size()) {
            alunos.remove(index);
            System.out.println("Aluno removido!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    static void calcularMedias() {
        for (Aluno a : alunos) {
            double media = a.calcularMedia();

            if (media >= 7) {
                System.out.println(a.nome + " - Aprovado (" + media + ")");
            } else {
                System.out.println(a.nome + " - Reprovado (" + media + ")");
            }
        }
    }
}