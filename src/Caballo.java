public class Caballo {
    private String avatar;
    private int posicion;

    public Caballo(String avatar) {
        this.avatar = avatar;
        this.posicion = -1;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getPosition() {
        return this.posicion;
    }

    public boolean tryAdvance() {
        if(Math.random() > 0.5) {
            this.posicion = this.posicion + 1;
            return true;
        }
        return false;
    }
}
