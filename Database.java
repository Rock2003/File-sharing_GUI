public class Database {

   final static String DATABASE = "\\\\YOUSSEF\\Server";
   
   
   public static void main(String[] args){
	  SecurityGUI g = new SecurityGUI();
	  while(!g.isSecure()) {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	  }
	  new WorkGUI();
   }
}