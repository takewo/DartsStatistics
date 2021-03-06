package org.shmztko.accessor;
/**
 * ページアクセス用のインターフェース
 * @author ShimizuTakeo
 */
public interface PageAccessor {

	/**
	 * 指定されたページの内容を取得します。
	 * @param location ページの場所
	 * @return ページ内容
	 */
	public String getPage(String location);
}
