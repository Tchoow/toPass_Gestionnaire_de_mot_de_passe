import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

public class PanelMain extends JPanel
{
    private Controleur ctrl;
    private JLabel[]     ensJLabels;
    private JTextField[] ensTextFields;
    private String[] txtLabel = {"Lien:", "Identifiant:", "Mot de passe:", "Informations supp:"};
    private JPanel[] panelMdpCopy;
    private JButton[] ensBtnCopy;

    public PanelMain( Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setLayout ( new GridLayout( 4, 2, 10, 10 ) );

		/*----------------------------*/
		/* Création des  composants   */
		/*----------------------------*/
        this.ensJLabels    = new JLabel[4];
        this.ensTextFields = new JTextField[4];
        this.panelMdpCopy  = new JPanel[4];
        this.ensBtnCopy    = new JButton[4];


        for (int i =0; i < 4; i++)
        {
            this.ensJLabels[i] = new JLabel( this.txtLabel[i], JLabel.CENTER);
            this.ensJLabels[i].setFont( new Font ("Arial", Font.PLAIN, 20));

            this.ensTextFields[i] = new JTextField ( 20 );
            this.ensTextFields[i].setFont( new Font ("Arial", Font.PLAIN, 20));
            this.ensTextFields[i].setText("Aucun compte selectionné");

            if (i < 3) this.ensBtnCopy[i] = new JButton("copy");
            else this.ensBtnCopy[i] = new JButton("supprimer compte");

            this.ensBtnCopy[i].setBackground( new Color(158, 158, 158));

            this.panelMdpCopy[i] = new JPanel( new BorderLayout ());

        }
        
		/*--------------------------------*/
		/* positionnement des  composants */
		/*--------------------------------*/

        for (int i = 0; i < 4; i++)
        {
            // Label
            this.add( this.ensJLabels[i] );

            // mdp + copy
            this.panelMdpCopy[i].add( this.ensTextFields[i]);
            this.panelMdpCopy[i].add( this.ensBtnCopy[i], BorderLayout.EAST);

            this.add (this.panelMdpCopy[i]);
        }


        //Colors
        this.setBackground( new Color(233, 126, 126) );

    }


    public void setLink(String link) { this.ensTextFields[0].setText(link);}
    public void setId  (String id  ) { this.ensTextFields[1].setText(id)  ;}
    public void setMdp (String mdp ) { this.ensTextFields[2].setText(mdp) ;}
    public void setNote(String note) { this.ensTextFields[3].setText(note);}


}
