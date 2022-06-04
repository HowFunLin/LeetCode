package main.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class UniqueEmailAddresses {
    /**
     * 929. 独特的电子邮件地址
     *
     * @param emails 向每个 emails[i] 发送一封电子邮件
     * @return 实际收到邮件的不同地址数目
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < email.length(); i++) {
                // 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址
                if (email.charAt(i) == '.')
                    continue;

                // 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容
                if (email.charAt(i) == '+')
                    while (email.charAt(i) != '@')
                        i++;

                // 上述规则不适用于域名
                if (email.charAt(i) == '@') {
                    builder.append(email.substring(i));
                    break;
                }

                builder.append(email.charAt(i));
            }

            set.add(builder.toString());
        }

        return set.size();
    }
}
