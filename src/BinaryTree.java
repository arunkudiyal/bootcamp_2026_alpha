class BinaryTree {
    static class Student {
        int rNo;
        String name;
        float score;
        String dept;
        // Constructor --> assigns value to class properties value
        // Non-Parameterised Constructor ---> Student() { }
        // Parameterised Constructor
        public Student(int rNo, String name, float score, String dept) {
            this.rNo = rNo;
            this.name = name;
            this.score = score;
            this.dept = dept;
        }
    }

    public static void main(String[] args) {
        // objects & reference variable
        // className objName = new Constructor();
        Student s1 = new Student(1, "Student One", 2.5f, "CSE");
        System.out.println(s1.score);
        Student s2 = new Student(2, "Student Two", 2.5f, "CSE");
        System.out.println(s2.name);

        // Reference Variable = new Constructor()
        // Student demo = null;
        // demo = new Student();
    }
}
