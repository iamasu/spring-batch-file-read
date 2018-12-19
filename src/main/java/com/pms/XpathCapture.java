package com.sanuthiracommodities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class XpathCapture {

    private static int getElementPosition(final Element element) {
        final Elements chlds = element.parent().children();
        int count = 0;
        for (Element e : chlds) {
            if (e.nodeName().equals(element.nodeName())) {
                count++;
            }
        }
        int position = 0;
        for (Element e : chlds) {
            if (e.nodeName().equals(element.nodeName())) {
                position++;
                if (element.siblingIndex() == e.siblingIndex() && count > 1) {
                    break;
                }
            }
        }
        return count > 1 ? position : 0;
    }

    public static void xpath(final javax.swing.JTextArea noticeBoard, final String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.body().getAllElements();
        for (Element element : elements) {
            StringBuilder path;
            if (StringUtils.hasLength(element.id())) {
                path = new StringBuilder("//*[@id=\"" + element.id() + "\"]");
            } else {
                path = new StringBuilder(element.nodeName());
                int position = getElementPosition(element);
                if (position > 0) {
                    path.append("[").append(position).append("]");
                }
                for (Element el : element.parents()) {
                    if (StringUtils.hasLength(el.id())) {
                        path.insert(0, "//*[@id=\"" + el.id() + "\"]/");
                    } else {
                        position = getElementPosition(el);
                        if (position > 0) {
                            path.insert(0, el.nodeName() + "[" + position + "]/");
                        } else {
                            path.insert(0, el.nodeName() + '/');
                        }
                    }
                }
                int index = path.lastIndexOf("*");
                if (index > 3) {
                    path.delete(0, index - 2);
                }
            }
            System.out.println(path + " = " + element.attributes() + " : Own Text= " + element.ownText());
            noticeBoard.setText(path + " = " + element.attributes() + " : Own Text= " + element.ownText());
            if (element.attributes().size() > 0) {
                //System.out.println(path + " = " + element.attributes()+" OwnText ="+element.ownText());
                if (!element.ownText().equalsIgnoreCase("")) {
                    noticeBoard.setText(path + " = " + element.ownText());
                } else if (element.ownText().equalsIgnoreCase("") && (!(element.attr("name").equalsIgnoreCase("")) || !(element.attr("src").equalsIgnoreCase("")) || !(element.attr("type").equalsIgnoreCase("")))) {
                    noticeBoard.setText(path + " = Name : " + element.attr("name") + " , Src :" + element.attr("src") + " ,Type :" + element.attr("type"));
                }

            }
        }
    }
}
