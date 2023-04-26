package ojdbc;

public class MemoApplication {
	public static void main(String[] args) throws Exception {
		MemoController controller = new MemoController();
		controller.getMemos();
	}
}
