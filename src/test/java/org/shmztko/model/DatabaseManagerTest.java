package org.shmztko.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * {@link DataBaseManager} に対するテストクラスです。
 * @author ShimizuTakeo
 */
public class DatabaseManagerTest {

	/** テスト対象クラスのインスタンス */
	private static DataBaseManager testTarget;

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testTarget = DataBaseManager.getInstance();
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * テストメソッド実行前に毎回実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@Before
	public void setUp() throws Exception {
		testTarget.migrateAll();
	}

	/**
	 * テストメソッド実行後に毎回実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@After
	public void tearDown() throws Exception {
		testTarget.delete(Statistic.class);
		testTarget.delete(User.class);
	}

	/**
	 * 何かしらのオブジェクトが生成できることを確認
	 */
	@Test
	public void test_createSomeObject() {
		testTarget.create(User.class);

		User[] result = testTarget.find(User.class);
		assertThat(result.length, is(1));
	}

	/**
	 * 何かしら生成したオブジェクトを検索できることを確認
	 */
	@Test
	public void test_findSomeObject() {
		User user = testTarget.create(User.class);

		User[] result = testTarget.find(User.class);
		assertThat(result.length, is(1));
		assertThat(result[0].getID(), is(equalTo(user.getID())));
	}

}
