public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vec;
    private int row, col;
    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d;
        row = 0;
        col = 0;
    }

    @Override
    public Integer next() {
        List<Integer> list = vec.get(row);
        while (list.size() == 0 && row < vec.size() - 1) {
            list = vec.get(++row);
        }

        int res = list.get(col++);
        if (col == list.size()) {
            col = 0;
            row++;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if (row >= vec.size()) return false;
        List<Integer> list = vec.get(row);
        while (list.size() == 0 && row < vec.size() - 1) {
            list = vec.get(++row);
        }
        return row < vec.size() && col < vec.get(row).size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
