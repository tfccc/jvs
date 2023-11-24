package pac01_Basics;


/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-25 11:47
 * @desc:
 **/
public class T22_Enum {

    public static void main(String[] args) {
        Status code = Status.PUB_FAILED;
        System.out.println(code);
    }

}


enum Status {
    PUB_SUCCESS(1, "³É¹¦"),
    PUB_FAILED(-1, "Ê§°Ü");

    private int code;
    private String desc;

    Status(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}