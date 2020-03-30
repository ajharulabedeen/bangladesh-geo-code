package org.gobeshona.bgdgeocode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BangladeshGeoCode {
    public static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36";

    public static void main(String[] args) {
        System.out.println("Bangladesh GEO Code Started!");
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("https://www.bangladesh.gov.bd/site/view/division-list/List-of-Divisions").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                // get the value from href attribute
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }// main
}// class
