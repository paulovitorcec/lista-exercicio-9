import java.util.Scanner;

public class Exercicio1 {
  /*
   * Faça um programa que leia o nome de 5 alunos(as) de uma turma
   * universitária e que também leia a respectiva nota final de cada aluno(a).
   * Salve esses nomes e suas notas em um arquivo
   * alunos_universidade.txt
   */
  public static void main(String[] args) {
    final int NUMERO_ALUNOS_A_RECEBER = 5;
    Scanner scanner = new Scanner(System.in);
    Aluno[] listaAlunos = new Aluno[NUMERO_ALUNOS_A_RECEBER];

    System.out.println("Cadastramento de notas de alunos 2023");
    System.out.printf("Neste programa você irá digitar o nome e a nota de %d %s", NUMERO_ALUNOS_A_RECEBER,
        (NUMERO_ALUNOS_A_RECEBER == 1 ? "aluno" : "alunos"));
    for (int contador = 0; contador < NUMERO_ALUNOS_A_RECEBER; contador++) {
      double nota;
      String nome;

      System.out.printf("\nDigite o nome do aluno: ");
      nome = scanner.nextLine();
      System.out.printf("\nQual foi a nota que o aluno " + nome + " obteve? Se foi um valor com decimal, informe o lado fracionado com um ponto ('.') ao invés da vírgula(',') \n");
      try {
        nota = Double.parseDouble(scanner.nextLine());
        Aluno novoAluno = new Aluno(nome, nota);
        listaAlunos[contador] = novoAluno;
      } 
      catch (NumberFormatException e) {
        System.out.println("O valor informado pelo usuário não é um numeral, abortando programa");
        return;
      }
      catch (Error e) {
        System.out.println("Aconteceu algum erro inesperado");
        System.out.println(e);
        return;
      }
    }
    String nomeArquivo = "alunos_universisdade.txt", 
      diretorio = System.getProperty("user.home");

    Arquivo arquivo = new Arquivo(nomeArquivo, diretorio);
    try {
      arquivo.escrever(preparaRelatorio(listaAlunos));
      System.out.println("O arquivo '" + nomeArquivo + "' foi salvo no diretório '" + diretorio + "'");
    } catch(Error e) {
      System.out.println("Aconteceu algum erro inesperado");
      System.out.println(e);
    }
    finally {
      arquivo.fecharArquivo();
      scanner.close();
    }
  }
  public static String preparaRelatorio(Aluno[] alunos) {
    String relatorio = "";
    for(Aluno aluno : alunos) {
      relatorio += aluno.getNome() + ": " + aluno.getNota() + " pontos \n";
    }
    return relatorio;
  }
}
