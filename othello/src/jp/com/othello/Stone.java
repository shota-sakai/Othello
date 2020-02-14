package jp.com.othello;

import javax.swing.JLabel;

/**
 * 駒を表現するクラス
 * 
 * @author UU128839
 *
 */
public class Stone {
    // 駒の見た目
    private JLabel label;

    public Stone() {
        this.label = new JLabel("New label");
        this.label.setBounds(52, 40, 50, 13);
    }

}
