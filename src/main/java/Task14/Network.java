package Task14;

import java.util.ArrayList;

public class Network {
    public class Member { // Класс Member является внутренним
        // для класса Network
        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }
        public void leave(){
            members.remove(this);
        }
    }

    private ArrayList<Member> members;
    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
