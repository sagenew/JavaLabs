package studentlab;

public class DataSource {
    public static Student[] getSource() {
        Student[] studArr = new Student[10];
        studArr[0] = new Student("Sagenew", "Eugene", "Rostyslavowych", "ID1488", 2, "Russia", "Male", 60);
        studArr[1] = new Student("Aisingioro", "Pu", "I", "ID1918", 3, "Qing Empire", "Male", 95);
        studArr[2] = new Student("Sioux", "Siouxsie", "Janet", "ID9395", 4, "United Kingdom", "Female", 86);
        studArr[3] = new Student("Curtis", "Ian", "Kevin", "ID1313", 1, "Ukraine", "Male", 70);
        studArr[4] = new Student("Agnew", "Spiro", "Theodore", "ID21st", 2, "USA", "Male", 99);
        studArr[5] = new Student("Dowhopolyuk", "Roman", "Ruslanowych", "IP7109", 2, "Ukraine", "Male", 100);
        studArr[6] = new Student("Nixon", "Richard", "Milhous", "ID1968", 2, "USA", "Male", 60);
        studArr[7] = new Student("Poroshenko", "Peter", "Olexiyowich", "ID2014", 2, "Ukraine", "Male", 100);
        studArr[8] = new Student("Byrne", "David", "Tom", "ID1991", 3, "USA", "Male", 90);
        studArr[9] = new Student("Zhmyshenko", "Valeriy", "Albertowych", "ID228", 6, "Ukraine", "Male", 0);
        return studArr;
    }
}
