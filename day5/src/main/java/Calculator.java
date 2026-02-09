import java.util.ArrayList;

@FunctionalInterface
interface Calculator {
    int add(int x,int y);
}
@FunctionalInterface
interface ArrayADD{
    int[] arrayadd(int[] x, int y);
}
@FunctionalInterface
interface EvenArrayADD{
    int[] evenarrayadd(int[] x, int y);
}
@FunctionalInterface
interface ThirdArrayADD{
    int thirdarrayadd(int[] x);
}
