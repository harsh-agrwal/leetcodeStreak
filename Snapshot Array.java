
class SnapshotArray {
    private List<TreeMap<Integer, Integer>> array;
    private int snapId;

    public SnapshotArray(int length) {
        array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(new TreeMap<>());
            array.get(i).put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        array.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> history = array.get(index);
        return history.floorEntry(snapId).getValue();
    }
}
