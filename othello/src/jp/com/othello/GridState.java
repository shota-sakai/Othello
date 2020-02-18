package jp.com.othello;

/**
 * オセロ盤面の1マスの状態を表すenum
 */
public enum GridState {
	NONE,			// 石が置かれてない状態
	BLACK_STONE,	// 黒駒が置かれている状態
	WHITE_STONE		// 白駒が置かれている状態
}