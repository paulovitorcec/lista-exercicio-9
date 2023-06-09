import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

class Arquivo {
    String nome;
    String caminho;
    FileWriter arquivo;
    boolean aberto = false;
    public Arquivo(String nomeArquivo, String localOndeSeraSalvo) {
        this.nome = nomeArquivo;
        this.caminho = localOndeSeraSalvo;
        try {
            if(this.caminhoNaoExiste()) this.criarCaminho();
            this.criarArquivo();
        }
        catch(Exception error) {
            System.out.println("Não foi possível criar o arquivo" + error);
            error.printStackTrace();
        }
    }
    private void criarArquivo() throws IOException {
        this.arquivo = new FileWriter(this.caminho + File.separator + this.nome);
        this.aberto = true;
    }
    private void criarCaminho() {
        File diretorio = new File(this.caminho);
        boolean diretorioCriado = diretorio.mkdir();
        if(diretorioCriado) System.out.printf("O diretório '%s' não existe e foi criado. \n", this.caminho);
        else System.out.printf("O diretório '%s' não existe e não pode ser criado, verifique se você possui permissão para criar pastas. \n", this.caminho);
    }
    private boolean caminhoNaoExiste() {
        java.nio.file.Path path = java.nio.file.Paths.get(this.caminho);
        return Files.notExists(path);
    }
    public void escrever(String dados) {
        try (PrintWriter escritor = new PrintWriter(this.caminho + File.separator + this.nome)) {
            escritor.write(dados);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void fecharArquivo() {
        try {
            this.arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.aberto = false;
    }
}