package labproject;

import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame {

    JLabel l;
    JButton b;
    JRadioButton[] r;
    ButtonGroup bg;

    private Question[] q = {
        
        new Question(
                "What is the largest organ in our body?",
        new String[]{"Brain","Liver","Heart","Skin"},
        3),
        
        new Question(
                "Which senses is not located in the head?",
        new String[]{"Touch","Taste","Sight","Hearing"},
        0),
        
        new Question(
                "Which country has the largest river delta?",
        new String[]{"India","Bangladesh","Brazil","Australia"},
        1),
        
        new Question(
                "Longest day of the year?",
        new String[]{"21 June","21 September","22 July","25 December"},
        0),
        
        new Question(
                "<html>Which country won <br> the 2022 Football World cup?</html>",
        new String[]{"Brazil","France","America","Argentina"},
        3),
        
        new Question(
                "<html>Which country is going to host <br> the 2023 Cricket World Cup?</html>",
        new String[]{"India","Sri Lanka","Australia","Bangladesh"},
        0),
        
        new Question(
                "<html>What is the nickname of<br> the Bangladesh cricket team?</html>",
        new String[]{"Bengals","Black Caps","Lions","Tigers"},
        3),
        
        new Question(
            "What is the capital of Saudi Arabia?",
            new String[]{"Riyal", "Madrid", "Riyadh", "Jedda"},
            2 
        ),
        
        new Question(
            "Which is the 4th planet in our solar system?",
            new String[]{"Mars", "Jupiter", "Venus", "Saturn"},
            0 
        ),
        
        new Question(
            "What is the name of our galaxy?",
            new String[]{"Andromeda Galaxy ", "Milky Way Galaxy", "Triangulum Galaxy", "Pisces Dwarf Galaxy"},
            1 
        )
    };
    static int count = -1;

    double score = 0.0;

    public Quiz(String name) {
        super(name);
        l = new JLabel("Are you ready for the quiz?");
        b = new JButton("Start Quiz");
        r = new JRadioButton[4];
        bg = new ButtonGroup();

        for (int i = 0; i < r.length; i++) {
            r[i] = new JRadioButton();
             r[i].addActionListener(new optionSelect(i));
            bg.add(r[i]);

        }

        add(l);
        add(b);
        l.setBounds(100, 20, 400, 50);
        b.setBounds(140, 220, 100, 20);

        ActionListener a1 = (ActionEvent e) -> {
            if (count != (q.length-1)) {
                if(bg.getSelection()==null && count!=-1){
                    JOptionPane.showMessageDialog(null, "Please select an answer.","Select One", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                count++;
                l.setText(q[count].getQuestion());
                if(count==(q.length-1)){
                    b.setText("Finish");
                }else{
                b.setText("Next");
                }
                String[] op = q[count].getOptions();

                for (int i = 0; i < r.length; i++) {

                    r[i].setText(op[i]);
                    add(r[i]);
                }
                r[0].setBounds(120, 100, 150, 20);
                r[1].setBounds(120, 130, 150, 20);
                r[2].setBounds(120, 160, 150, 20);
                r[3].setBounds(120, 190, 150, 20);


            } else {
                JOptionPane.showMessageDialog(null, "Your Score is: " + score+" out of "+q.length,"Score",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
            
            
            bg.clearSelection();

            
        };
        

        b.addActionListener(a1);

        setLayout(null);
        setBounds(500, 200, 400, 400);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class optionSelect implements ActionListener{
        
        private int index;
        
        public optionSelect(int index){
            this.index=index;
            
        }
         @Override
        public void actionPerformed(ActionEvent e) {
            if (index == q[count].getAnswer()) {
                score++;
            }
        }
    }

}


 class LabProject {

    public static void main(String[] args) {
        Quiz quiz=new Quiz("Swing Quiz");
    }
    
}
