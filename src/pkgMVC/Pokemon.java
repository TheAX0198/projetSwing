package pkgMVC;

public class Pokemon implements Comparable<Pokemon> {

    private String nom;
    private String type;
    private int atk;
    private int pv;
    private String desc;

    public Pokemon() {
        this.nom = "Pokemon inconnu";
        this.type = "Normal";
        this.atk = 0;
        this.pv = 0;
        this.desc = "Un pokemon mystère.";
    }

    public Pokemon(String nom, String type, int atk, int pv, String desc) {
        this.nom = nom;
        this.type = type;
        this.atk = atk;
        this.pv = pv;
        this.desc = desc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int compareTo(Pokemon p) {
        return p.getNom().compareTo(getNom());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + atk;
        result = prime * result + pv;
        result = prime * result + ((desc == null) ? 0 : desc.hashCode());
        return result;
    }

    public boolean equals(Pokemon p) {
        return getNom().equalsIgnoreCase(p.getNom()) &&
               getType().equalsIgnoreCase(p.getType()) &&
               getAtk() == p.getAtk() &&
               getPv() == p.getPv() &&
               getDesc().equals(p.getDesc());
    }

    @Override
    public String toString() {
        return "Pokemon [nom=" + nom + ", type=" + type + ", atk=" + atk + ", pv=" + pv + "]";
    }

}
