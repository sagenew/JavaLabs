package studentlab.model;

public class Student {
    private String surname;
    private String name;
    private String patronymic;
    private String studentCard;
    private int courseYear;
    private String country;
    private String sex;
    private int rating;
    public Student(){ }
    public Student(String surname, String name, String patronymic, String studentCard, int courseYear, String country, String sex, int rating) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setStudentCard(studentCard);
        setCourseYear(courseYear);
        setCountry(country);
        setSex(sex);
        setRating(rating);
    }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public String getStudentCard() { return studentCard; }
    public void setStudentCard(String studentCard) { this.studentCard = studentCard; }
    public int getCourseYear() { return courseYear; }
    public void setCourseYear(int courseYear) { this.courseYear = courseYear; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String toString() {
        return
                String.format("%-15s", getSurname()) +
                String.format("%-15s", getName()) +
                String.format("%-20s", getPatronymic()) +
                String.format("%-20s", getStudentCard()) +
                String.format("%-10s", getCourseYear()) +
                String.format("%-20s", getCountry()) +
                String.format("%-10s", getSex()) +
                String.format("%-10s", getRating());
    }
}
