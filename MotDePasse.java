public class MotDePasse
{
    // Attributs
    private int    num;
    private String name;
    private String link;
    private String id;
    private String mdp;
    private String note;


    public MotDePasse(int num, String name, String link, String id, String mdp, String note)
    {
        this.num     = num;
        this.name    = name;
        this.link    = link;
        this.id      = id;
        this.mdp     = mdp;
        this.note    = note;
    }

    // Accesseurs
    public String getNom() { return this.name ;}
    public int    getNum() { return this.num;  }
    public String getLink(){ return this.link; }
    public String getId()  { return this.id;   }
    public String getMdp() { return this.mdp;  }
    public String getNote(){ return this.note; }

    

}
