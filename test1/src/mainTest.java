public class mainTest {

    public static void main(String Args[])
    {
        //GameController gameController = new GameController();
        Frame frame = new Frame();
        GameController gameController = new GameController();
        frame.getContentPane().add(gameController);
        gameController.addToFrame();
        frame.setVisible(true);

    }
}
