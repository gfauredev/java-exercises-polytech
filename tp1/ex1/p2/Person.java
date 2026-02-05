package tp1.ex1.p2;

class Person {
    private String nom;
    private String prénom;
    private int age;
    private boolean isÉtudiantPolytech;

    public Person(String nom, String prénom, int age, boolean isÉtudiantPolytech) {
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.isÉtudiantPolytech = isÉtudiantPolytech;
    }

    public void addOneYearToAge() {
        this.age++;
    }

    public String toString() {
        return "Je suis " + prénom + " " + nom + ", j’ai " +
                age + " ans, je " +
                (isÉtudiantPolytech ? "suis" : "ne suis pas") +
                " étudiant à Polytech";
    }

    public static void main(String[] args) {
        Person person = new Person("Doe", "John", 20, true);
        System.out.println(person);
        person.addOneYearToAge();
        System.out.println(person);
    }
}
