class Aluno {
    double nota;
    String nome;

    public Aluno(double nota) {
        this.setNota(nota);
    }

    public Aluno(String nome) {
        this.setNome(nome);
    }

    public Aluno(String nome, double nota) {
        this.setNome(nome);
        this.setNota(nota);
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double notaAluno) {
        if (notaAluno < 0)
            throw new Error("A nota do aluno não pode ser menor do que 0");
        this.nota = notaAluno;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeAluno) {
        if (nomeAluno.equals("") || nomeAluno.length() < 3)
            throw new Error("O nome do aluno deve possuir ao menos 3 caracteres");
        this.nome = nomeAluno;
    }
}