package jp.com.othello.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jp.com.othello.GridState;
import jp.com.othello.controller.BoardController;

/**
 * 駒の見た目を表現するクラス
 */
public class ViewStone {
	// 駒のサイズ
	private static final int STONE_SIZE = 55;
	// 黒駒アイコン
	private static final ImageIcon BLACK_STONE_ICON = new ImageIcon("./img/black.png");
	// 白駒アイコン
	private static final ImageIcon WHITE_STONE_ICON = new ImageIcon("./img/white.png");
    // 駒の見た目を表現するラベル
    private JLabel label;
    // 駒の横方向の座標
    private int colume;
    // 駒の縦方向の座標
    private int row;

    /**
     * コンストラクタ
     */
    public ViewStone() {}

    /**
     *　事前準備処理
     *
     * @param column 配置する行
     * @param row 配置する列
     * @param panel パネルオブジェクト
     * @param controller 盤面コントロールクラス
     */
    public void setup(int column, int row, JPanel panel, BoardController controller) {
    	this.colume = column;
    	this.row = row;
    	this.label = new JLabel("");
    	this.label.setBounds(this.colume*STONE_SIZE, this.row*STONE_SIZE, STONE_SIZE, STONE_SIZE);
    	this.label.setIcon(null);

    	// クリックイベント設定
    	this.label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 駒を置いた時の処理
				controller.play(colume, row, GridState.BLACK_STONE);
			}
		});

    	panel.add(this.label);
    }

    /**
     * 駒の状態を更新する
     *
     * @param state 駒の状態
     */
    public void update( GridState state ) {
    	if( state.equals(GridState.BLACK_STONE) ) {
    		this.label.setIcon(BLACK_STONE_ICON);
    	}else if( state.equals(GridState.WHITE_STONE) ) {
    		this.label.setIcon(WHITE_STONE_ICON);
    	}else {
    		this.label.setIcon(null);
    	}
    }
}
