import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class JConcentration extends JFrame implements MouseListener{

    private int[] cardValues = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
    private JPanel[] panelsArray = new JPanel[cardValues.length];
    private JLabel[] labelArray = new JLabel[cardValues.length];
    private ArrayList<JLabel> selectedLabelArray = new ArrayList<>(2);
    private ArrayList<JPanel> selectedPanelArray = new ArrayList<>(2);
    private boolean correct;
    private int click = 0;
    private int countMatches = 0;
    private final int ROW = 4;
    private final int COLUMN = 5;

    public JConcentration()
    {
        setLayout(new GridLayout(ROW,COLUMN,ROW,ROW));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializePanels(panelsArray,cardValues,labelArray);
    }

    @Override
    public void mouseClicked(MouseEvent e){
 
        //Get the object that produces the event
        Object source = e.getComponent();
        click++;
        correct = false;
        //Cast the object to a JPanel object
        JPanel selectedPanel = (JPanel) source;
        //Get all the components in the selected panel
        //which is just a JLabel
        Object[] label = selectedPanel.getComponents();
        JLabel selectedLabel = (JLabel)label[0];
        //Change the panel's background colour 
        //Display the JLabel's text
        selectedPanel.setBackground(Color.CYAN);
        selectedLabel.setVisible(true);

        //Add both the selectedPanel and itslabel to an arrayList
        //So that you can access them later
        selectedPanelArray.add(selectedPanel);
        selectedLabelArray.add(selectedLabel);

        //If the selected panels are two check if their values are equal
        //If they are equal "remove" them by setting their background to white
        //Make the correct variable to true to show that the cards are the same
        if(selectedPanelArray.size() == 2)
        {
            String str1 = selectedLabelArray.get(0).getText();
            String str2 = selectedLabelArray.get(1).getText();

            if(str1.equals(str2))
            {
               selectedPanelArray.get(0).setBackground(Color.WHITE);
               selectedPanelArray.get(1).setBackground(Color.WHITE);
               correct = true;
               countMatches++;

                //Remove the objects in the arrayList for the next round of choosing
                 selectedPanelArray.remove(0);
                 selectedPanelArray.remove(0);
                 selectedLabelArray.remove(0);
                 selectedLabelArray.remove(0);
                 click = 0;
            }

        }
       
       // System.out.println(countMatches);
        if(countMatches == 10)
        {
            JOptionPane.showMessageDialog(null,"CONGRATULATIONS!!! \nYOU MATCHED ALL");
            System.exit(ABORT);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){
        
    }
    @Override
    public void mouseExited(MouseEvent e){
         
        //If the correct varible is false, and the number of panels clicke is 2
        //Continue with the operation of hidding the cards since the are different
         if(correct == false && click == 2 && selectedPanelArray.size() == 2)
         {
            selectedPanelArray.get(0).setBackground(Color.RED);
            selectedPanelArray.get(1).setBackground(Color.RED);
            selectedLabelArray.get(0).setVisible(false);
            selectedLabelArray.get(1).setVisible(false);

             //Remove the objects in the arrayList for the next round of choosing
             selectedPanelArray.remove(0);
             selectedPanelArray.remove(0);
             selectedLabelArray.remove(0);
             selectedLabelArray.remove(0);
             click = 0;
         }
    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }

    /*initiaizePanels accepts one JPanel[] and a JLabel[]
     * and  int[] arguments
     * The method initializes the JPanels and add them into the frame
     * The method also sets the values of the panels randomly
     * and sets the JPanels initial color to RED
     */
    public void initializePanels(JPanel[] panelsArray, int[] cardValues, JLabel[] labelArray){
         
        //Initialize the panels and labels using a for loop
        //Set background color for each panel
        //Register the panels as event listeners(MouseEvents)
        //add each panel to the JFrame
        int i;
        for(i = 0; i < panelsArray.length; ++i)
        {
            panelsArray[i] = new JPanel();
            labelArray[i]= new JLabel();
            panelsArray[i].setBackground(Color.RED);
            panelsArray[i].addMouseListener(this);
            add(panelsArray[i]);
        }

        //Shuffle the cardValues using a loop
        for(i = 0; i < cardValues.length; ++i)
        {
            int j = (int)(Math.random()*cardValues.length);
            int temp = cardValues[i];
            cardValues[i] = cardValues[j];
            cardValues[j] = temp;
        }

        //Add text value to the JLabels
        //Make the JLabels invisible
        for(i = 0; i < cardValues.length; ++i)
        {
            panelsArray[i].add(labelArray[i]);
            String value = String.valueOf(cardValues[i]);//Converts an integer to String
            labelArray[i].setText(value);
            labelArray[i].setVisible(false);
        }

       
    }

    /*Main method instanciates the JConcentration class  */
    public static void main(String[] args) {
        JConcentration frame = new JConcentration();
        frame.setBounds(300,300,400,400);
        frame.setVisible(true);
    }
}