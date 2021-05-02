
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList; 
import java.awt.datatransfer.*;

public class Metier
{
    public int num;
    public String name;
    public String link;
    public String id;
    public String mdp;
    public String note;




    private ArrayList<MotDePasse>  ensMdp;

    public Metier()
    {
        // Création de l'arayList
        this.ensMdp = new ArrayList<MotDePasse>();

        try
        {
          // Le fichier d'entrée
          FileInputStream file = new FileInputStream("mdp.txt");   
          Scanner scanner = new Scanner(file);  
          
          //renvoie true s'il y a une autre ligne à lire
          while(scanner.hasNextLine())
          {
            String[] parts = scanner.nextLine().split(":");
            this.ensMdp.add(new MotDePasse(parts[0], parts[1], parts[2], parts[3], parts[4]));
          }
          scanner.close();    
        }
        catch(IOException e)
        {
          e.printStackTrace();
        }

    }



    public void setCurrentAccount(int index)
    {        
        this.num  = this.ensMdp.get(index).getNum ();
        this.name = this.ensMdp.get(index).getNom ();
        this.link = this.ensMdp.get(index).getLink();
        this.id   = this.ensMdp.get(index).getId  ();
        this.mdp  = this.ensMdp.get(index).getMdp ();
        this.note = this.ensMdp.get(index).getNote();
        
    }


    public MotDePasse getPasswordIndice(int indice) { return this.ensMdp.get(indice) ; }
    public int getNbPassword() { return this.ensMdp.size(); }
    public int getNum()        { return this.num;           }
    public String getName()    { return this.name;          }
    public String getLink()    { return this.link;          }
    public String getId  ()    { return this.id;            }
    public String getMdp ()    { return this.mdp;           }
    public String getNote()    { return this.note;          }


    // Write new password
    public void ajouterCompte(String sRet)
    {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mdp.txt", true)));
            out.println(sRet);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void deleteCompte(int numCompte)
    {
      System.out.println("A FAIRE");
    }
}
