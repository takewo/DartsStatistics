package org.shmztko.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.shmztko.accessor.DartsLivePages;
import org.shmztko.accessor.PageAccessor;
import org.shmztko.model.Statistic;

public class DartsLiveParser {

	/** 成績取得元ページへのアクセス用クラス */
	private PageAccessor accessor;

	public DartsLiveParser(PageAccessor accessor) {
		this.accessor = accessor;
	}

	public List<Statistic> getYesterdayStats() {
		Document doc = Jsoup.parse(accessor.getPage(DartsLivePages.PLAYDATA.getLocation()));

		Elements elements = doc.select("#yesterday .result");
		if (elements.size() <= 0) {
			return Collections.emptyList();
		}

		Element element = elements.get(0);
		String gameName = "";
		int gameOrder = 0;
		
		List<Statistic> result = new ArrayList<Statistic>();
		for (Element childElement : element.children()) {
			String className = childElement.className();

			if (!className.equals("resultLi")) {
				gameName = childElement.text();
				gameOrder = 0;

			} else {
				Element gameElement = childElement.select(".gameList").get(0);
				Elements gameList = gameElement.children();

				int players = gameList.size();
				Element score = gameList.select(".point.own").get(0);

				Statistic statistic = new Statistic();
				statistic.setGameName(gameName);
				statistic.setGameFormat(score.parent().className());
				statistic.setGameOrder(gameOrder++);
				statistic.setNumberOfPlayers(players);
				statistic.setScore(score.text());
				result.add(statistic);
			}
		}
		return result;
	}
}
