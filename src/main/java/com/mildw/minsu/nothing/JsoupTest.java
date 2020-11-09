package com.mildw.minsu.nothing;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupTest {

    public static void main(String[] args) {

        //3900000 넘는 아티스트가 있음 ㅋㅋ
        String URL = "https://vibe.naver.com/artist/";
        //아티스트 이미지 //이름 //데뷔날짜 //장르
        List<String> song_list = new ArrayList<>();
        // 도큐먼트에는 페이지의 전체 소스가 저장된다.
        try{
            for(int i=1; i<2; i++){
                String URI = URL+i;
                Document doc = org.jsoup.Jsoup.connect(URI).get();
                System.out.println(URI);
                Elements title = doc.select(".title");
                Elements items = doc.select(".item");
                System.out.println(doc);
                System.out.println("------------------------ start ------------------------");
                System.out.println(title);
                System.out.println(items);
            }
        }catch (Exception e){
            System.out.println(e);
        }


        for (String s:song_list) {
            System.out.println(s);
        }

    }

}
