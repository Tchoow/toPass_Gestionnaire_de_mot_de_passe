
import iut.algo.Clavier;
import java.lang.Math;

public class Encryption
{
    public static void main(String[] args)
    {
        String str;

        System.out.println("String a crypter:");
        str= generate();

        System.out.println(str);

    }



    public static String generate()
    {
        String sRet = "";
        for (int i = 0; i < 15; i++) { sRet += "" + (char) ((int)(Math.random() * 50) + 75); }
        return sRet;
    }

}


/*
Collections.sort(list,
                 new Comparaor<Node>()
                 {
                     public int compare(Node n1, Node n2)
                 }
                 );

*/