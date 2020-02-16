package jp.com.othello;

import java.awt.EventQueue;

import javax.swing.JFrame;

import jp.com.othello.controller.BoardController;
import jp.com.othello.data.Board;
import jp.com.othello.view.ViewBoard;

public class MainForm extends JFrame {

	private static final int WINDOW_WIDTH_SIZE = 800;
	private static final int WINDOW_HEIGHT_SIZE = 800;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainForm frame = new MainForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
		setBounds(100, 100, WINDOW_WIDTH_SIZE, WINDOW_HEIGHT_SIZE);

		Board board = new Board();
		ViewBoard viewBoard = new ViewBoard();
		BoardController controller = new BoardController();
		viewBoard.setup(this, controller);
		controller.setup(board, viewBoard);
    }
}
