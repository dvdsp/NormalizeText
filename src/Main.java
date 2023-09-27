
import controller.TextNormalizer;
import java.io.IOException;




public class Main {
    public static void main(String[] args)  {
       try {
           TextNormalizer.normalizeText("Input.txt", "Output.txt");
       } catch (IOException e) {
           
       }
   }

}