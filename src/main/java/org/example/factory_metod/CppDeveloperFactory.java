package org.example.factory_metod;

public class CppDeveloperFactory implements DeveloperFactory {

    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
