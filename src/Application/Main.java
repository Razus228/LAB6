package Application;

import Application.Design.Controller;
import Application.Design.ControllerInterface;

public class Main {
    public static void main(String[] args) {
        ControllerInterface controller = new Controller();
        controller.display();
    }
}