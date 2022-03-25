
import java.util.ArrayList;
import java.io.File;
import java.text.SimpleDateFormat;
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

    public void lerArquivo(String arquivo) throws Exception {
        // File path passado como parametro
        File file = new File(
                "D:/TECNOPLAY/OneDrive/OneDrive - sga.pucminas.br/Área de Trabalho/faculdade/tp2/AEDS2/TP2/ex1/src/tmp/filmes/"
                        + arquivo);
        Scanner scanner = new Scanner(file, "ISO-8859-1");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        /*
         * ------------NOME:------------
         * <h2 class="6"> classe alguma coisa, n importa
         * <a href="/movie/414906-the-batman?language=pt-BR">Batman</a>
         * 
         * ------------TITULO:------------
         * <meta property="og:title" content="007: Sem Tempo para Morrer">
         * 
         * ------------DATA:------------
         * <span class="release">
         * 03/03/2022 (BR)
         * </span>
         * 
         * ------------DURACAO:-----------------
         * <span class="runtime">
         * 2h 43m
         * </span
         * 
         * ------------GENERO:------------
         * <span class="genres">
         * <a href="/genre/12-aventura/movie">Aventura</a>,&nbsp;<a
         * href="/genre/28-acao/movie">Ação</a>,&nbsp;<a
         * href="/genre/53-thriller/movie">Thriller</a>
         * </span>
         * 
         * ------------IDIOMA:------------
         * <p><strong><bdi>Idioma original</bdi></strong> Inglês</p>
         * 
         * ------------SITUACAO:------------
         * <strong><bdi>Situação</bdi></strong> Lançado
         * 
         * ------------ORCAMENTO:------------
         * <p><strong><bdi>Orçamento</bdi></strong> $250,000,000.00</p>
         * 
         * ------------PALAVRAS CHAVE:------------
         * <h4><bdi>Palavras-chave</bdi></h4> (E UMA LISTA)
         * 
         */
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            // DATA DE LANCAMENTO E NOME
            if (line.contains("h2 class")) {
                // PRIMEIRA LINHA: NOME
                line = scanner.nextLine();
                this.setNome(removeTag(line).trim());
            }

            else if (line.contains("span class=\"release\"")) {
                line = scanner.nextLine();
                line = line.trim();
                this.setData(sdf.parse(line));

            } else if (line.contains("span class=\"runtime\"")) {
                scanner.nextLine();
                line = scanner.nextLine();
                line.trim();
                String numeros = "";
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) >= 48) && (line.charAt(i) <= 57)) {
                        numeros = numeros + line.charAt(i);
                    }
                }
                int duracao = (((int) numeros.charAt(0) - 48) * 60 + (((int) numeros.charAt(1) - 48) * 10)
                        + ((int) numeros.charAt(2) - 48));
                setDuracao(duracao);
            }
            // GENERO
            else if (line.contains("genres")) {
                scanner.nextLine();
                line = removeTag(scanner.nextLine().trim());
                String tmp = "";
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ',') {
                        tmp = tmp + line.charAt(i);
                    } else {
                        while (line.charAt(i) != ';') {
                            i++;
                        }
                        tmp = tmp + ", ";
                    }
                }
                setGenero(tmp);

            }
            // ------------IDIOMA:------------
            // <p><strong><bdi>Idioma original</bdi></strong> Inglês</p>
            else if (line.contains("Idioma")) {
                line = removeTag(line.trim());
                line = line.replace("Idioma original ", "");
                this.setIdioma(line);
            }
            // ------------SITUACAO:------------
            // <strong><bdi>Situação</bdi></strong> Lançado
            else if (line.contains("<strong><bdi>Situa")) {
                line = removeTag(line.trim());
                line = line.replace("SituaÃ§Ã£o", "");
                this.setSituacao(situacao);
                ;
            }
            // ------------PALAVRAS CHAVE:------------
            // <h4><bdi>Palavras-chave</bdi></h4> (E UMA LISTA)
            else if (line.contains("<h4><bdi>Palavras")) {
                String palavras = "";
                while (!(line.contains("</ul>"))) {

                    line = scanner.nextLine();
                    line = scanner.nextLine();

                    if (line.length() == 0) {
                        line = scanner.nextLine();
                        line = scanner.nextLine();
                    }

                    palavras = palavras + line;

                }

                palavras = removeTag(palavras.trim());
                palavras = palavras.replaceFirst("        ", "");
                String[] parts = palavras.split("        ");
                for (int i = 0; i < parts.length; i++) {
                    System.out.println(parts[i]);
                }
                setPalavraChave(parts);

                String[] retorno = getPalavraChave();
                for (int i = 0; i < retorno.length; i++) {
                    System.out.println(retorno[i] +   "1");
                }



            }

        }
        scanner.close();
    }

    // LER - efetuar a leitura dos atributos de um registro (arquivos html)

    // REMOVE TAG
    public static String removeTag(String linha) {
        String linhaMod = "";

        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == '<') {
                i++;
                while (linha.charAt(i) != '>') {
                    i++;
                }
            } else {
                linhaMod = linhaMod + linha.charAt(i);
            }
        }
        return linhaMod;
    }

}

class Main {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        String file = MyIO.readLine();
        while (!(isFim(file))) {
            Filme tmp = new Filme();
            tmp.lerArquivo(file);

            // ler stdin - novo input

            listaDeFilmes.add(tmp);
            file = MyIO.readLine();
        
        }

        for (int i = 0; i < listaDeFilmes.size(); i++) {
            MyIO.print(listaDeFilmes.get(i).getNome() + ',' + listaDeFilmes.get(i).getTitulo() + ','
                    + sdf.format(listaDeFilmes.get(i).getData())
                    + ',' + listaDeFilmes.get(i).getDuracao() + ',' + listaDeFilmes.get(i).getGenero() + ','
                    + listaDeFilmes.get(i).getIdioma()
                    + ',' + listaDeFilmes.get(i).getSituacao() + ',' + listaDeFilmes.get(i).getOrcamento());
            System.out.println(listaDeFilmes.get(i).getPalavraChave());

        }

    }

}