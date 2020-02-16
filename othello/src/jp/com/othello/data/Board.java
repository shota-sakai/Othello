package jp.com.othello.data;

import jp.com.othello.GridState;


/**
 * オセロ盤面を表現するクラス
 */
public class Board {
	// 横方向のマス最大値
	public static final int BOARD_ROW_MAX = 8;
	// 縦方向のマス最大値
	public static final int BOARD_COLUMN_MAX = 8;
	// 盤面情報を表現する二次元配列
	private GridState[][] boardInfo = {
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.WHITE_STONE, GridState.BLACK_STONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.BLACK_STONE, GridState.WHITE_STONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE},
			{GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE, GridState.NONE}
			};

	/**
	 * コンストラクタ
	 */
	public Board() {}

	/**
	 * 盤面情報の配列を取得する
	 *
	 * @return GridStateの二次元配列
	 */
	public GridState[][] getBoardInfo(){
		return this.boardInfo;
	}

	/**
	 * 盤面情報を更新する
	 *
	 * @param column　行
	 * @param row 列
	 * @param state 状態
	 */
	public void updateBoard( int column, int row, GridState state ) {
		if( column >= BOARD_COLUMN_MAX || row >= BOARD_ROW_MAX ) {
			return;
		}

		boardInfo[column][row] = state;
	}
}
