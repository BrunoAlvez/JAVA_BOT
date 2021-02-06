package models;

/** Classe Bidding (Licitação/Pregão) */
public class Bidding {

    /** Atributos da Classe */
    private String id;

    private String description;

    private String date;

    private String type;

    public Bidding() {}

    public Bidding(String id, String description, String date, String type) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.type        = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /** Método responsável pela organização visual do retorno do Método Main da Classe Main  */
    public String toString() {
        return "Bidding{\nid = '" + id + "', description = '" + description + "', date = '" + date + "', type='" + type + "'\n}";
    }

}