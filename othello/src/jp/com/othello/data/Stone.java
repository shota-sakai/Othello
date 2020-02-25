package jp.com.othello.data;

import jp.com.othello.StoneKind;

/**
 * オセロの駒を表現するクラス
 */
public class Stone {

	// 駒の種類
	private StoneKind kind;

	// 行座標
	private int column;

	// 列座標
	private int row;

	/**
	 * 非公開のコンストラクタ
	 */
	private Stone() {}

	/**
	 * コンストラクタ
	 *
	 * @param column 行
	 * @param row 列
	 * @param kind 駒の種類
	 */
	public Stone( int column, int row, StoneKind kind) {
		this.column = column;
		this.row = row;
		this.kind = kind;
	}

	/**
	 * 駒の種類を取得する
	 *
	 * @return 駒の種類
	 */
	public StoneKind getKind() {
		return kind;
	}

	/**
	 * 駒の行座標を取得する
	 *
	 * @return 行座標
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * 駒の列座標を取得する
	 *
	 * @return 列座標
	 */
	public int getRow() {
		return row;
	}
}
