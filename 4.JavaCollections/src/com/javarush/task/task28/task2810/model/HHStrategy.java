package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User2 on 03.02.2018.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    public static void main(String[] args) {
        new HHStrategy().getVacancies("ส่ๅโ");
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        final String siteName = "http://hh.ua";
        List<Vacancy> result = new ArrayList<>();

        for (int i = 0; ; i++) {
            try {
                Document doc = getDocument(searchString, i);
                Elements elements = doc.select("[data-qa='vacancy-serp__vacancy']");

                if (elements.size() == 0) break;
                else {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();

                        vacancy.setTitle(element.select("[data-qa='vacancy-serp__vacancy-title']").first().text());
                        vacancy.setCity(element.select("[data-qa='vacancy-serp__vacancy-address']").first().text());
                        vacancy.setCompanyName(element.select("[data-qa='vacancy-serp__vacancy-employer']").first().text());
                        vacancy.setSiteName(siteName);
                        vacancy.setUrl(element.select("[data-qa='vacancy-serp__vacancy-title']").first().attr("href"));
                        try {
                            vacancy.setSalary(element.select("[data-qa='vacancy-serp__vacancy-compensation']").first().text());
                        } catch (NullPointerException e) {
//                            e.printStackTrace();
                            vacancy.setSalary("");
                        }

                        result.add(vacancy);
                    }
                }
            } catch (IOException e) {
//                e.printStackTrace();
                break;
            }
        }

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document doc = null;

        try {
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36")
                    .referrer("no-referrer-when-downgrade")
                    .get();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
