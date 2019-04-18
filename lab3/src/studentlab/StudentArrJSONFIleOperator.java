package studentlab;

import com.google.gson.*;
import java.io.*;
import studentlab.model.Student;

public class StudentArrJSONFIleOperator {
    private Gson parser;
    private String readFilePath;
    private String writeFilePath;

    public String getReadFilePath() {
        return readFilePath;
    }

    public void setReadFilePath(String readFilePath) {
        this.readFilePath = readFilePath;
    }

    public String getWriteFilePath() {
        return writeFilePath;
    }

    public void setWriteFilePath(String writeFilePath) {
        this.writeFilePath = writeFilePath;
    }

    public StudentArrJSONFIleOperator(String filePath) {
        this(filePath, filePath);
    }

    public StudentArrJSONFIleOperator(String readFilePath, String writeFilePath) {
        this();
        this.readFilePath = readFilePath;
        this.writeFilePath = writeFilePath;
    }

    public StudentArrJSONFIleOperator() {
        parser = new GsonBuilder().setPrettyPrinting().create();
    }

    public void write (Student[] studArr, String filePath) throws IOException {
        String jsonResString = parser.toJson(studArr);
        try(FileWriter fw = new FileWriter(filePath)) {
            fw.write(jsonResString);
        }
    }

    public void write(Student[] obj) throws IOException {
        write(obj, this.writeFilePath);
    }

    public Student[] read(String filePath) throws IOException {
        String jsonString;
        Student[] resArr;
        try(FileInputStream fr = new FileInputStream(filePath)) {
            byte[] byteArr = new byte[fr.available()];
            fr.read(byteArr);
            jsonString = new String(byteArr);
            resArr = parser.fromJson(jsonString, Student[].class);
        }
        return resArr;
    }

    public Student[] read() throws IOException {
        return read(this.readFilePath);
    }

}
