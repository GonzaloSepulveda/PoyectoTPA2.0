package GameEngine;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is used for managing Json files
 */
public class writeJson {
    /***
     * test function for writing/reading Json files
     * @param args
     */
    public static void main(String[] args) {
        int cash = 0 ;
        writeJsonToFileCash(cash);
        readJsonFromFile(cash);
        int carLevel = checkLevel();
        int paint = checkPaint();
        writeJsonToFileColour(paint);
        System.out.println("Car Level: " + carLevel);
        System.out.println("Paint: "+ paint);
    }

    /***
     * Function that is given cash as a parameter, it writes that cash on the Json file
     * @param cash
     */
    public static void writeJsonToFileCash(int cash) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int money = jsonObject.getInt("money");
            jsonObject.put("money", money+cash);
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * Function that is given colour as a parameter, it changes that value on the Json file
     * @param colour
     */
    public static void writeJsonToFileColour(int colour) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int paint = jsonObject.getInt("paint");
            jsonObject.put("paint", colour);
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * Function that reads the paint attribute from the Json file
     * @return  currentPaint
     */
    public static int checkPaint() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int currentPaint = jsonObject.getInt("paint");
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
            return currentPaint;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Example default value
        }
    }

    /***
     * Function that writes the car's level in the Json file when the paramete "lvl" is given to it
     * @param lvl
     */
    public static void writeJsonToFilelvl(int lvl) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int carLevel = jsonObject.getInt("Car level");
            jsonObject.put("Car level", carLevel+lvl);
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * Function that reads the car's current level from the Json file
     * @return currentLevel
     */
    public static int checkLevel() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int currentLevel = jsonObject.getInt("Car level");
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
            return currentLevel;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Example default value
        }
    }
    /***
     * Function that reads the current money from the Json file
     * @return currentMoney
     */
    public static int checkCash() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int currentMoney= jsonObject.getInt("money");
            Files.write(Paths.get("money.json"), jsonObject.toString().getBytes());
            return currentMoney;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Example default value
        }
    }

    /**
     * Primitive function for managing Json files
     * @param cash
     */
    public static void readJsonFromFile(int cash) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("money.json")));
            JSONObject jsonObject = new JSONObject(content);
            int money = jsonObject.getInt("money");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
