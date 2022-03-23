import java.util.ArrayList;
import java.util.Date;

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

}

class Main {
    public static void main(String[] args) {

        Filme branca = new Filme();
        branca.setNome("Branca de neve");
        Filme velozes = new Filme();
        velozes.setNome("Velozes e furiosos 7 ");        
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(branca);
        listaDeFilmes.add(velozes);

        for (int i = 0; i < listaDeFilmes.size(); i++) {
            MyIO.println(listaDeFilmes.get(i).getNome());
            
        }

    }
}