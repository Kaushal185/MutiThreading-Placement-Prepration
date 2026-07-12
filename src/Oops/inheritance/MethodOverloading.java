package Oops.inheritance;

public class MethodOverloading {
    int add(int a,int b){
        return a + b;
    }
    int add(int a, int b, int c){
        return a+b+c;
    }
    double add(double a,int b){
        return a + b;
    }
/*
    compilation error
    String add(int a,int b){
        return ""+a+b;
    }
 */
    public static void main(String[] args) {
        //This is method overloading
                /*
                A few key rules for method overloading:
                Method name must be the same.
                Parameter list must be different (type, number, or order).
                Return type alone cannot differentiate overloaded methods.
                It is resolved at compile time, not runtime.

                Yes. In Java, you cannot overload a method by changing only the return type. The parameter list must be different;
                otherwise the compiler cannot determine which method to call.

                Consider this example:

                class Test {

                    int add(int a, int b){
                        return a + b;
                    }

                    double add(int a, int b){
                        return a + b;
                    }
                }

                This code will produce a compile-time error.
                Even though the return types are different (int and double),
                the method name and parameters are identical: add(int, int).
                The Java compiler decides which overloaded method to call based on the parameters,
                not the return type. Because the parameters are the same,
                the compiler sees these methods as duplicate methods.
                The compiler error typically looks like:
                method add(int,int) is already defined in class Test
                 */
        MethodOverloading methodOverloading= new MethodOverloading();
        System.out.println(methodOverloading.add(10,20));
        System.out.println(methodOverloading.add(10,15,20));
        System.out.println(methodOverloading.add(20.5,31));
    }
}
