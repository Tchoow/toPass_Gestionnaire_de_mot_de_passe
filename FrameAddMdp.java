// import java.awt.BorderLayout; (par défaut)

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;


public class FrameAddMdp extends JFrame implements ActionListener
{
    Controleur    ctrl;
    PanelAddMdp   panelInfo;
    private JButton btnValider;

    public FrameAddMdp( Controleur ctrl )
    {
        this.ctrl = ctrl;
        this.setTitle ( "Ajout d'un compte" );
        this.setLocation(180, 180);

		/*----------------------------*/
		/* Création des  panels       */
		/*----------------------------*/

        this.panelInfo   = new PanelAddMdp (ctrl);
        this.btnValider  = new JButton( "Valider");


		/*--------------------------------*/
		/* positionnement des  panels     */
		/*--------------------------------*/

        this.add( this.panelInfo );
        this.add( this.btnValider, BorderLayout.SOUTH );

    
		/*----------------------------------------*/
		/* Activation des composants              */
		/*----------------------------------------*/
        this.btnValider.addActionListener( this );

        this.pack();

        this.setDefaultCloseOperation( FrameAddMdp.EXIT_ON_CLOSE );
        this.setVisible( true );
    }

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == this.btnValider)
        {
            String sRet;
            String link;
            String note;

            if ( this.panelInfo.getLink().equals("") )link = "{absent}"; 
            else link = this.panelInfo.getLink();

            if ( this.panelInfo.getNote().equals("") )note = "{absent}";
            else note = this.panelInfo.getNote();


            sRet=this.panelInfo.getName() + ":" + link + ":" +
            this.panelInfo.getId()   + ":" + this.panelInfo.getMdp()  + ":" +
            note;
            
            this.ctrl.ajouterCompte(sRet);
            this.dispose();
            this.ctrl.actualisationDeux();
        }
        
    }
}
