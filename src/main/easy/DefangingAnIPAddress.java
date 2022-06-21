package main.easy;

@SuppressWarnings("unused")
public class DefangingAnIPAddress {
    /**
     * 1108. IP 地址无效化
     *
     * @param address 有效的 IPv4 地址
     * @return IP 地址的无效化版本。所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     */
    public String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        String str = "[.]";

        for (char c : address.toCharArray()) {
            if (c == '.')
                builder.append(str);
            else
                builder.append(c);
        }

        return builder.toString();
    }
}
