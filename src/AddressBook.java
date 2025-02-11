import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        ArrayList<Person> addressBook = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean isDone = false;
        while(!isDone) {
            System.out.println("""
                    The Address Book:
                    (1) Add People
                    (2) Search Person
                    (3) Exit
                    """);

            int userInput = input.nextInt();
            input.nextLine();
            switch(userInput) {
                case 1: addPerson(input, addressBook);
                break;
                case 2: search(input, addressBook);
                break;
                case 3:
                    System.out.println("Closing the address book.");
                    isDone = true;
                break;
                default:
                    System.out.println("Not a valid selection.");
            }
        }
    }

    static void addPerson(Scanner input, ArrayList<Person> book) {
        boolean done = false;
        while(!done) {
            System.out.println("Enter a name:");
            String name = input.nextLine();
            System.out.println("Enter an email address:");
            String email = input.nextLine();

            book.add(new Person(name, email));

            System.out.println("Are you done filling your address book? (Y/N)");
            String doneInput = input.nextLine();
            if(doneInput.equalsIgnoreCase("Y")) {
                done = true;
            }
        }
    }

    static void search(Scanner input, ArrayList<Person> book) {
        System.out.println("Who would you like to look up?");
        String name = input.nextLine();
        boolean isFound = false;

        for (Person person : book) {
            if(name.equalsIgnoreCase(person.getName())) {
                System.out.printf("%s's email address is %s.\n", person.getName(), person.geteMail());
                isFound = true;
            }
        }
        if(!isFound) {
            System.out.printf("After checking through the records of %d people in your address book, %s cannot be found!\n",
                    book.size(), name);
        }
    }
}