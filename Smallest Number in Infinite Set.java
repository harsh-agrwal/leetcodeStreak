import java.util.TreeSet;

class SmallestInfiniteSet {
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
        }
    }
    public int popSmallest() {
        int smallest = set.first();
        set.remove(smallest);
        return smallest;
    }
    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
        }
    }
}
