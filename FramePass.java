// import java.awt.BorderLayout; (par défaut)

import java.awt.BorderLayout;

import javax.swing.*;

public class FramePass extends JFrame
{
    Controleur    ctrl;
    PanelHeader   panelHeader;
    PanelDrawer   panelDrawer;
    PanelMain     panelMain  ;

    public FramePass( Controleur ctrl )
    {
        this.ctrl = ctrl;
        this.setTitle ( "ToPass" );
        this.setLocation(180, 180);
        this.setSize(600, 600);

		/*----------------------------*/
		/* Création des  panels       */
		/*----------------------------*/

        this.panelHeader = new PanelHeader (ctrl);
        this.panelDrawer = new PanelDrawer (ctrl);
        this.panelMain   = new PanelMain   (ctrl);



		/*--------------------------------*/
		/* positionnement des  panels     */
		/*--------------------------------*/

        this.add( this.panelHeader, BorderLayout.NORTH );
        this.add( this.panelDrawer, BorderLayout.WEST  );
        this.add( this.panelMain );


        this.pack();

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }


    public void maj()
    {
        this.panelHeader.setName(this.ctrl.getName());
        this.panelMain.setLink  (this.ctrl.getLink());
        this.panelMain.setId    (this.ctrl.getId());
        this.panelMain.setMdp   (this.ctrl.getMdp());
        this.panelMain.setNote  (this.ctrl.getNote());
    }
}
