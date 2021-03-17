package app.appenders.file;

public interface File {
    void write(String message);
    public int getSize();
}
