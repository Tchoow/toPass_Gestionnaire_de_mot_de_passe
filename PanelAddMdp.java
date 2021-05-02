import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;

public class PanelAddMdp extends JPanel
{
    private Controleur ctrl;
    private JTextField[] txtInfo;
    private JLabel[] lblInfo;
    private String[] textLabel = {"Nom :", "Lien[0..1] :", "Identifiant", "Mot de passe", "Notes[0..1] :"};

    public PanelAddMdp(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setLayout( new GridLayout(5, 2, 10, 10) );

		/*----------------------------*/
		/* Création des  composants   */
		/*----------------------------*/

        this.txtInfo = new JTextField[5];
        this.lblInfo = new JLabel[5];

        for (int i = 0 ; i < 5; i++)
        {
            this.lblInfo[i] = new JLabel(this.textLabel[i], JLabel.RIGHT);
            this.lblInfo[i].setFont( new Font ("Arial", Font.PLAIN, 20));
            this.txtInfo[i] = new JTextField ( 20 );
            this.txtInfo[i].setFont( new Font ("Arial", Font.PLAIN, 14)); 
        }


		/*--------------------------------*/
		/* positionnement des  composants */
		/*--------------------------------*/


        for (int i = 0 ; i <  5; i++)
        {
            this.add( this.lblInfo[i] );
            this.add( this.txtInfo[i] );
        }




        // Colors
        this.setBackground( new Color(233, 126, 126) );

    }
    public String getName() { return this.txtInfo[0].getText(); }
    public String getLink() { return this.txtInfo[1].getText(); }
    public String getId()   { return this.txtInfo[2].getText(); }
    public String getMdp()  { return this.txtInfo[3].getText(); }
    public String getNote() { return this.txtInfo[4].getText(); }
}
