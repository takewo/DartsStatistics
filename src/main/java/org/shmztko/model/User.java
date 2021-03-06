package org.shmztko.model;

import java.util.List;

import org.javalite.activejdbc.Model;

/**
 * ユーザを表すデータモデル
 * @author ShimizuTakeo
 */
public class User extends Model {

	/**
	 * @return カード名
	 */
	public String getCardName() {
		return getString("card_name");
	}

	/**
	 * @param cardName カード名
	 */
	public void setCardName(String cardName) {
		set("card_name", cardName);
	}

	/**
	 * @return メールアドレス
	 */
	public String getEmail() {
		return getString("email");
	}
	/**
	 * @param email メールアドレス
	 */
	public void setEmail(String email) {
		set("email", email);
	}

	/**
	 * @return ログインURL
	 */
	public String getLoginUrl() {
		return getString("login_url");
	}
	/**
	 * @param loginUrl ログインURL
	 */
	public void setLoginUrl(String loginUrl) {
		set("login_url", loginUrl);
	}

	/**
	 * @return 成績記録
	 */
	public List<Record> getRecords() {
		return getAll(Record.class);
	}

	/**
	 * @param record 成績記録
	 */
	public void addRecord(Record record) {
		add(record);
	}
}
