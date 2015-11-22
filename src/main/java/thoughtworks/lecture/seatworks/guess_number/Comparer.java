package thoughtworks.lecture.seatworks.guess_number;

import java.util.HashSet;

public class Comparer {

    public Comparer() {

    }

    public String compare(String systemNumber, String userNumber) {
        int numberOfAs = 0, numberOfAsAndBs;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < systemNumber.length(); i++) {
            if (systemNumber.charAt(i) == userNumber.charAt(i)) {
                numberOfAs++;
            }
            set.add(systemNumber.charAt(i));
            set.add(userNumber.charAt(i));
        }

        numberOfAsAndBs = 8 - set.size();

        return numberOfAs + "A" + (numberOfAsAndBs - numberOfAs) + "B";
    }
}
