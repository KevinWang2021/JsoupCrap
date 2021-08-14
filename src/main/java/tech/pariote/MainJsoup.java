package tech.pariote;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainJsoup {
    public static void main(String[] args) {
        try {
            MainJsoup.soupPages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sayHello() {
        System.out.println("Hello World");
    }

    public static void soupPages() throws IOException {
        Document doc = Jsoup.connect("https://developer.huawei.com/consumer/cn").get();

        Elements newsHeadlines = doc.select("a");
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

}
