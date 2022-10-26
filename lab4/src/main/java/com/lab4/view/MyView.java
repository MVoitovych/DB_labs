package com.lab4.view;

import com.lab4.controller.*;
import com.lab4.controller.impl.*;
import com.lab4.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Component
public class MyView {

    @Autowired
    private CallController callController;
    @Autowired
    private DepartureController departureController;
    @Autowired
    private DepartureFireCarController departureFireCarController;
    @Autowired
    private DepartureFiremanController departureFiremanController;
    @Autowired
    private FireCarController fireCarController;
    @Autowired
    private FiremanController firemanController;

    private Map<String, String> menu;

    private Map<String, Printable> methodsMenu;
    private Scanner input = new Scanner(System.in);
    private Call nullCall = new Call(null, null, null);
    private Departure nullDeparture = new Departure(null, null);
    private DepartureFireCar nullDepartureFireCar = new DepartureFireCar(null, null);
    private DepartureFireman nullDepartureFireman = new DepartureFireman(null, null);
    private Fireman nullFireman = new Fireman(null, null, null);
    private FireCar nullFireCar = new FireCar(null, null);


    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Call");
        menu.put("11", "  11 - Create Call");
        menu.put("12", "  12 - Update Call");
        menu.put("13", "  13 - Delete from Call");
        menu.put("14", "  14 - Find all Call");
        menu.put("15", "  15 - Find Call by ID");

        menu.put("2", "   2 - Table: Departure");
        menu.put("21", "  21 - Create Departure");
        menu.put("22", "  22 - Update Departure");
        menu.put("23", "  23 - Delete from Departure");
        menu.put("24", "  24 - Find all Departure");
        menu.put("25", "  25 - Find Departure by ID");

        menu.put("3", "   3 - Table: DepartureFireCar");
        menu.put("31", "  31 - Create DepartureFireCar");
        menu.put("32", "  32 - Update DepartureFireCar");
        menu.put("33", "  33 - Delete from DepartureFireCar");
        menu.put("34", "  34 - Find all DepartureFireCar");
        menu.put("35", "  35 - Find DepartureFireCar by Departure ID, FireCar ID");

        menu.put("4", "   4 - Table: DepartureFireman");
        menu.put("41", "  41 - Create DepartureFireman");
        menu.put("42", "  42 - Update DepartureFireman");
        menu.put("43", "  43 - Delete from DepartureFireman");
        menu.put("44", "  44 - Find all DepartureFireman");
        menu.put("45", "  45 - Find DepartureFireman by Departure ID, Fireman ID");

        menu.put("5", "   5 - Table: FireCar");
        menu.put("51", "  51 - Create FireCar");
        menu.put("52", "  52 - Update FireCar");
        menu.put("53", "  53 - Delete from FireCar");
        menu.put("54", "  54 - Find all FireCar");
        menu.put("55", "  55 - Find FireCar by ID");

        menu.put("6", "   6 - Table: Fireman");
        menu.put("61", "  61 - Create Fireman");
        menu.put("62", "  62 - Update Fireman");
        menu.put("63", "  63 - Delete from Fireman");
        menu.put("64", "  64 - Find all Fireman");
        menu.put("65", "  65 - Find Fireman by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createCall);
        methodsMenu.put("12", this::updateCall);
        methodsMenu.put("13", this::deleteFromCall);
        methodsMenu.put("14", this::findAllCalls);
        methodsMenu.put("15", this::findCallById);


        methodsMenu.put("21", this::createDeparture);
        methodsMenu.put("22", this::updateDeparture);
        methodsMenu.put("23", this::deleteFromDeparture);
        methodsMenu.put("24", this::findAllDepartures);
        methodsMenu.put("25", this::findDepartureById);


        methodsMenu.put("31", this::createDepartureFireCar);
        methodsMenu.put("32", this::updateDepartureFireCar);
        methodsMenu.put("33", this::deleteFromDepartureFireCar);
        methodsMenu.put("34", this::findAllDepartureFireCars);
        methodsMenu.put("35", this::findDepartureFireCarById);


        methodsMenu.put("41", this::createDepartureFireman);
        methodsMenu.put("42", this::updateDepartureFireman);
        methodsMenu.put("43", this::deleteFromDepartureFireman);
        methodsMenu.put("44", this::findAllDepartureFireman);
        methodsMenu.put("45", this::findDepartureFiremanById);


        methodsMenu.put("51", this::createFireCar);
        methodsMenu.put("52", this::updateFireCar);
        methodsMenu.put("53", this::deleteFromFireCar);
        methodsMenu.put("54", this::findAllFireCar);
        methodsMenu.put("55", this::findFireCarById);


        methodsMenu.put("61", this::createFireman);
        methodsMenu.put("62", this::updateFireman);
        methodsMenu.put("63", this::deleteFromFireman);
        methodsMenu.put("64", this::findAllFireman);
        methodsMenu.put("65", this::findFiremanById);


    }

    private void selectAllTable() {
        findAllCalls();
        findAllDepartures();
        findAllDepartureFireCars();
        findAllDepartureFireman();
        findAllFireCar();
        findAllFireman();
    }

