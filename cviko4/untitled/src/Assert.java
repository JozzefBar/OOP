public class Assert {
    public static void main(String[] args) {
        System.out.println(averageSpeed(10, 10, 20, 20));
        System.out.println(averageSpeed(20, 20, 25, 30));
        System.out.println(averageSpeed(5, 10, 5, 20));
    }

    private static double averageSpeed(int startTime, int startPosition, int endTime, int endPosition) {
        assert endTime > startTime : "zaciatocny cas musi byt mensi ako koncovy";

        return (double)(endPosition - startPosition) / (double)(endTime - startTime);
    }
}
