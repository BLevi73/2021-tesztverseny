package hu.testathlon;

import hu.testathlon.controller.TestService;
import hu.testathlon.model.service.Console;
import hu.testathlon.model.service.DataApi;
import hu.testathlon.model.service.DataParser;
import hu.testathlon.model.service.FileReader;

import java.util.Scanner;

public class App {

    private final TestService service;
    private final Console console;

    private App() {
        DataApi dataApi = new DataApi("valaszok.txt", new FileReader(), new DataParser());
        service = new TestService(dataApi.createValidator(), dataApi.getData());
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása");
        System.out.println("2. feladat: A vetélkedőn " + service.countCompetitors() + " versenyző indult.");
        System.out.print("3. feladat: A versenyző azonosítója = ");
        String id = console.read();
        System.out.println(service.getAnswersById(id) + "\t(a versenyző válasza)");
        System.out.println("4. feladat:");
        System.out.println(service.getCorrectAnswers() + "\t(a helyes megoldás)");
    }
}
