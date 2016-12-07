import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by quocanh on 04/12/2016.
 */
public class Training {
    static boolean exists(int[] ints, int k) {
        Arrays.sort(ints);
       return (Arrays.binarySearch(ints, k) > -1);
    }

    public static void main(String[] args) {

    }

    static String locateUniverseFormula() {
        String filename = "universe-formula";
        String dir = "/tmp/documents";
        Stack<String> stack = new Stack<>();
        stack.push(dir);
        while (!stack.isEmpty()) {
            File file = new File(stack.pop());
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().equals(filename)) {
                    return listOfFiles[i].getAbsolutePath();
                } else
                if (listOfFiles[i].isDirectory()) {
                    stack.push(listOfFiles[i].getAbsolutePath());
                }

            }
        }
        return null;
    }
}
/*

preview
CODETRIAL20:00add

preview
Approximation of π
CODESTANDARD12:00add

preview
Pyramid
CODEEXPERT30:00add

preview
The Kariakoo dancer
CODEEXPERT30:00add

preview
Hack PayPaul!
CODEEXPERT120:00add

preview
Memory leak on a stack
CODEEXPERT15:00add

preview
From the fruit we know the tree
CODESTANDARD25:00add

preview
File finder
CODESTANDARD30:00add

preview
Move towards zero
CODESTANDARD15:00add

preview
ASCII Art (simple)
CODESTANDARD10:00add

preview
Combination options in a tournament
CODESTANDARD15:00add

preview
Threads communication
CODEEXPERT12:00add

preview
String parser
CODEEXPERT30:00add

preview
Giving Change
CODESTANDARD40:00add

preview
Largest wins from chaos
CODESTANDARD05:00add

preview
Simple fix
 */

/*
JAVA LANGUAGE
Inner class
MCQEXPERT00:30add

preview
Size of a HashSet
MCQEXPERT00:30add

preview
HashMap
MCQEXPERT00:45add

preview
Hashcode and equals
MCQEXPERT00:30add

preview
Multiple inheritance of interfaces
MCQSTANDARD00:30add

preview
Constant
MCQSTANDARD00:25add

preview
JDBC ResultSet
MCQEXPERT00:40add

preview
Thread
MCQSTANDARD00:20add

preview
Strings
CODESTANDARD02:30add

preview
InputStream
MCQEXPERT00:20add

preview
Hash table
MCQSTANDARD02:30add

preview
Date
TEXTEXPERT00:35add

preview
Counter synchronization
CODESTANDARD02:00add

preview
Enum
MCQSTANDARD00:30add

preview
SQL Injection
TEXTEXPERT00:40add

preview
Secure closure of an I/O stream
CODESTANDARD05:00add

preview
Multiple inheritance
MCQSTANDARD00:20add

preview
BigInteger is immutable
MCQEXPERT00:25add

preview
Simple boolean expression
CODESTANDARD02:00add

preview
Interfaces
MCQSTANDARD00:20add

preview
String object
MCQSTANDARD00:20add

preview
Object class
MCQSTANDARD00:20add

preview
Immutable object using a Date
CODEEXPERT06:00add

preview
I/O read
MCQEXPERT00:20add

preview
Proxy
TEXTEXPERT00:35add

preview
Size of an ArrayList
MCQSTANDARD00:30add

preview
Outer class
MCQEXPERT00:30add

preview
Bitwise Operator: >>
MCQSTANDARD00:20add

preview
ObjectOutputStream
TEXTEXPERT00:40add

preview
HTTP communication
 */

/*
DESIGN

preview
TEXTTRIAL01:00add

preview
« friendly » class
MCQSTANDARD00:20add

preview
Empty array or null?
MCQEXPERT00:30add

preview
The Dependency Inversion Principle (DIP)
MCQSTANDARD00:45add

preview
Design pattern 02
CODEEXPERT25:00add

preview
Inheritance
CODESTANDARD02:00add

preview
Design pattern 05
TEXTEXPERT01:00add

preview
The Open Closed Principle (OCP)
MCQEXPERT00:45add

preview
Inheritance
MCQSTANDARD01:00add

preview
The Liskov Substitution Principle (LSP)
MCQSTANDARD00:45add

preview
The Single Responsibility Principle (SRP)
MCQEXPERT00:20add

preview
Abstraction
CODESTANDARD08:00add

preview
Test Driven Development (TDD)
MCQEXPERT01:00add

preview
Design pattern 01
TEXTSTANDARD00:50add

preview
Design pattern 04
TEXTEXPERT03:00add

preview
Interface vs. implementation
MCQSTANDARD00:30add

preview
Design pattern 03
TEXTEXPERT02:00add

preview
Use of exceptions
 */