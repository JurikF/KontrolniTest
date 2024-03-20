import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame{
    private JTextField text;
    private JButton addButton;
    private JButton nextButton;
    private JButton prevButton;
    private JPanel panelMain;

    private int index = 0;

    private List<String> seznamSouboru = new ArrayList<>();
    public Gui() {
        super("Soubory");
        setContentPane(panelMain);
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pridaniSouboru();

        nextButton.addActionListener(e -> next());
        prevButton.addActionListener(e -> prev());

        display();

        addButton.addActionListener(e -> vybraniSouboru());
    }

    public void vybraniSouboru() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Files", "txt"));
        int vysledek = fc.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File vybranySoubor = fc.getSelectedFile();
            seznamSouboru.add(vybranySoubor.getPath());
            text.setText(vybranySoubor.getPath());
            index = seznamSouboru.size()-1;
        }
    }

    public void pridaniSouboru() {
        seznamSouboru.add("Soubor1");
        seznamSouboru.add("Soubor2");
        seznamSouboru.add("Soubor3");
    }

    public void prev() {
        if (index > 0) {
            index--;
            display();
        }
    }

    public void next() {
        if (index < seznamSouboru.size()-1) {
            index++;
            display();
        }
    }

    public void display() {
        text.setText(seznamSouboru.get(index));
    }


    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setVisible(true);
    }
}
