import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class MyMain {

    public static void main(String[] args) {
        System.out.println("Hello from main");

        Pair<String, String> myPair = new ImmutablePair<String, String>("student_module", "Ana");
        System.out.println(myPair.getLeft() + " is " + myPair.getRight());

//        GaussianRandomGenerator gaussianRandomGenerator = new GaussianRandomGenerator(new JDKRandomGenerator());
//        System.out.println("Your next double is " + gaussianRandomGenerator.nextNormalizedDouble());

    }
}
