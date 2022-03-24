
//import java.util.ArrayList;
import java.io.File;
import java.util.Date;
import java.util.Scanner;

class Filme {
    private String nome;
    private String titulo;
    private Date data;
    private int duracao;
    private String genero;
    private String idioma;
    private String situacao;
    private float orcamento;
    private String[] palavraChave;

    public Filme(String nome, String titulo, Date data, int duracao, String genero, String idioma,
            String situacao, float orcamento, String[] palavraChave) {
        this.nome = nome;
        this.titulo = titulo;
        this.data = data;
        this.duracao = duracao;
        this.genero = genero;
        this.idioma = idioma;
        this.situacao = situacao;
        this.orcamento = orcamento;
        this.palavraChave = palavraChave;
    }

    public Filme clone() {
        Filme clone = new Filme();
        clone.setNome(this.getNome());
        clone.setTitulo(this.getTitulo());
        clone.setData(this.getData());
        clone.setDuracao(this.getDuracao());
        clone.setGenero(this.getGenero());
        clone.setIdioma(this.getIdioma());
        clone.setSituacao(this.getSituacao());
        clone.setOrcamento(this.getOrcamento());
        clone.setPalavraChave(this.getPalavraChave());
        return clone;
    }

    public Filme() {
    }

    // gets
    public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getSituacao() {
        return situacao;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public String[] getPalavraChave() {
        return palavraChave;
    }
    // sets

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setOrcamento(Float orcamento) {
        this.orcamento = orcamento;
    }

    public void setPalavraChave(String[] palavraChave) {
        this.palavraChave = palavraChave;
    }

    // LER - efetuar a leitura dos atributos de um registro (arquivos html)
    public static void lerArquivo(String arquivo) throws Exception {
        // File path is passed as parameter
        File file = new File("D:/TECNOPLAY/OneDrive/OneDrive - sga.pucminas.br/Área de Trabalho/faculdade/tp2/AEDS2/TP2/ex1/src/tmp/filmes/" + arquivo);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
        scanner.close();
    }

}

class Main {

    public static void main(String[] args) throws Exception {

        String file;
        Filme branca = new Filme();
        branca.setNome("Branca de neve");
        Filme velozes = new Filme();
        velozes.setNome("Velozes e furiosos 7 ");

        do {

            file = MyIO.readLine();
            Filme.lerArquivo(file);

        } while (!(file.equals("FIM")));

        // ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        // listaDeFilmes.add(branca);
        // listaDeFilmes.add(velozes);

        /*
         * for (int i = 0; i < listaDeFilmes.size(); i++) {
         * MyIO.println(listaDeFilmes.get(i).getNome());
         * 
         * }
         */
    }
}