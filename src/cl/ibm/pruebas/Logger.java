package cl.ibm.pruebas;

public class Logger {

    private StringBuffer contents = new StringBuffer();
    
    public void log(String message) {
        contents.append(System.currentTimeMillis());
        contents.append(":");
        contents.append(Thread.currentThread().getName());
        contents.append(message);
        contents.append("\n");
    }
    
    public String getContents() {
        return contents.toString();
    }
}
