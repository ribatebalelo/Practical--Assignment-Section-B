
package studentmanagementsystem;


public class Grade extends Course {
    private double score;
    
    public Grade(String courseId, String courseName, int credits, double score) {
        super(courseId, courseName, credits);
        this.score = score;
    }
    

    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public char getGradeLetter() {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }
    
    public double getGradePoints() {
        switch (getGradeLetter()) {
            case 'A': return 4.0;
            case 'B': return 3.0;
            case 'C': return 2.0;
            case 'D': return 1.0;
            default: return 0.0;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Score: " + score + ", Grade: " + getGradeLetter();
    }
}
