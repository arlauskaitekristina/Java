public class task_01_main {
    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1},
                        {0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 0},
                };

        int min_dist = task_01.findShortestPath(mat, 0, 0, 6, 1);

        if (min_dist != -1) {
            System.out.println("\nКратчайший путь от источника к месту назначения имеет длину: " + min_dist);
        } else {
            System.out.println("Пункт назначения не может быть достигнут");
        }
    }
}