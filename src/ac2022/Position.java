package ac2022;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(String direction) {
        switch (direction) {
            case "R" -> this.x += 1;
            case "L" -> this.x -= 1;
            case "U" -> this.y += 1;
            case "D" -> this.y -= 1;
        }
    }

    public void follow(Position head) {
        int dx = head.x - this.x;
        int dy = head.y - this.y;

        if (Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {
            return;//do nothing, but return to be added to the set
        }

        this.x += Integer.signum(dx);
        this.y += Integer.signum(dy);
    }


    public String asKey() {
        return this.x + "," + this.y;
    }

}
