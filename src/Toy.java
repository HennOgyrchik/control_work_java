public class Toy implements Comparable<Toy>{
    private static int id=0;
    private String title;
    private int count;
    private double weight;

    public Toy(String title, int count, double weight) {
        if ((weight>=0)&&(weight<=1.0)){
            this.weight = weight;
        }else {
            throw new IncorrectWeightValueException();
        }
        this.id=id++;
        this.title = title;
        this.count = count;

    }

    public static int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy o) {
        return Double.compare(o.weight, weight);

    }

    @Override
    public String toString() {
        return title+": "+weight;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
