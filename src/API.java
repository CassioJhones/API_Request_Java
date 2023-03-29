public enum API {

    IMDB_TOP_MOVIES("https://imdb-api.com/en/API/Top250Movies/k_x3pev8lm", new ExtratorDeConteudoDoIMDB()),
    IMDB_TOP_SERIES("https://imdb-api.com/en/API/Top250TVs/k_x3pev8lm", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=RprIIWehMaCH9nIbvVGQtv9h3EJFHF5fgTNe30cl", new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;
    
    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}