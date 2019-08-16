package Gym3;

import java.util.*;

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
        String html_body1_begining = "<div style=\"position: relative; display:inline-block; float: left; width: 6%; margin-top:1%;" +
                "margin-left:1%;margin-right:1%; background-color: wheat; border-radius: 2px;height: 75vh;\">\n";
        int columnWidth = (100/parameters.size())-1;
        List<Integer> intParameters = StringListToIntegerList(parameters);
        int biggestValue = Collections.max(intParameters);
        int lowestValue = Collections.min(intParameters)-1;
        Set<Integer> uniqueList = new HashSet<>();
        for (int i = 0; i<parameters.size(); i++){
            uniqueList.add(intParameters.get(i));
        }
        int left = 0;
        StringBuilder html_body1 = new StringBuilder();

        for (int i = 0; i<parameters.size(); i++){
            html_body1.append("<div style=\"position: absolute; bottom: 0px;left: "+left+"px; display:inline-block; float: left; " +
                    "width: 40px; margin:10px; background-color: crimson; border-radius: 6px; text-align: center; font-size: 20px; " +
                    "font-weight: 800;height: "+(((intParameters.get(i)-lowestValue)*70)/(biggestValue-lowestValue))+"vh;\">"
                    +parameters.get(i)+"</div>\n");
            left+=50;
        }
        int left2 = 0;
        String html_body1_ending = "</div>\n";
        StringBuilder html_body2 = new StringBuilder();
        String html_body2_begining = "<div style=\"position: relative; display:inline-block; float: right;; width: 90%; margin-top:1%;" +
                "margin-left:1%;margin-right:1%; background-color: wheat; border-radius: 2px;height: 10vh;\">";

        for (int i = 0; i<parameters.size(); i++){
            html_body2.append("<div style=\"position: absolute; bottom: 0px;left: "+left2+"px; display:inline-block; float: left; width: " +
                    "10vh;text-align: center; margin:10px; background-color: crimson; border-radius: 2px;height: 40px; font-size: 15px; " +
                    "font-weight: 800; transform: rotate(90deg);\">"+selectedDates.get(i)+"</div>\n");
        }
        String html_body2_ending = "</div>\n";
        String html_ending ="</div>\n</body>\n</html>";

        String fullHTML = html_begining+html_body1_begining+html_body1+html_body1_ending+html_body2_begining+
                html_body2+html_body2_ending+html_ending;
        System.out.println();
        return fullHTML;
    }

    private static List<Integer> StringListToIntegerList(List<String>stringList){
        List<Integer> int_parameters = new ArrayList<>();
        for(String s : stringList) int_parameters.add(Integer.valueOf(s));
        return int_parameters;
    }
}
