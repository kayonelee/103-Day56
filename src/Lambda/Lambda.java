package Lambda;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.awt.Color;
import java.util.function.Supplier;
//PRACTICE FROM MODULE-SUPPLIER
//import java.util.function.Supplier;
//import java.util.Random;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {
//Task 1: Simple Lambda.Lambda Expressions

        // SUBTRACTION
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        System.out.println(subtract.apply(10, 4));
        // OUTPUT: 6

        // MULTIPLICATION
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(6, 2));
        // OUTPUT: 12

        // DIVISION
        BinaryOperator<Double> divide = (a, b) -> a / b;
        System.out.println(divide.apply(9.0, 3.0));
        // OUTPUT: 3.0

        //  ADDITION
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        System.out.println(addition.apply(5, 7));
        // OUTPUT: 12


//TASK 2: Lambda.Lambda Expressions with Functional Interfaces
//Create your own functional interfaces and use lambda
// expressions to create instances of them.

        //CUSTOM/(CREATED MATHPLUS) A FUNCTIONAL INTERFACE
        @FunctionalInterface
        interface MathPlus {
            int calculate(int a, int b);
        }

        MathPlus add = (a, b) -> a + b;
        int result = add.calculate(6, 7);
        System.out.println(result);
        // Output: 13

//Task 3: Lambda.Lambda Expressions with Built-in Functional Interfaces
//Use lambda expressions with Java's built-in functional interfaces
// such as Predicate, Function, Consumer, and Supplier.

        //-------PREDICATE FUNCTIONAL INTERFACE-------------------------------
        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        boolean isEven = isEvenPredicate.test(6);
        System.out.println(isEven);
        // Output: true
        //IMPORTED INTERFACE AT THE TOP-(import java.util.function.Predicate;)


        //---------CONVERTER FUNCTIONAL INTERFACE---------------------------

        @FunctionalInterface
        interface Converter<T, R> {
            R convert(T input);
        }

        Converter<String, Integer> stringToIntConverter = str -> Integer.parseInt(str);
        int convertedValue = stringToIntConverter.convert("44");
        System.out.println(convertedValue);  // Output: 44

        //---------CONSUMER FUNCTIONAL INTERFACE------------------------
        @FunctionalInterface
        interface Consumer<T> {
            void accept(T input);
        }

        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("i am not yelling");
        // Output: I AM NOT YELLING


        //----------SUPPLIER FUNCTIONAL INTERFACE-GENERATING RANDOM COLOR
        Supplier<Color> randomColorSupplier = () -> {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            return new Color(red, green, blue);
        };

        Color randomColor = randomColorSupplier.get();

        System.out.println("Your random color is : " + randomColor);
        //IMPORTED INTERFACE AT THE TOP-(import java.awt.Color;)
        //RGB color ranges from 0-255 (256 possible choices for each component)

//-----------------------------------------------

//        --PRACTICE-SUPPLIER EXAMPLE FROM MODULE-PRETTYCOOL----------------------------
//        Supplier<String> randomEmailSupplier = () -> {
//            String alphabet = "abcdefghijklmnopqrstuvwxyz";
//            Random random = new Random();
//            String randomString = IntStream.range(0, 10)
//                    .mapToObj(i -> String.valueOf(alphabet.charAt(random.nextInt(alphabet.length()))))
//                    .collect(Collectors.joining());
//            return randomString + "@example.com";
//        };
//
//        String randomEmail = randomEmailSupplier.get();
//        System.out.println(randomEmail);

    }
}

