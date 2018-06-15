import java.util.HashMap;
import java.util.Map;

public class HashmatiqueTest{
  public static void main(String[] args){
    Map<String, String> trackList = new HashMap<String, String>();
    trackList.put("Heights","We are really high up in the sky. Never coming back down");
    trackList.put("Karmaprana", "Dance doo da doo da doo, dance dance dance...");
    trackList.put("You and Me", "It's just you and me baby. ooooooh.");
    trackList.put("Tailwhip", "My dog's got the craziest tail.  She wags it so fast, it hurts. ba da ba da ba boppity bop.");
    
    System.out.println(trackList.get("You and Me"));
   
    trackList.forEach((k,v)->System.out.println(k + ": " + v));
  }

}