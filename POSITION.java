package homeWork2;

public enum POSITION {

    JUNIOR(5000), //0 -> ordinal pozicia v spiske
    MIDDLE(10000),//1
    SENIOR(20000);//2

    public final int minSalary;
    POSITION( int minSalary){
        this.minSalary = minSalary;
    }
}
