import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect implements Closeable {
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Connect(String host, int port) {
        this.socket = getSocket(host, port);
        this.reader = getReader();
        this.writer = getWriter();
    }

    public Connect(ServerSocket server) {
        this.socket = getSocket(server);
        this.reader = getReader();
        this.writer = getWriter();
    }

    public void write(String message) {
        try {
            this.writer.write(message);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read() {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Socket getSocket(String host, int port) {
        try {
            return new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Socket getSocket(ServerSocket server) {
        try {
            return server.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedWriter getWriter() {
        try {
            return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader getReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();
        reader.close();
        socket.close();
    }
}
