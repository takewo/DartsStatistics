package org.shmztko.accessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

/**
 * ローカルにあるHTMLファイルから、DartsLiveページの内容を取得するクラスです。
 * @author ShimizuTakeo
 */
public class LocalDartsLiveStatAccessor implements PageAccessor {

	/** ローカルにあるテスト用HTML */
	private static final File SOURCE_HTML = new File("./src/test/resources/testhtml/playdata.htm");

	@Override
	public String getPage(String location) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(SOURCE_HTML), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			int c;
			while ((c = br.read()) != -1) {
				sb.append((char) c);
			}
			return sb.toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			IOUtils.closeQuietly(br);
		}
	}

}
