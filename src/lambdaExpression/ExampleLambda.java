package lambdaExpression;
//This is functional interface
interface StringFormatter{
    String format(String input);
}
interface Bio{
    void getBio(String input);
}
public class ExampleLambda {
    public static void main(String[] args) {
        StringFormatter formatter = new StringFormatter() {
            @Override
            public String format(String input){
                return input +"*";
            }
        };

        StringFormatter exclamation = (input)->input+"!";// implementation with lambda expression.
        System.out.println(exclamation.format("kaushal"));


        Bio bio = (input)-> System.out.println(input+" I am Engnieer");
        bio.getBio("kaushal");
    }
}
