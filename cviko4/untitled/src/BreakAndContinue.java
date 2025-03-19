public class BreakAndContinue {
    public static void main(String[] args) {
        String[] words = {"ABCD",
                        "EFGH",
                        "ijkl",
                        "MNOP"};

        boolean contains = containsAll(words, new char[]{'A', 'N'});
        System.out.println("constainsAll: " + contains);

        System.out.println("upper case words:");
        printUpperCaseWords(words);
    }

    private static boolean containsAll(String[] text, char[] letters) {
        int counter = 0;
        for(char searchedLetter: letters){
            search:
            for(String word: text){
                for(char type: word.toCharArray()){
                    if(type == searchedLetter){
                        ++counter;
                        break search;
                    }
                }
            }
        }
        return counter == letters.length;
    }

    private static void printUpperCaseWords(String[] text) {
        search:
        for(String word: text){
            for(char letter: word.toCharArray()){
                if(!Character.isUpperCase(letter)){
                    continue search;
                }
            }
            System.out.println(word);
        }
    }
}
