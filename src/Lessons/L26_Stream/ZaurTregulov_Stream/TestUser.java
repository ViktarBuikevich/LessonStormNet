package Lessons.L26_Stream.ZaurTregulov_Stream;

public class TestUser {
    public static void main(String[] args) {
        User user = new User();
        user.setReferalId(112L);
    }

    static class User {
        long id;
        User referal = new User();
        public void setReferalId(long referalId){
            this.referal.id=referalId;
        }
    }
}

