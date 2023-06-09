import java.util.Scanner;

class Exercicio2 {
    /**
     * Faça um programa que leia 10 itens de compra de supermercado e
     * seus respectivos valores.
     * Salve esses nomes e valores em um arquivo itens_supermercado.txt .
     */
    public static void main(String[] args) {
        String notaFiscal = "";
        int contador = 0, ITENS_A_COMPRAR = 10;
        Scanner scanner = new Scanner(System.in);
        while (contador++ < ITENS_A_COMPRAR) {
            System.out.println("Qual o nome do produto:");
            notaFiscal += scanner.nextLine();
            System.out.println("Quanto este produto custou?");
            notaFiscal += " Valor gasto: " + scanner.nextLine() + "\n";
        }
        String nomeArquivo = "itens_supermercado.txt",
                diretorio = System.getProperty("user.home");

        Arquivo arquivo = new Arquivo(nomeArquivo, diretorio);
        try {
            arquivo.escrever(notaFiscal);
            System.out.println("O arquivo '" + nomeArquivo + "' foi salvo no diretório '" + diretorio + "'");
        } catch (Error e) {
            System.out.println(e);
        }
        scanner.close();
    }
}