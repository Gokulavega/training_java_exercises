package training_java_question689;

public class StaticInitializeOrder 
{
   public static final String place;
   
   public static final int pincode = 600045;
     static
     {
      place = "Tambaram";
      System.out.println(place);
      System.out.println(pincode);
     }
//   public static final int pincode = 600045;
   public static void main(String[] args)
   {
    StaticInitializeOrder sio =
               new StaticInitializeOrder();
   }
}

