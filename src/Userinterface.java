import java.util.Scanner;

abstract class Endowment {
    String endowmentId;
    String holderName;
    String endowmentType;
    String resgistrationDate;

    public Endowment( String endowmentId, String holderName,String endowmentType, String resgistrationDate){
        this.endowmentId=endowmentId;
        this.holderName=holderName;
        this.endowmentType=endowmentType;
        this.resgistrationDate=resgistrationDate;

    }

    public String getEndowmentId() {
        return endowmentId;
    }

    public void setEndowmentId(String endowmentId) {
        this.endowmentId = endowmentId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getEndowmentType() {
        return endowmentType;
    }

    public void setEndowmentType(String endowmentType) {
        this.endowmentType = endowmentType;
    }

    public String getResgistrationDate() {
        return resgistrationDate;
    }

    public void setResgistrationDate(String resgistrationDate) {
        this.resgistrationDate = resgistrationDate;
    }
    public abstract double calculateEndowment();
}
 class EducationalEndowment extends Endowment{
   private String educationalinstitution;
   private String educationalDivision;
    public EducationalEndowment(String endowmentId,String holderName, String endowmentType,
                                String registrationDate, String educationalinstitution,String educationalDivision){
        super(endowmentId,holderName,endowmentType,registrationDate);
        this.educationalinstitution=educationalinstitution;
        this.educationalDivision=educationalDivision;
    }

    public String getEducationalinstitution() {
        return educationalinstitution;
    }

    public void setEducationalinstitution(String educationalinstitution) {
        this.educationalinstitution = educationalinstitution;
    }

    public String getEducationalDivision() {
        return educationalDivision;
    }

    public void setEducationalDivision(String educationalDivision) {
        this.educationalDivision = educationalDivision;
    }

    @Override
    public double calculateEndowment() {
        String ed=educationalDivision.toLowerCase();
        if (ed.equals("school")){
            return 30000;
        }
        else if(ed.equals("undergraduate")){
            return  60000;
        }
        else if (ed.equals("postgraduate")){
            return 90000;
        }
        else {
            return 0;
        }
    }
}

  class HealthEndowment extends Endowment{
    private String healthCareCentre;
    private int holderAge;

     public String getHealthCareCentre() {
         return healthCareCentre;
     }

     public void setHealthCareCentre(String healthCareCentre) {
         this.healthCareCentre = healthCareCentre;
     }

     public int getHolderAge() {
         return holderAge;
     }

     public void setHolderAge(int holderAge) {
         this.holderAge = holderAge;
     }

     public HealthEndowment(String endowmentId , String holderName ,String endowmentType,String resgistrationDate ,
                            String healthCareCentre, int holderAge){
         super(endowmentId,holderName, endowmentType,resgistrationDate);
         this.healthCareCentre=healthCareCentre;
         this.holderAge=holderAge;
     }

      @Override
      public double calculateEndowment() {
         if (holderAge<=30) {
             return 120000;
         } else if (holderAge<60) {
             return 200000;
         }
         else return 500000;
      }

  }
  public class Userinterface{
      public static void main(String[] args) {
          Scanner user=new Scanner(System.in);
          System.out.print("enter your endowment id: ");
          String endowmentId=user.next();
          System.out.print("enter your holder name: ");
          String holderName= user.next();
          System.out.print("enter the endowment type: \n options are: (Educational, Health):-\n");
          String endowmentType=user.next();
          if (endowmentType.equalsIgnoreCase("Educational")){
              System.out.print("enter registration date: ");
              String registrationDate= user.next();
              System.out.print("enter educational institution: ");
              String educationalInstitution=user.next();
              System.out.print("enter educational division:\n option are:- (school,undergraduate,postgraduate):-");
              String educationalDivision=user.next();
              EducationalEndowment ed = new EducationalEndowment(endowmentId, holderName, endowmentType,
                      registrationDate, educationalInstitution, educationalDivision);

              double amount = ed.calculateEndowment();
              System.out.printf("Endowment Amount %.2f", amount);
          } else if (endowmentType.equalsIgnoreCase("Health")) {
              System.out.print("enter registration date: ");
              String registrationDate= user.next();
              System.out.print("enter health CareCentre: ");
              String healthCareCentre=user.next();
              System.out.print("enter holder age : ");
              int holderAge=user.nextInt();
              HealthEndowment ed = new HealthEndowment(endowmentId, holderName, endowmentType,
                      registrationDate, healthCareCentre, holderAge );
              double amount =ed.calculateEndowment();
              System.out.printf("endowment amount %.2f",amount);
          }else {
              System.out.println(endowmentType +"is an invalid endowment type.!!");
          }


      }
  }




