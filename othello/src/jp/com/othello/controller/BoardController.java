package jp.com.othello.controller;

import jp.com.othello.GridState;
import jp.com.othello.data.Board;
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
	public void play( int column, int row, GridState state ) {
		// TODO 駒が置けるかチェック

		// TODO ひっくり返る駒を調べる

		// TODO 盤面の更新
		board.updateBoard(column, row, state);

		// 描画の更新
		viewBoard.update(board.getBoardInfo());

		// TODO ゲーム終了判定
	}
}
