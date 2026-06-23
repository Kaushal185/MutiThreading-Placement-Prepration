package SystemDesign.singletonDesignPattern;

class Samosa{
    private static Samosa samosa;
    private Samosa(){

    }
    //static block will initialze ojbect
    public static Samosa getSamosa(){
        if(samosa == null){
            synchronized(Samosa.class){
                samosa = new Samosa();// only blocking shared variable using synchronized block.
            }
        }
        return samosa;
    }
}
class Jalebi{
    private static Jalebi jalebi;
    private Jalebi(){

    }
}
public class SDP {
    public static void main(String[] args) {
        Samosa samosa1 = Samosa.getSamosa();
        Samosa samosa2 = Samosa.getSamosa();
        System.out.println(samosa1.equals(samosa2));
        System.out.println(samosa1.hashCode() +"  "+ samosa2.hashCode());
    }
}
