package IHM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Controleur;

public class FramePseudo extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private JPanel panelChoixPseudo;
    private JTextField txtPseudo;
    private JButton btnValider;
    private boolean etat; // true = Serveur, false = Client

    public FramePseudo(Controleur ctrl, boolean etat)
    {
        this.ctrl = ctrl;
        this.etat = etat;
        this.setTitle("Choix du pseudo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        // Création du panel de choix du pseudo
        this.panelChoixPseudo = new JPanel();
        this.txtPseudo = new JTextField(10);
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);

        // Ajout des composants au panel
        this.panelChoixPseudo.add(new JLabel("Pseudo : "));
        this.panelChoixPseudo.add(txtPseudo);
        this.panelChoixPseudo.add(btnValider);

        this.add(panelChoixPseudo, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnValider && !this.txtPseudo.getText().equals(""))
        {
            this.dispose();
            new FramePaint(this.ctrl, this.txtPseudo.getText(), this.etat);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un pseudo valide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}