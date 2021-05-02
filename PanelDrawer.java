import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class PanelDrawer extends JPanel implements ActionListener
{
    private Controleur ctrl;
    private JButton btnAddPass;
    private JButton[] ensMDP;
    private JPanel pnlAddPass;

    public PanelDrawer( Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setLayout ( new GridLayout( 10, 1, 10, 10 ) );

		/*----------------------------*/
		/* Création des  composants   */
		/*----------------------------*/
        this.pnlAddPass = new JPanel( new BorderLayout() );


        this.btnAddPass = new JButton ( "+");
        this.btnAddPass.setBackground( Color.yellow);



        this.ensMDP  = new JButton[this.ctrl.getNbPassword()];// méthode get

        for (int i = 0; i < this.ensMDP.length; i++)
        {
            this.ensMDP[i] = new JButton( this.ctrl.getPasswordIndice(i).getNom() );
        }

		/*--------------------------------*/
		/* positionnement des  composants */
		/*--------------------------------*/

        this.pnlAddPass.add(this.btnAddPass, BorderLayout.WEST);
        this.pnlAddPass.add( new JLabel( "Ajouter mot de passe") );

        this.add ( this.pnlAddPass);

        for (JButton b : ensMDP)
        {
            this.add( b );
            b.setBackground( new Color(205, 74, 74) );
        }



        // Colors
        this.pnlAddPass.setBackground( new Color(181, 79, 79) );
        this.setBackground( Color.DARK_GRAY );


    
		/*----------------------------------------*/
		/* Activation des composants              */
		/*----------------------------------------*/

        // Bouton ajouter mot de passe
        this.btnAddPass.addActionListener( this );

        // Bouton accès mot de passe
        for (JButton b : this.ensMDP) b.addActionListener( this );




    }

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == this.btnAddPass ) this.ctrl.newMdp();

        if ( e.getSource() != this.btnAddPass )
        {
            int index=0;
            for (JButton b : this.ensMDP)
            {
                if (e.getSource() == b)
                {
                    b.setBackground(Color.yellow);
                    this.ctrl.actualisation(index);
                }
                else
                {
                    b.setBackground( new Color(205, 74, 74) );
                }
                index++;
            }
        }
        
    }
    

}
