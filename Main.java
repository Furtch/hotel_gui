/*public class Main {
    public static void main(String[] args) {
        new GUI();
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String name = NameInputDialog.showDialog(null);

        new MainApplication(name);
    }
}
