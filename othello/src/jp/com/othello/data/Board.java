package jp.com.othello.data;

import jp.com.othello.StoneKind;


/**
 * オセロ盤面を表現するクラス
 */
public class Board {
	// 横方向のマス最大値
	public static final int BOARD_ROW_MAX = 8;
	// 縦方向のマス最大値
	public static final int BOARD_COLUMN_MAX = 8;
	// 盤面情報を表現する二次元配列
	private StoneKind[][] boardInfo = {
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, StoneKind.WHITE, StoneKind.BLACK, null, null, null},
		{null, null, null, StoneKind.BLACK, StoneKind.WHITE, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null}
	};

	/**
	 * コンストラクタ
	 */
	public Board() {}

	/**
	 * 盤面情報の配列を取得する
	 *
	 * @return StoneKindの二次元配列
	 */
	public StoneKind[][] getBoardInfo(){
		return this.boardInfo;
	}

	/**
	 * 盤面情報を更新する
	 *
	 * @param column 行
	 * @param row 列
	 * @param state 状態
	 */
	public void updateBoard( int column, int row, StoneKind state ) {

		// 指定された座標が盤面の範囲外の場合は更新しない
		if( isValidRange(column, row) ) {
			return;
		}

		boardInfo[column][row] = state;
	}

	/**
	 * 指定した座標のマス状態を取得する
	 *
	 * @param column 行
	 * @param row 列
	 * @return マス状態
	 */
	public StoneKind getGridState( int column, int row) {

		if( isValidRange(column, row) ) {
			return null;
		}

		return boardInfo[column][row];
	}

	/**
	 * 指定した状態のマスの数を取得する
	 *
	 * @return マスの数
	 */
	public int gridStateCnt( StoneKind kind ) {

		int count = 0;
		for( StoneKind[] c : boardInfo ) {
			for( StoneKind r : c ) {
				if( r == kind ) count++;
			}
		}

		return count;
	}

	/**
	 * 指定された座標が盤面の範囲内でどうかをチェックする
	 *
	 * @param column 行
	 * @param row 列
	 * @return 範囲外の場合はfalseを返す
	 */
	private boolean isValidRange( int column, int row ) {
		return (column <= 1 && column >= Board.BOARD_COLUMN_MAX) && (row <= 1 && row >= Board.BOARD_ROW_MAX);
	}

}
