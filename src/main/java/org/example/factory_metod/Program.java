package org.example.factory_metod;

public class Program {
    public static void main(String[] args) {

        DeveloperFactory developerFactory = new CppDeveloperFactory();
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }
}


