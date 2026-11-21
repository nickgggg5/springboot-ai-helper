import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 你想生成的明文密码
        String rawPassword = "123456";

        // 生成密文
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("=========== 生成结果 ===========");
        System.out.println("明文密码: " + rawPassword);
        System.out.println("加密密文: " + encodedPassword);
        System.out.println("===============================");
    }
}