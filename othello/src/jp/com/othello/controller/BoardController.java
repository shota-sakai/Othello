package jp.com.othello.controller;

import java.util.ArrayList;
import java.util.List;

import jp.com.othello.GameState;
import jp.com.othello.StoneKind;
import jp.com.othello.data.Board;
import jp.com.othello.data.Stone;
import jp.com.othello.view.ViewBoard;

/**
 * オセロの盤面を操作するクラス
 */
public class BoardController {
	private Board board;
	private ViewBoard viewBoard;

	/**
	 * コンストラクタ
	 */
	public BoardController() {}

	/**
	 * 準備処理
	 *
	 * @param board 盤面情報クラス
	 * @param viewBoard 盤面表示用クラス
	 */
	public void setup(Board board, ViewBoard viewBoard) {
		this.board = board;
		this.viewBoard = viewBoard;
		// 描画の更新
		this.viewBoard.update(board.getBoardInfo());
	}

	/**
	 * 駒を置いた時の盤面処理
	 * 引数が不正の場合は処理しない
	 *
	 * @param column 横方向の座標
	 * @param row 縦方向の座標
	 * @param state 駒の種類
	 */
	public void play( int column, int row, StoneKind state ) {

		// 指定された座標にすでに駒置かれている場合は処理しない
		if( board.getGridState(column, row) != null ) {
			return;
		}

		// TODO ひっくり返る駒を調べる
		List<Stone> turnOverStoneList = checkTurnOverStone(column, row, board.getBoardInfo(), StoneKind.WHITE);


		// ひっくり返る駒がない場合は何もしない



		// TODO 盤面の更新
		board.updateBoard(column, row, state);

		// 描画の更新
		viewBoard.update(board.getBoardInfo());

		// TODO ゲーム終了判定
		if( board.gridStateCnt(null) == 0 ) {
			GameManager.getInstance().setGameState(GameState.OTHELLO_END);
		}
	}

	/**
	 * ひっくり返る駒をチェックする
	 *
	 * @param column 行
	 * @param row 列
	 * @param boardInfo 盤面情報
	 * @param targetKind
	 * @return ひっくり返る駒のリストを返す
	 */
	private List<Stone> checkTurnOverStone( int column, int row, StoneKind[][] boardInfo, StoneKind targetKind ){

		List<Stone> resultList = new ArrayList<>();
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.UP, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.LEFT_UP, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.LEFT, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.LEFT_DOWN, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.DOWN, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.RIGHT_UP, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.RIGHT, resultList);
		putTurnOverStone(column, row, targetKind, boardInfo, DirectionPattern.RIGHT_DOWN, resultList);

		return resultList;
	}


	private void putTurnOverStone(
			int column,
			int row,
			StoneKind targetKind,
			StoneKind[][] boardInfo,
			DirectionPattern dirPtn,
			List<Stone> putList ) {

		int c = column + dirPtn.getColumnIncrement();
		int r = row + dirPtn.getRowIncrement();

		while(true) {
			if( !isValidRange(c, r) ) {
				return;
			}
			if( boardInfo[c][r] != targetKind ) {
				return;
			}

			putList.add(new Stone(c, r, targetKind));
		}
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


	/**
	 * 駒を置いた時にチェックするマス方向のパターンを表現するenum
	 */
	private enum DirectionPattern {
		UP(-1,0),				// 上
		LEFT_UP(-1, -1),		// 左上
		LEFT(0, -1),			// 左
		LEFT_DOWN(1, -1),		// 左下
		DOWN(1, 0),				// 下
		RIGHT_DOWN(1, 1),		// 右下
		RIGHT(0, 1),			// 右
		RIGHT_UP(-1, 1);		// 右上

		// 行方向の加算値
		private int columnIncrementValue;
		// 列方向の加算値
		private int rowIncrementValue;

		/**
		 * コンストラクタ
		 *
		 * @param columnValue 行のインクリメント値
		 * @param rowValue 列のインクリメント値
		 */
		private DirectionPattern(int columnValue, int rowValue ) {
			this.columnIncrementValue = columnValue;
			this.rowIncrementValue = rowValue;
		}

		/**
		 * 行のインクリメント値を取得する
		 *
		 * @return 行のインクリメント値
		 */
		public int getColumnIncrement() {
			return this.columnIncrementValue;
		}

		/**
		 * 列のインクリメント値を取得する
		 *
		 * @return 列のインクリメント値
		 */
		public int getRowIncrement() {
			return this.rowIncrementValue;
		}
	}
}
