package jf;

/**
 * Hello world!
 *
 */
public class App {
	
	public int max(int a, int b) {
//		return (a > b) ? a : b;
		return a;
	}
	
    public static void main(String[] args)
    {
    	App app = new App();
    	
        System.out.println(app.max(4, 5));
    }
}
