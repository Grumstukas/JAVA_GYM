package JAVA_GYM;

public class WriteCSS {
    public static String geretateCSS(){

        String mainCSS = "/**StyleFile**/\n" +
                "body,\n" +
                "body * {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    vertical-align: top;\n" +
                "    box-sizing: border-box;\n" +
                "}\n" +
                "body{\n" +
                "    background-color: wheat;\n" +
                "}\n" +
                "\n" +
                "header{\n" +
                "    width: 100%;\n" +
                "    text-align: center;\n" +
                "    font-size: 37px;\n" +
                "    line-height: 50px;\n" +
                "    font-weight: 800;\n" +
                "}\n" +
                "img{\n" +
                "    z-index: 1;\n" +
                "    position: absolute;\n" +
                "    right: 62px;\n" +
                "    top: 0px;\n" +
                "    width: 150px;\n" +
                "}\n" +
                ".body{\n" +
                "    display: inline-block;\n" +
                "    float: left;\n" +
                "    width: 90%;\n" +
                "    margin-left: 5%;\n" +
                "    overflow-x: scroll;\n" +
                "     background-color: wheat\n" +
                "}\n" +
                "    .graph{\n" +
                "        position: relative;\n" +
                "        display: inline-block;\n" +
                "        width: 100%;\n" +
                "        margin-top: 3px;\n" +
                "        border-radius: 10px;\n" +
                "    }\n" +
                "    .weight{\n" +
                "        position: absolute;\n" +
                "        display: inline-block;\n" +
                "        float: left;\n" +
                "        bottom: 0px;\n" +
                "        width: 40px;\n" +
                "        margin: 5px 10px;\n" +
                "        background-color: crimson;\n" +
                "        border-radius: 20px 20px 5px 5px;\n" +
                "        font-size: 20px;\n" +
                "        font-weight: 800;\n" +
                "        text-align: center;\n" +
                "        padding-top: 10px;\n" +
                "    }\n" +
                "    .dates{\n" +
                "        position: absolute;\n" +
                "        display: inline-block;\n" +
                "        float: left;\n" +
                "        border-radius: 2px;\n" +
                "        background-color: green;\n" +
                "        bottom: 36px;\n" +
                "        width: 100px;\n" +
                "        text-align: center;\n" +
                "        font-size: 20px;\n" +
                "        line-height: 40px;\n" +
                "        font-weight: 800;\n" +
                "        transform: rotate(270deg);\n" +
                "    }";
        return mainCSS;
    }
}
