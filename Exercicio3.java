import java.util.Random;
import java.util.Scanner;

class Exercicio3 {
    /*
     * Faça um programa que pergunte o nome, a idade e o CPF de uma
     * pessoa.
     * Após isso, o programa mostrará um menu com 03 destinos:
     * - São Paulo
     * - Nova York
     * - Berlim
     * A passagem para São Paulo é $ 250, para Nova York é $ 2400 e para
     * Berlim é $ 3800.
     * O usuário escolherá o destino que quer conhecer e o seu programa
     * deverá imprimir um recibo com os dados pessoais, o destino escolhido,
     * o valor a ser pago e o número da poltrona gerado de forma aleatória
     * num intervalo entre 01 e 20.
     * Gere um arquivo recibo_viagem.txt com todos esses dados.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SAO_PAULO = 0; // Vou colocar assim, já que os valores se referem a índices de um array (valoresPassagem)
        final int NOVA_YORK = 1; // Vou colocar assim, já que os valores se referem a índices de um array (valoresPassagem)
        final int BERLIM = 2; // Vou colocar assim, já que os valores se referem a índices de um array (valoresPassagem)
        int[] valoresPassagem = new int[3];
        String[] nomeDestinos = {"São Paulo", "Nova York", "Berlim"};
        // Isso só deve dar certo porque eu coloquei valores que são também posições válidas em um array (0, 1, 2). Provavelmente as valores (1, 5, 7) não iriam funcionar do mesmo jeito
        valoresPassagem[SAO_PAULO] = 250; // Como SAO_PAULO é na verdade o índice 0, esse valor está sendo colocado na 1ª posição do array
        valoresPassagem[NOVA_YORK] = 2400; // Do mesmo jeito que a linha anterior, este valor está sendo colocado na 2ª posição do array
        valoresPassagem[BERLIM] = 3800; // Acho que você pegou a ideia, né? Se não, dá uma Goolgada aí
        try {
            System.out.println("Sistema de bilhereria pravoar.com");
            System.out.println("Para começarmos, informe o seu nome completo: ");
            String nome = scanner.nextLine();
            System.out.println("Qual é a sua idade?");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Qual o seu CPF?");
            String cpf = scanner.nextLine();
            System.out.println("Para onde você quer viajar? (Informe o número apenas)");
            System.out.println(SAO_PAULO + " - São Paulo");
            System.out.println(NOVA_YORK + " - Nova York");
            System.out.println(BERLIM + " - Berlim");
            int destino = Integer.parseInt(scanner.nextLine());
            int valorDaPasssagem = 0;
            // Este foi o motivo de eu criar essas constantes, assim fica + claro para você
            // a lógica que eu usei
            if (destino == SAO_PAULO)
                valorDaPasssagem = valoresPassagem[SAO_PAULO];
            else if (destino == NOVA_YORK)
                valorDaPasssagem = valoresPassagem[NOVA_YORK];
            else if (destino == BERLIM)
                valorDaPasssagem = valoresPassagem[BERLIM];
            else {
                throw new Error("Número informado não é um destino de viagem válido");
            }
            Random rand = new Random();
            String nomeArquivo = "bilhete-passagem.txt";
            String diretorio = System.getProperty("user.home");
            int numeroPoltrona = rand.nextInt(50) + 1; // colocar o 50 significa ir de um range de [0-49], por isso o +1 no final;
            Arquivo arquivo = new Arquivo(nomeArquivo, diretorio);
            String dadosAEscrever = "Nome cliente: " + nome + "\n"
                                    + "Idade: " + idade + "\n"
                                    + "CPF: " + cpf + "\n"
                                    + "Destino escolhido: " + nomeDestinos[destino] + "\n"
                                    + "Valor da passagem: " + valorDaPasssagem + "\n"
                                    + "Número da poltrona selecionada: " + numeroPoltrona + "\n";
            arquivo.escrever(dadosAEscrever);
            System.out.println("O arquivo '" + nomeArquivo + "' foi criado no diretório '" + diretorio + "'");
            arquivo.fecharArquivo();

        } catch (NumberFormatException error) {
            System.out.println("Houve algum erro ao digitar o número, por favor tente novamente");
            error.printStackTrace();
        } catch (Exception error) {
            System.out.println(error);
            error.printStackTrace();
        } finally {
            scanner.close();
        }

    }
}