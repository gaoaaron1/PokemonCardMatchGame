package loopmusicjavaupdated;

import java.awt.EventQueue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GUI {

    private int N = 4;
    private final List<JButton> list = new ArrayList<JButton>();

    public JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }
    

    
    
    public JButton createGridButton(final int row, final int col) {
        final JButton pokemonButton = new JButton("r" + row + ",c" + col);
        pokemonButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton cardButton = GUI.this.getGridButton(row, col);
                System.out.println("r" + row + ",c" + col
                    + " " + (pokemonButton == cardButton)
                    + " " + (pokemonButton.equals(cardButton)));
            }
        });
        return pokemonButton;
    }

    public JPanel createGridPanel() {
        JPanel cardPanel = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N * N; i++) {
            int row = i / N;
            int col = i % N;
            JButton cardButton = createGridButton(row, col);
            list.add(cardButton);
            cardButton.setIcon(new ImageIcon("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\PokemonCard2.png"));
            cardPanel.add(cardButton);
            
            
        }
        return cardPanel;
    }

    public void display() {
        JFrame frame = new JFrame("Pokemon Card Match Memory Game");
        JButton pokeButton = new JButton();
        JPanel pokePanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createGridPanel());
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    public static void run() {
            
    	String filepath = ("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\Poketheme.wav");
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
        new GUI().display();
    }
 
    }
