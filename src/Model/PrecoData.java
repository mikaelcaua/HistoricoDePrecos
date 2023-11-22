package Model;

public class PrecoData {
    private Float preco;
    private String data;
    private Site site;

    public PrecoData(Float preco, String data) {
        this.preco = preco;
        this.data = data;
    }

    public Float getPreco() {
        return preco;
    }

    public String getData() {
        return data;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
