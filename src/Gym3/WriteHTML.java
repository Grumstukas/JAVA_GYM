package Gym3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteHTML {
    public static String geretateHTML(List<String> selectedDates, List<String> parameters, String ClientID, String dateFrom, String dateTo) {
        String html_begining = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <link rel=\"shortcut icon\" href=\"img/hero/logo.png\" type=\"image/x-icon\">\n" +
                "    <title>LP459</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<header style=\"width: 98%; height: 10vh;background-color: aliceblue; text-align: center; font-size: 35px;margin-left:1%;margin-right:1%;\">\n" +
                "    Grafiškai pateikiamas kliento " + ClientID + " svorio pokytis nuo " + dateFrom + " iki " + dateTo + ":\n" +
                "</header>\n";
        String html_body1 = "<div style=\"position: relative; display:inline-block; float: left; width: 6%; margin-top:1%;" +
                "margin-left:1%;margin-right:1%; background-color: wheat; border-radius: 2px;height: 85vh;\">\n";
        int columnWidth = (100/parameters.size())-1;
        List<Integer> intParameters = StringListToIntegerList(parameters);
        int biggestValue = Collections.max(intParameters);
        int lowestValue = Collections.min(intParameters)-1;
//        List<Integer> uniqueList =
        int left = 0;


        StringBuilder html_body2 = new StringBuilder();
        for (int i = 0; i<parameters.size(); i++){
            html_body2.append("<div style=\"position: absolute; bottom: 0px;left: "+left+"px; display:inline-block; float: left; " +
                    "width: 20px; margin:10px; background-color: crimson; border-radius: 2px;" +
                    "height: "+(((intParameters.get(i)-lowestValue)*80)/(biggestValue-lowestValue))+"vh;\">"+selectedDates.get(i)+"</div>\n");
            left+=30;
        }
        String html_ending = "</div>\n" +
                "</body>\n" +
                "</html>";
        String fullHTML = html_begining+html_body1+html_body2+html_ending;
        return fullHTML;
    }

    private static List<Integer> StringListToIntegerList(List<String>stringList){
        List<Integer> int_parameters = new ArrayList<>();
        for(String s : stringList) int_parameters.add(Integer.valueOf(s));
        return int_parameters;
    }
}
