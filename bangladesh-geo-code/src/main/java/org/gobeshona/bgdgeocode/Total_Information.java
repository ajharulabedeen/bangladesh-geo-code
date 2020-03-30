/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.bgdgeocode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Total_Information {
    public static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36";

    public static void main(String[] args) throws Exception {
        final String query = "android2";
        String url = "https://www.bangladesh.gov.bd/site/view/division-list/List-of-Divisions";
        final Document doc = Jsoup.connect(url).userAgent(USER_AGENT).validateTLSCertificates(false).get();

//        System.out.println(doc.outerHtml());

        File file = new File(query + ".html");
//        String content = doc.getElementsByClass("infogra-menu-item-sixth").select("span").outerHtml();
        String content = doc.getElementsByClass("infogra-menu-item-sixth").select("span").outerHtml();
        System.out.println(content);
//        Elements elements = doc.getElementsByClass("geotable");
//        Elements elements = doc.select("td");
//        System.out.println(elements.outerHtml());
//        Elements ea = elements.select("a");
//        for (Element e1 : elements) {
//            System.out.println(e.select("a").outerHtml());
//            System.out.println(e1.select("a").attr("title").toUpperCase());
//        }

//        for (Element e2 : ea) {
//            System.out.println(e2.attr("title"));
//            System.out.println(e.select("a").outerHtml());
//            System.out.println(e.select("a").attr("title").toUpperCase());
//        }


        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main

}//class
