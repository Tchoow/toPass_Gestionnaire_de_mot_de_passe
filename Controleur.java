public class Controleur
{
    private Metier metier;
    private FramePass ihm;
    private FrameAddMdp ihm2;

    public Controleur()
    {
        this.metier = new Metier();
        this.ihm    = new FramePass ( this );
    }



    // Accesseurs
    public int getNbPassword() { return this.metier.getNbPassword(); }
    public int getNum() { return this.metier.getNum() ;}
    public String getName()    { return this.metier.getName();       }
    public String getLink()    { return this.metier.getLink();       }
    public String getId  ()    { return this.metier.getId();         }
    public String getMdp ()    { return this.metier.getMdp();        }
    public String getNote()    { return this.metier.getNote();       }
    public MotDePasse getPasswordIndice(int indice) { return this.metier.getPasswordIndice(indice); }


    public String encode(String str) { return this.metier.encode( str ); }
    public String decode(String str) { return this.metier.decode( str ); }

    public void actualisation(int index)
    {
        this.metier.setCurrentAccount(index);
        this.ihm.maj();
    }

    public void newMdp()
    {
        this.ihm2 = new FrameAddMdp( this );

    }


    public void actualisationDeux()
    {
        this.ihm.dispose();

        this.metier = new Metier();
        this.ihm    = new FramePass (this);
        
    }

    public void ajouterCompte(String sRet)
    {
        this.metier.ajouterCompte(sRet);
        this.ihm.maj();
    }
    
    public void removeAccount()
    {
        this.metier.deleteCompte(this.metier.getNum());
        this.actualisationDeux();
    
    }
    public String generate() { return this.metier.generate() ;}

    public static void main(String[] args)
    {
        new Controleur();
    }
}