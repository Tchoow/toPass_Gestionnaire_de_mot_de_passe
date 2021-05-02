import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;


import javax.swing.*;

public class PanelHeader extends JPanel
{
    private Controleur ctrl;
    private JLabel lblAccount;
    private JLabel lblLink;
    
    public PanelHeader( Controleur ctrl )
    {
        this.ctrl = ctrl;
        
        this.setLayout ( new FlowLayout() );

		/*----------------------------*/
		/* Création des  composants   */
		/*----------------------------*/

        this.lblAccount = new JLabel("Gestionnaire de mot de passe");
        this.lblAccount.setFont( new Font ("Arial", Font.PLAIN, 20));
        this.lblAccount.setForeground(Color.WHITE);

        this.lblLink = new JLabel("©Tobloxia", JLabel.RIGHT);

		/*--------------------------------*/
		/* positionnement des  composants */
		/*--------------------------------*/

        this.add( this.lblAccount );
        this.add( this.lblLink );


        // Colors
        this.setBackground( new Color(186, 30, 30));


    }

    public void setName(String name)
    {
        this.lblAccount.setText(name);
    }
}
