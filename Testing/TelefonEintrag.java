package testing;


public class TelefonEintrag {
    private String number;
    private String name;

    
    public TelefonEintrag(String name, String number) {
   	 this.name = name;
   	 this.number = number;
    }
    
    @Override
    public String toString() {
   	 return "Name: " + this.name + " Nummer: " + this.number;
    }
    
    
    public String getNumber() {
   	 return this.number;
    }
    
    
    public String getName() {
   	 return this.name;
    }
    
    
    public void setNumber(String number) {
   	 this.number = number;
    }
    
    
    public void setName(String name) {
   	 this.name = name;
    }
}

