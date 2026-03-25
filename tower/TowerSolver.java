package tower;

public class TowerSolver {
    private TowerModel model;

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.height(), 0, 2, 1);
    }

    private void solve(int n, int from, int to, int temp)
    {
        if (n == 0) return;

        solve(n - 1, from, temp, to);
        model.move(from, to);
        solve(n - 1, temp, to, from);
    }
}