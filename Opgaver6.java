import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Opgaver6 extends JFrame implements ActionListener {

    JButton[] btn;
    char[] board;
    char current;
    boolean gameOver;

    public static void main(String[] args) {
        Opgaver6 w = new Opgaver6();
        w.setTitle("GUI TicTacToe");
        w.setSize(360, 420);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);
    }

    public Opgaver6() {
        setup();
        resetGame();
    }

    void setup() {
        getContentPane().setLayout(new GridLayout(3, 3));

        btn = new JButton[9];
        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton("");
            btn[i].setFont(new Font("Arial", Font.BOLD, 48));
            btn[i].addActionListener(this);
            getContentPane().add(btn[i]);
        }
    }

    void resetGame() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = '.';
            btn[i].setText("");
            btn[i].setEnabled(true);
        }
        current = 'X';
        gameOver = false;
    }

    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btn[i]) {
                handleClick(i);
                return;
            }
        }
    }

    void handleClick(int i) {
        if (board[i] != '.') return;

        board[i] = current;
        btn[i].setText(Character.toString(current));
        btn[i].setEnabled(false);

        if (hasWon(current)) {
            endGame(current + " WINS");
            return;
        }

        if (isDraw()) {
            endGame("NOBODY WINS");
            return;
        }

        current = (current == 'X') ? 'O' : 'X';
    }

    boolean hasWon(char p) {
        return
            (board[0] == p && board[1] == p && board[2] == p) ||
            (board[3] == p && board[4] == p && board[5] == p) ||
            (board[6] == p && board[7] == p && board[8] == p) ||
            (board[0] == p && board[3] == p && board[6] == p) ||
            (board[1] == p && board[4] == p && board[7] == p) ||
            (board[2] == p && board[5] == p && board[8] == p) ||
            (board[0] == p && board[4] == p && board[8] == p) ||
            (board[2] == p && board[4] == p && board[6] == p);
    }

    boolean isDraw() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == '.') return false;
        }
        return true;
    }

    void endGame(String message) {
        gameOver = true;

        for (int i = 0; i < 9; i++) {
            btn[i].setEnabled(false);
        }

        int choice = JOptionPane.showConfirmDialog(
            null,
            message + "\nPlay again?",
            "Game Over",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }
}

