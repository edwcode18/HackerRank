import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = bufferedReader.readLine();
        String s = "12:45:54PM";
        String result = timeConversion(s);
        System.out.println(result);
        /*
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        */
    }

    public static String timeConversion(String s) {
        // Best solution
        String type = s.substring(s.length() - 2);
        String time = s.substring(0, s.length() - 2);
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        String second = time.split(":")[2];

        if(type.equals("AM")){
            if(hour.equals("12")) hour = "00";
        }else
        if(!hour.equals("12"))
            hour = "" + (Integer.parseInt(hour) + 12);

        return hour + ":" + minute + ":" + second;
        /*
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.parse(s, inputFormatter);

        return time.format(outputFormatter);

         */
    }
}
