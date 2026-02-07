package Oops.pkg;
import Oops.pkg.pkg2.Cat;

public class PackagesEx {
    public static void main(String[] args) {
        Oops.pkg.pkg1.Cat cat = new Oops.pkg.pkg1.Cat();
        Cat cat2 = new Cat();// it is Cat from pkg2
    }
}
