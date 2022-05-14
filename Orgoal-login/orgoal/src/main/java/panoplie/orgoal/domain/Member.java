package panoplie.orgoal.domain;

public class Member {

    private String id;
    private String nickname;
    private String password;
    private String question;
    private String answer;

    public Member(String id, String nickname, String password, String question, String answer) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {


        return "Member{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password.substring(0, 10) + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                "}\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}





