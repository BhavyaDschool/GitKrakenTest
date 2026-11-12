public class gitkrackentest {
    public static void main(String[] args) {
        final int nums = 1000000;
        int count = 0;
        for (int number = 1; number <= nums; number++) {
            count++;
        }
        System.out.println("Total numbers counted: " + count);
    }
}