    private void createCall() {
        System.out.println("Input 'short_description': ");
        String short_description = input.nextLine();
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));
        Call call = new Call(null, short_description, departureId);

        int count = callController.create(call);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCall() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'short_description': ");
        String short_description = input.nextLine();
        System.out.println("Input new 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));
        Call call = new Call(null, short_description, departureId);

        int count = callController.update(id, call);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCall() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = callController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCalls() {
        System.out.println("\nTable: Call");
        List<Call> calls = callController.findAll();
        for (Call call : calls) {
            System.out.println(call);
        }
    }

    private void findCallById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Call> call = callController.findById(id);
        System.out.println(call.orElse(nullCall));
    }
    //____________-------------____________-------------____________//

    private void createDeparture() {
        System.out.println("Input 'short_description': ");
        String short_description = input.nextLine();
        Departure departure = new Departure(null, short_description);

        int count = departureController.create(departure);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDeparture() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'short_description': ");
        String short_description = input.nextLine();
        Departure departure = new Departure(null, short_description);

        int count = departureController.update(id, departure);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromDeparture() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = departureController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDepartures() {
        System.out.println("\nTable: Departure");
        List<Departure> departures = departureController.findAll();
        for (Departure departure : departures) {
            System.out.println(departure);
        }
    }

    private void findDepartureById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Departure> departure = departureController.findById(id);
        System.out.println(departure.orElse(nullDeparture));
    }

    //____________-------------____________-------------____________//

    private void createDepartureFireCar() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'firecar_id': ");
        Integer fireCarId = Integer.valueOf((input.nextLine()));

        DepartureFireCar departureFireCar = new DepartureFireCar(departureId, fireCarId);

        String count = departureFireCarController.create(departureFireCar);
        System.out.printf(count);
    }

    private void updateDepartureFireCar() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'firecar_id': ");
        Integer fireCarId = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'departure_id': ");
        Integer newDepartureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'firecar_id': ");
        Integer newFireCarId = Integer.valueOf((input.nextLine()));

        DepartureFireCar departureFireCar = new DepartureFireCar(newDepartureId, newFireCarId);

        System.out.printf(departureFireCarController.update(departureId, fireCarId, departureFireCar));
    }

    private void deleteFromDepartureFireCar() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fireman_id': ");
        Integer fireManId = Integer.valueOf((input.nextLine()));


        System.out.printf(departureFireCarController.delete(departureId, fireManId));
    }

    private void findAllDepartureFireCars() {
        System.out.println("\nTable: DepartureFireCar");
        List<DepartureFireCar> departureFireCars = departureFireCarController.findAll();
        for (DepartureFireCar departureFireCar : departureFireCars) {
            System.out.println(departureFireCar);
        }
    }

    private void findDepartureFireCarById() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'firecar_id': ");
        Integer fireCarId = Integer.valueOf((input.nextLine()));

        Optional<DepartureFireCar> departureFireCar = departureFireCarController.findById(departureId, fireCarId);
        System.out.println(departureFireCar.orElse(nullDepartureFireCar));
    }

    //____________-------------____________-------------____________//


    private void createDepartureFireman() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fireman_id': ");
        Integer firemanId = Integer.valueOf((input.nextLine()));

        DepartureFireman departureFireman = new DepartureFireman(firemanId, departureId);

        String count = departureFiremanController.create(departureFireman);
        System.out.printf(count);
    }

    private void updateDepartureFireman() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fireman_id': ");
        Integer fireManId = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'departure_id': ");
        Integer newDepartureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'fireman_id': ");
        Integer newFireManId = Integer.valueOf((input.nextLine()));

        DepartureFireman departureFireman = new DepartureFireman(newDepartureId, newFireManId);

        System.out.printf(departureFiremanController.update(departureId, fireManId, departureFireman));
    }

    private void deleteFromDepartureFireman() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'firecar_id': ");
        Integer fireManId = Integer.valueOf((input.nextLine()));

        System.out.printf(departureFiremanController.delete(departureId, fireManId));
    }

    private void findAllDepartureFireman() {
        System.out.println("\nTable: DepartureFireman");
        List<DepartureFireman> departureFiremen = departureFiremanController.findAll();
        for (DepartureFireman departureFireman : departureFiremen) {
            System.out.println(departureFireman);
        }
    }

    private void findDepartureFiremanById() {
        System.out.println("Input 'departure_id': ");
        Integer departureId = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'fireman_id': ");
        Integer firemanId = Integer.valueOf((input.nextLine()));

        Optional<DepartureFireman> departureFireman = departureFiremanController.findById(departureId, firemanId);
        System.out.println(departureFireman.orElse(nullDepartureFireman));
    }


    //____________-------------____________-------------____________//


    private void createFireCar() {
        System.out.println("Input 'mark': ");
        String mark = input.nextLine();
        FireCar fireCar = new FireCar(null, mark);

        int count = fireCarController.create(fireCar);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFireCar() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'new mark': ");
        String mark = input.nextLine();
        FireCar fireCar = new FireCar(null, mark);

        int count = fireCarController.update(id, fireCar);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromFireCar() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = fireCarController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllFireCar() {
        System.out.println("\nTable: FireCar");
        List<FireCar> fireCars = fireCarController.findAll();
        for (FireCar fireCar : fireCars) {
            System.out.println(fireCar);
        }
    }

    private void findFireCarById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<FireCar> fireman = fireCarController.findById(id);
        System.out.println(fireman.orElse(nullFireCar));
    }
    //____________-------------____________-------------____________//

    private void createFireman() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'surname': ");
        String surname = input.nextLine();
        Fireman fireman = new Fireman(null, name, surname);

        int count = firemanController.create(fireman);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFireman() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'new name': ");
        String name = input.nextLine();
        System.out.println("Input 'new surname': ");
        String surname = input.nextLine();
        Fireman fireman = new Fireman(null, name, surname);

        int count = firemanController.update(id, fireman);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromFireman() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = firemanController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllFireman() {
        System.out.println("\nTable: Fireman");
        List<Fireman> firemans = firemanController.findAll();
        for (Fireman fireman : firemans) {
            System.out.println(fireman);
        }
    }

    private void findFiremanById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Fireman> fireman = firemanController.findById(id);
        System.out.println(fireman.orElse(nullFireman));
    }


    //____________-------------____________-------------____________//

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

}
