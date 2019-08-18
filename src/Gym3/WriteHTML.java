package Gym3;

import java.util.*;

public class WriteHTML {
    public static String geretateHTML(List<String> selectedDates, List<String> parameters, String ClientID, String dateFrom, String dateTo, String unit) {
        String change = !unit.equals(" kg") ? "KMI" : "svorio";
        String html_begining = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "    <title>LP459</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<header>\n" +
                "    Kliento "+ClientID+" "+change+" pokytis nuo "+dateFrom+" iki "+dateTo+":\n" +
                "</header>\n" +
                "<img src=\"../../javaGymLogo.png\" alt=\"\">\n" +
                "<div class=\"body\">\n";

        String html_body1_begining = "<div class=\"graph\" style=\"height: 70vh\">\n";
        String html_body2_begining = "<div class=\"graph\" style=\"height: 17vh;\">\n";

        List<Double> double_parameters = StringListToIntegerList(parameters);
        double biggestValue = Collections.max(double_parameters);
        double lowestValue = Collections.min(double_parameters)-5;

        int left1 = 0;
        int left2 = -20;
        int fontSize = !unit.equals(" kg") ? 17 : 20;
        StringBuilder html_body1 = new StringBuilder();
        StringBuilder html_body2 = new StringBuilder();

        for (int i = 0; i<parameters.size(); i++){
            html_body1.append("<div class=\"weight\" style=\"left: "+left1+"px; font-size:"+fontSize+"px;" +
                    "height: "+(((double_parameters.get(i)-lowestValue)*68)/(biggestValue-lowestValue))+"vh;\">"+parameters.get(i)+"<br>"+unit+"</div>\n");
            html_body2.append("<div class=\"dates\" style=\"left: "+left2+"px;\">"+selectedDates.get(i)+"</div>");

            left1+=50;
            left2+=50;
        }

        String html_body1_ending = "</div>\n";
        String html_body2_ending = "</div>\n";

        String html_ending ="</div>\n</body>\n</html>";

        String fullHTML = html_begining+
                                        html_body1_begining+html_body1+html_body1_ending+
                                        html_body2_begining+ html_body2+html_body2_ending+
                                        html_ending;
        return fullHTML;
    }

    private static List<Double> StringListToIntegerList(List<String>stringList){
        List<Double> double_parameters = new ArrayList<>();
        for(String s : stringList) double_parameters.add(Double.valueOf(s));
        return double_parameters;
    }
}
