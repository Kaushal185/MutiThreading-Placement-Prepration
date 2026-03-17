package Oops.Abstraction;

abstract class Polygon{
    int length;
    int bridth;
    Polygon(){

    }
    Polygon(int length,int bridth){
        this.bridth = bridth;
        this.length = length;
    }
    abstract int getArea();
    int perimeter(){
        return 2*(this.length + this.bridth);
    }
}
class Square extends Polygon{
    int length;
    int bridth;
    Square(int length,int bridth){
        this.length = length;
        this.bridth = bridth;
    }

    int getArea() {
        return length * bridth;
    }
}
public class Hello {

}
