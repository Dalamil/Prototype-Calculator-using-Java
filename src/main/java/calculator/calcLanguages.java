
package calculator;

public class calcLanguages {

    
    public static String svenska1 = "Radera";
    public static String svenska2 = "Rensa";
    
    public static String suomi1 = "Poista";
    public static String suomi2 = "Tyhjennä";
    
    
    // Svenska
    public static String Svenska(String translate)
    {
        if(translate.equals("svenska1"))
        {
            return svenska1;
        }
        else
        {
            return svenska2;
        }
    }
            
            
            
    // Suomi
    public static String Suomi(String translate){
        if(translate.equals("suomi1"))
        {
            return suomi1;
        }
        else
        {
            return suomi2;
        }            
            
    }


}