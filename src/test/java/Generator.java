import java.util.*;

public class Generator {

    public static void main(String[] args) {

        for(int i=0; i < 5; i++) {

            CharSequence name1 = generateName();
            System.out.println("Name1: " + name1);
            CharSequence name2 = generateName();
            System.out.println("Name2: " + name2);
            System.out.println("E-mail: " + generateEmail(name1, name2));
            System.out.println("-------------------------------");

        }

    }


    public static CharSequence generate() {

        int length = (int)(Math.random() * 10) + 10;
        char st[] = new char[length];

        for(int i=0; i < length; i++) {

            byte rand = (byte)(Math.random() * 64);
            if(rand >= 0 && rand < 10) st[i] = (char)('0' + rand);
            if(rand >= 10 && rand < 36) st[i] = (char)('a' + rand - 10);
            if(rand >= 36 && rand < 62) st[i] = (char)('A' + rand - 36);
            if(rand == 63) st[i] = '_';

        }

        return new String(st);

    }


    public static CharSequence generateName() {

        char letters[][] = new char[2][];
        char consonants[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
        char vowels[] = {'a', 'e', 'i', 'o', 'u', 'y'};
        letters[0] = consonants;
        letters[1] = vowels;
        int vowelStreak = 0, consonantStreak = 0;

        int nameLen = (int)(Math.random() * 6  + 3);
        char name[] = new char[nameLen];

        for(int i=0; i < nameLen; i++) {

            double vowelChance = 0.5;
            if(vowelStreak > 0) {vowelChance -= vowelStreak * 0.25;}
            if(consonantStreak > 0) {vowelChance += consonantStreak * 0.25;}

            int letterType = (int)(Math.random() + vowelChance);
            name[i] = letters[letterType][ (int)(Math.random() * letters[letterType].length) ];

            if(letterType == 0) {	// this letter is chosen to be consonant

                consonantStreak++;
                vowelStreak = 0;

            } else {	// ~ vowel

                consonantStreak = 0;
                vowelStreak++;

            }

        }

        return new String(name);

    }


    public static CharSequence generateEmail() {

        return generate() + "@" + generate().subSequence(0,6) + "." + generate().subSequence(0,2);

    }


    public static CharSequence generateEmail(CharSequence name1, CharSequence name2) {

        String[] domains = {"gmail.com", "mail.ru", "yahoo.com", "yandex.ru", "protonmail.com"};
        return new StringBuilder(name1).append(Math.random() > 0.5 ? '_' : "").append(name2).append(Math.random() > 0.5 ? '_' : "").append((int)(Math.random()*1000)).append('@').append(domains[(int)(Math.random() * domains.length)]);

    }

}