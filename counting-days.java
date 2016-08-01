public class DaysAlivePrinter
{
    public static void main(String[] args)
    {
        Day birthday = new Day(1951, 5, 26);
        Day death = new Day(2012, 7, 23);
        
        int daysAlive = death.daysFrom(birthday);
        
        System.out.println(daysAlive);
    }
}
