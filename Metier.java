
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList; 
import java.awt.datatransfer.*;

public class Metier
{
    private static int nbMotDePasse = 0;
    private int num;
    private String name;
    private String link;
    private String id;
    private String mdp;
    private String note;




    private ArrayList<MotDePasse>  ensMdp;

    public Metier()
    {
        // Création de l'arayList
        this.ensMdp = new ArrayList<MotDePasse>();
        this.num = 0;
        Metier.nbMotDePasse = 0;

        try
        {
          // Le fichier d'entrée
          File mdp = new File("mdp.txt");
          if ( !mdp.exists() )
          {
            PrintWriter pw = new PrintWriter(new FileWriter(mdp));
            pw.println("\n");
            pw.close();


          }


          FileInputStream file = new FileInputStream("mdp.txt");   
          Scanner scanner = new Scanner(file);  
          
          //renvoie true s'il y a une autre ligne à lire
          while(scanner.hasNextLine())
          {
            String[] parts = scanner.nextLine().split(";");
            try {
              this.ensMdp.add(new MotDePasse( ++ Metier.nbMotDePasse,this.decode(parts[0]), this.decode(parts[1]), this.decode(parts[2]), this.decode(parts[3]), this.decode(parts[4])));
            }
            catch(Exception e) {
              System.out.println("Aucun mot de passe chargé");
            }
          }
          scanner.close();
        }
        catch(IOException e)
        {
          System.out.println(e);
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


    public MotDePasse getPasswordIndice(int indice) { return this.ensMdp.get(indice);  }
    public void resetNum()   { this.num = 0; }
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
            System.out.println("Erreur de lecture");
        }
    }

    public void deleteCompte(int numCompte)
    {
      System.out.println("Supression du compte numéro : " + numCompte);
      try {

        File inFile = new File("mdp.txt");
  
        //Construct the new file that will later be renamed to the original filename.
        File tempFile = new File(inFile.getAbsolutePath() + "t.tmp");
  
        BufferedReader br = new BufferedReader(new FileReader("mdp.txt"));
        PrintWriter    pw = new PrintWriter(new FileWriter(tempFile));
  
        String line = null;
        int cpt = 0;
  
        //Read from the original file and write to the new
        //unless content matches data to be removed.
        while ((line = br.readLine()) != null)
        {
          if (cpt != numCompte-1)
          {
            pw.println(line);
          }
          cpt++;
        }
        pw.close();
        br.close();
  
        //Delete the original file
        if (!inFile.delete()) {
          System.out.println("Could not delete file");
          return;
        }
  
        //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(inFile))
          System.out.println("Could not rename file");
  
      }
      catch (FileNotFoundException ex) {
        ex.printStackTrace();
      }
      catch (IOException ex) {
        ex.printStackTrace();

        //refresh
      }
    }



    public String encode(String str)
    {
        String sRet = "";
        for (int i=0; i < str.length(); i++) { sRet +=  "" + (char) ( ( (int) str.charAt(i) ) + 5 ); }
        return sRet;
    }

    public String decode(String str)
    {
        String sRet = "";
        for (int i=0; i < str.length(); i++) { sRet +=  "" + (char) ( ( (int) str.charAt(i) ) - 5 ); }
        return sRet;
    }

    public String generate()
    {
        String sRet = "";
        for (int i = 0; i < 15; i++) { sRet += "" + (char) ((int)(Math.random() * 50) + 75); }
        return sRet;
    }
}
