package jp.com.othello.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.com.othello.GridState;
import jp.com.othello.controller.BoardController;
import jp.com.othello.data.Board;

/**
 * オセロ盤面の見た目を表現するクラス
 */
public class ViewBoard {
	private static final int CHILD_BOARD_WIDTH_SIZE = 440;
	private static final int CHILD_BOARD_HEIGHT_SIZE = 460;
	private JPanel parentPanel;
	private JPanel childPanel;
	private ViewStone[][] viewStones = {
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() },
			{ new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone(), new ViewStone() }
	};

	/**
	 * コンストラクタ
	 */
	public ViewBoard(){	}

	/**
	 * 準備処理
	 *
	 * @param frame
	 * @param controller オセロ盤面コントロールクラス
	 */
	public void setup( JFrame frame, BoardController controller ) {
		// 親パネルオブジェクトの設定
		parentPanel = new JPanel();
		parentPanel.setLayout(null);
		frame.setContentPane(parentPanel);

		// 子パネルオブジェクトの設定
		childPanel = new JPanel();
		childPanel.setBounds(0, 0, CHILD_BOARD_WIDTH_SIZE, CHILD_BOARD_HEIGHT_SIZE);
		childPanel.setBackground(Color.GREEN);
		childPanel.setLayout(null);
		parentPanel.add(childPanel);

		// 表示用の駒オブジェクト準備処理
		for( int c=0; c<Board.BOARD_COLUMN_MAX; c++ ) {
			for( int r=0; r<Board.BOARD_ROW_MAX; r++ ) {
				viewStones[c][r].setup(c, r, childPanel, controller);
			}
		}
	}

	/**
	 * 盤面情報を元に駒の見た目を更新する
	 *
	 * @param gridStates
	 */
	public void update(GridState[][] gridStates) {
		for( int c=0; c<Board.BOARD_COLUMN_MAX; c++ ) {
			for( int r=0; r<Board.BOARD_ROW_MAX; r++ ) {
				viewStones[c][r].update(gridStates[c][r]);
			}
		}
	}
}
