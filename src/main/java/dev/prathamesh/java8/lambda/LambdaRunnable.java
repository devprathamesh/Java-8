package dev.prathamesh.java8.lambda;

public class LambdaRunnable {
    public static void main(String[] args) {

        // Pre Java 1.8 Implementation of Runnable Interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Legacy Runnable Impl");
            }
        };

        new Thread(runnable).start();

        //Java 1.8 Style 1 Implementation Runnable Interface
        Runnable lambdaStyle1Runnable = () -> {
            System.out.println("Inside Java 1.8 Style 1 Runnable Impl");
        };

        new Thread(lambdaStyle1Runnable).start();

        //Java 1.8 Style 2 Implementation Runnable Interface
        new Thread(() -> {
            System.out.println("Inside Java 1.8 Style 2 Runnable Impl");
        }).start();

        InterfOne exampleOne = (int a, int b) -> {
            System.out.printf("\n Sum %d ", (a + b));
        };

        exampleOne.add(100, 200);

        InterfTwo exampleTwo = (a, b) -> a + b;

        System.out.printf("%d", exampleTwo.add(100, 300));

        InterfThree exampleThree = (a, b) -> {
            System.out.println("Inside Lambda Impl of add Method");
            return (a + b);
        };

        System.out.printf("\n %d ", exampleThree.add(100, 400));

        InterfFour exampleFour = a -> a * a;

        System.out.println("Square " + exampleFour.square(5));

    }

    interface InterfOne {
        void add(int a, int b);
    }

    interface InterfTwo {
      int add(int a, int b);
    }

    interface InterfThree {
        int add(int a, int b);
    }

    interface InterfFour {
        int square(int input);
    }
}


