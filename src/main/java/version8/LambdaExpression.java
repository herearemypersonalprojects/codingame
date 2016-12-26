package version8;

/**
 * Created by qale0001 on 14/12/2016.
 */
public class LambdaExpression {
    interface HelloWorld {
        String sayHello (String name);
    }

    interface HelloWorldWithout {
        String sayHello ();
    }

    interface HelloWorldManyParas {
        String sayHello(String p1, String p2);
    }

    public static void main(String[] args) {

        HelloWorld helloWorld = name -> "Hello " + name;
        System.out.println(helloWorld.sayHello("John"));

        HelloWorld helloWorld1 = (String name) -> { return "Hello " + name; };
        System.out.println(helloWorld1.sayHello("John"));

        HelloWorldWithout helloWorldWithout = () -> {return "Hello nobydy";};
        System.out.println(helloWorldWithout.sayHello());

        HelloWorldManyParas helloWorldManyParas = (p1, p2) -> {return "Hello " + p1 + " : " + p2;};
        System.out.println(helloWorldManyParas.sayHello("mot", "hai"));
    }
}
