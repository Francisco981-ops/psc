public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Hora inválida: deve estar entre 0 e 23");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Minuto inválido: deve estar entre 0 e 59");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Segundo inválido: deve estar entre 0 e 59");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) {

        Time time1 = new Time(5, 15, 30);
        System.out.println("Hora definida: " + time1); 

        Time time2 = new Time(13, 45, 0);
        System.out.println("Hora definida: " + time2); 

        Time time3 = new Time(23, 59, 59);
        System.out.println("Hora definida: " + time3); 

        Time time4 = new Time(0, 0, 0);
        System.out.println("Hora padrão: " + time4); 
    }
}