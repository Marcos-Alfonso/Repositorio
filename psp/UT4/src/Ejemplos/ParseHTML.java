/*
 * Ejemplo análisis de página web usando liberia externa jsoup: Java HTML Parser
   https://jsoup.org/

    La librería se encarga de descargar la página web y procesar el HTML

    Podremos utilizarla para obtener información sobre una página.


    Otras librerias que procesan HTML
     - http://htmlcleaner.sourceforge.net/javause.php

 */
package Ejemplos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author santiago
 */
public class ParseHTML {
    final static String URL1="http://localhost";
    final static  String URL2="http://huelvainformacion.es";
    //final static  String URL3="http://ieslamarisma.net/aulavirtual";

    final static  String URLSEL=URL2;
    
    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect(URLSEL).get();
        String title = doc.title();

        System.out.println("Titulo de la página: " + title);

        // Mostramos encabezados de tipo h1
        System.out.println("\n\n** ENCABEZADOS H1 de la página ***\n\n");
        Elements h1Tags = doc.getElementsByTag("h1");
        int n = 0;
        for (Element h1Element : h1Tags) {

            String h1Text = h1Element.text();
            if (h1Text.trim().length() == 0) {
                // Omitimos etiquetas sin texto
                continue;
            }
            n++;
            System.out.println(n + "\t" + h1Text);
        }

        // Mostramos enlaces que tiene lá página
        System.out.println("\n\n** Enlaces que tiene la página ***\n\n");
        Elements links = doc.getElementsByTag("a");
        n = 0;
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            n++;
            System.out.println(n + "\t" + linkText + "\n\t    URL: " + linkHref);
        }

        // Mostramos imagenes que contiene
        Elements media = doc.select("[src]");
        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img")) {
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            } else {
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
            }
        }

        // Información sobre recursos que se importan
        Elements imports = doc.select("link[href]");
        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
        }
        
        // Información sobre enlaces
        Elements linksHRef = doc.select("a[href]");
        print("\nLinks: (%d)", links.size());
        for (Element link : linksHRef) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }        
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width) {
            return s.substring(0, width - 1) + ".";
        } else {
            return s;
        }
    }

}
