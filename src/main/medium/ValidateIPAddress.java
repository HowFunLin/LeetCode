package main.medium;

@SuppressWarnings("unused")
public class ValidateIPAddress {
    /**
     * 468. 验证IP地址
     *
     * @return 如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither"
     */
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(":") && queryIP.contains("."))
            return "Neither";

        int len = queryIP.length();

        if (len > 0 &&
                (queryIP.charAt(0) == '.' ||
                        queryIP.charAt(len - 1) == '.' ||
                        queryIP.charAt(0) == ':' ||
                        queryIP.charAt(len - 1) == ':')
        ) // 防止 IP 地址前后存在 : 或 ;
            return "Neither";

        if (queryIP.contains(":")) { // IPv6
            String[] strs = queryIP.split(":");

            if (strs.length != 8)
                return "Neither";

            for (String str : strs) {
                int n = str.length();

                if (n < 1 || n > 4)
                    return "Neither";

                for (int i = 0; i < n; i++) {
                    char c = str.charAt(i);

                    if ((c > 'F' && c <= 'Z') || c > 'f')
                        return "Neither";
                }
            }

            return "IPv6";
        } else if (queryIP.contains(".")) { // IPv4
            String[] strs = queryIP.split("\\.");

            if (strs.length != 4)
                return "Neither";

            for (String str : strs) {
                int n = str.length();

                if (n > 1 && str.charAt(0) == '0' || n == 0) // 字符串不允许为空串
                    return "Neither";

                int num = 0;

                for (int i = 0; i < n; i++) {
                    char c = str.charAt(i);

                    if (!Character.isDigit(c))
                        return "Neither";

                    num *= 10;
                    num += c - '0';

                    if (num > 255) // 超出限制直接返回，后续叠加可能出现溢出导致错误结果
                        return "Neither";
                }
            }

            return "IPv4";
        }

        return "Neither";
    }
}
