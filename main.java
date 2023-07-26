import javax.swing.JOptionPane;
import java.util.Random;

public class main{
    public static void main(String[] args) {
       
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int totalScore = 0;
        int maxAttemptsPerRound = 5;
        int numRounds = 3;

        
        for (int round = 1; round <= numRounds; round++) {
            
            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

            
            JOptionPane.showMessageDialog(null, "Round " + round + ":\nGuess the number between " + minNumber + " and " + maxNumber);

            
            int attempts = 0;
            int roundScore = 0;
            boolean guessedCorrectly = false;

           
            while (attempts < maxAttemptsPerRound) {
                
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + ":");
                int userGuess = Integer.parseInt(input);

                
                if (userGuess == targetNumber) {
                    
                    roundScore = maxAttemptsPerRound - attempts;
                    totalScore += roundScore;

                    
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.\nRound Score: " + roundScore + " | Total Score: " + totalScore);

                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Try again. The number is higher.");
                } else {
                    JOptionPane.showMessageDialog(null, "Try again. The number is lower.");
                }

                attempts++;
            }

            
            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Round Over! The number was " + targetNumber);
            }

            
            if (round < numRounds) {
                String playNextRound = JOptionPane.showInputDialog("Do you want to play the next round? (yes/no)");
                if (!playNextRound.equalsIgnoreCase("yes")) {
                    
                    break;
                }
            }
        }

        
        JOptionPane.showMessageDialog(null, "Game Over! Your final score is " + totalScore);
    }
}
