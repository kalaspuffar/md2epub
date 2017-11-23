package org.ea.marktopub;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.io.File;
import java.io.FileReader;

public class Markdown2Epub {
    public static void main(String[] args) {
        try {
            MutableDataSet options = new MutableDataSet();
            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();

            // You can re-use parser and renderer instances
            Node document = parser.parseReader(new FileReader(new File("README.md")));
            String html = renderer.render(document);

            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
