import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            String[] listTulisan = new String[100];
            reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            System.out.println("Isi file");
            int index = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                listTulisan[index++] = line;
            }

            System.out.println("\nIsi array secara langsung:");
            for (int i = 0; i < index; i++) {
                System.out.println("Array[" + i + "]: " + listTulisan[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan saat menutup file: " + e.getMessage());
                }
            }
        }
    }
}