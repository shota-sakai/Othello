package jp.com.othello.controller;

import jp.com.othello.GameState;
import jp.com.othello.PlayerKind;

/**
 * ゲーム処理（状態）を扱うクラス
 *
 */
public class GameManager {

	// 唯一のGameManagerインスタンス
	private static final GameManager instance = new GameManager();

	// ゲーム状態
	private GameState state;

	// ターン状態
	private PlayerKind playTurn;

	/**
	 * 非公開のコンストラクタ
	 */
	private GameManager() {}

	/**
	 * インスタンス取得
	 *
	 * @return 唯一のGameManagerインスタンス
	 */
	public static GameManager getInstance() {
		return instance;
	}

	/**
	 * 現在の駒を置く番のプレイヤー情報を取得する
	 *
	 * @return プレイヤー情報
	 */
	public PlayerKind getPlayTurn() {
		return playTurn;
	}

	/**
	 * 現在の駒を置く番のプレイヤー情報を設定する
	 *
	 * @param playTurn プレイヤー情報
	 */
	public void setPlayTurn(PlayerKind playTurn) {
		this.playTurn = playTurn;
	}

	/**
	 * ゲーム状態を取得する
	 *
	 * @return ゲーム状態
	 */
	public GameState getGameState() {
		return state;
	}

	/**
	 * ゲーム状態を設定する
	 *
	 * @param state ゲーム状態
	 */
	public void setGameState(GameState state) {
		this.state = state;
	}

	/**
	 * プレイヤーターン状態を更新する
	 */
	public void updatePlayTurn(){
		if( PlayerKind.BLACK.equals(this.playTurn) ) {
			this.setPlayTurn(PlayerKind.WHITE);
		}else if ( PlayerKind.WHITE.equals(this.playTurn) ){
			this.setPlayTurn(PlayerKind.BLACK);
		}
	}
}
